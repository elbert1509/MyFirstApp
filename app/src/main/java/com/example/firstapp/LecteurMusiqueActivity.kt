package com.example.firstapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*

class LecteurMusiqueActivity : AppCompatActivity() {
    //--------------------------------------------------------------
    //                                  DECLARATION VARIABLES GLOBALE
    lateinit var mediaPlayer : MediaPlayer
    var positionMusique = 0
    lateinit var ivPlay : ImageView
    lateinit var imgMusic : ImageView
    lateinit var tvTitreMusique : TextView
    val rawUser = arrayOf(R.raw.olele,R.raw.amina,R.raw.babyshark,R.raw.happy,R.raw.aramsam)





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lecteur_musique)


        // initialisation des variables une fois que l'activite a été creer
        ivPlay = findViewById<ImageView>(R.id.imgPlay)
        imgMusic = findViewById<ImageView>(R.id.imgMusique)
        tvTitreMusique = findViewById<TextView>(R.id.textView)

        selection_musique()
    }

    private fun selection_musique() {


        val listView = findViewById<ListView>(R.id.lvMusiques)
        val playlist = generateMusic()
        var adapter = MusiqueAdapter(this,playlist)

        mediaPlayer = MediaPlayer.create(this,rawUser[0])

        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            positionMusique = 0
            ivPlay.setImageResource(android.R.drawable.ic_media_pause)

            imgMusic.setImageResource(playlist[position].image)
            tvTitreMusique.text = playlist[position].nom

            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.release()
            }
            mediaPlayer = MediaPlayer.create(this, rawUser[position])
            mediaPlayer.start()


            suivant(position)
            precedent(position)
            playPause(position)
            en_boucle(position)

            progress()
        }
    }

    fun playPause(position: Int)
    {
        ivPlay.setOnClickListener()
        {
            if(mediaPlayer.isPlaying)
            {
                ivPlay.setImageResource(android.R.drawable.ic_media_play)
                mediaPlayer.pause()
            }
            else
            {
                ivPlay.setImageResource(android.R.drawable.ic_media_pause)
                mediaPlayer.start()
            }
        }


    }

    fun precedent(position : Int)
    {
        var imgprecedent = findViewById<ImageView>(R.id.imgPrecedent)
        imgprecedent.setOnClickListener(){
            positionMusique -=1
            // si on est sur la premiere musique on passe a la derniere
            if ((position + positionMusique) < 0)
            {
                positionMusique = rawUser.size - position - 1
            }

            if(mediaPlayer.isPlaying)
            {
                mediaPlayer.stop()
                mediaPlayer.release()
            }
            mediaPlayer = MediaPlayer.create(this,rawUser[position+positionMusique])
            mediaPlayer.start()

            imgMusic.setImageResource(generateMusic()[position+positionMusique].image)
            tvTitreMusique.text = generateMusic()[position+positionMusique].nom
        }
    }

    fun en_boucle(position: Int) {
        val btnLoop = findViewById<ImageView>(R.id.imgBoucle)
        var boucle = 0
        btnLoop.setOnClickListener()
        {

            if (boucle>1)
                boucle = 0
            when(boucle){
                0 ->{
                    val Toast = Toast.makeText(applicationContext, "Loop activated on ${generateMusic()[position].nom}", Toast.LENGTH_SHORT).show()
                }
                1->{
                    val Toast = Toast.makeText(applicationContext, "Loop desactivated", Toast.LENGTH_SHORT).show()
                }
            }
            boucle++
            mediaPlayer.setLooping(!mediaPlayer.isLooping)
        }
    }


    fun progress() {
        val sbDureeMusique = findViewById<SeekBar>(R.id.sbDureeMusique)
        sbDureeMusique.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer.seekTo(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        initializeSeekBar(sbDureeMusique)
    }

    fun initializeSeekBar(seekBar: SeekBar)
    {
        seekBar.max = mediaPlayer.duration

        var handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    seekBar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 0)
                }catch (e :java.lang.Exception)
                {
                    seekBar.progress = 0
                }
            }
        },0)
    }


    fun suivant(position : Int)
    {
        var imgsuivant = findViewById<ImageView>(R.id.imgSuivant)
        imgsuivant.setOnClickListener(){
            positionMusique +=1
            // si on est sur la derniere musique on passe a la premiere

            if ((positionMusique + position) > rawUser.size - 1)
            {
                positionMusique = -position
            }

            if(mediaPlayer.isPlaying)
            {
                mediaPlayer.stop()
                mediaPlayer.release()
            }
            mediaPlayer = MediaPlayer.create(this,rawUser[position+positionMusique])
            mediaPlayer.start()

            imgMusic.setImageResource(generateMusic()[position+positionMusique].image)
            tvTitreMusique.text = generateMusic()[position+positionMusique].nom
        }
    }
    fun generateMusic() : ArrayList<MusiqueModel>
    {
        return arrayListOf(
            MusiqueModel(
                R.drawable.olele,
                "Olele Makasi",
                "2.08"
            ),
            MusiqueModel(
                R.drawable.amina,
                "Amina",
                "1.27"
            ),
            MusiqueModel(
                R.drawable.babyshark,
                "Baby shark",
                "1.22"
            ),
            MusiqueModel(
                R.drawable.happy,
                "happy",
                "04.22"
            ),
            MusiqueModel(
                R.drawable.aram,
                "Aram sam sam ",
                "04.22"
            ),
        )
    }


}