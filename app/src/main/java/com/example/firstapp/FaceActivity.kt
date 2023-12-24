package com.example.firstapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.firstapp.databinding.ActivityFaceBinding
import com.google.ar.core.AugmentedFace
import com.google.ar.core.TrackingState
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.AugmentedFaceNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.Texture
import java.util.concurrent.CompletableFuture

class FaceActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityFaceBinding.inflate(layoutInflater)
    }


    private var faceRenderable: ModelRenderable? = null
    private var faceTexture: Texture? = null
    private val faceNodeMap = HashMap<AugmentedFace, AugmentedFaceNode>()
    private lateinit var arFragment: ArFragment
    private var source: Int = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        source = when (intent.getStringExtra("source")){
            "sample1" -> R.raw.blue_sunglasses

            else -> R.raw.black
        }
        loadModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.face_frag) as ArFragment
        arFragment.arSceneView.cameraStreamRenderPriority = Renderable.RENDER_PRIORITY_FIRST
               arFragment.arSceneView.scene.addOnUpdateListener {
                   if (faceRenderable != null && faceTexture != null) {
                       addTrackedFaces()
                       removeUntrackedFaces()
                   }
               }
    }




    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadModel() {

        val modelRenderable = ModelRenderable.builder().setSource(this,source).build()
        val texture = Texture.builder().setSource(this, R.drawable.clown_face_mesh_texture).build()

        CompletableFuture.allOf(modelRenderable, texture).thenAccept {
            faceRenderable = modelRenderable.get().apply {
                isShadowCaster = false
                isShadowReceiver = false
            }
            faceTexture = texture.get()
        }.exceptionally {
            Toast.makeText(this, "Error loading face model : $it", Toast.LENGTH_SHORT).show()
            null
        }
    }



    private fun addTrackedFaces() {
        val session = arFragment.arSceneView.session ?: return
        val faceList = session.getAllTrackables(AugmentedFace::class.java)
        for (face in faceList) {
            if (!faceNodeMap.containsKey(face)) {
                AugmentedFaceNode(face).apply {
                    setParent(arFragment.arSceneView.scene)
                    faceRegionsRenderable = faceRenderable
                    faceMeshTexture = faceTexture
                    faceNodeMap[face] = this
                }
            }
        }
    }

    private fun removeUntrackedFaces() {
        val entries = faceNodeMap.entries
        for (entry in entries) {
            val face = entry.key
            if (face.trackingState == TrackingState.STOPPED) {
                val faceNode = entry.value
                faceNode.setParent(null)
                entries.remove(entry)
            }
        }
    }

}