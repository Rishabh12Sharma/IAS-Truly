package com.example.iastruly

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.VideoView


class VideoActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var playPauseButton: Button
    private lateinit var seekBar: SeekBar
    private lateinit var showHandoutButton: Button

    private var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        videoView = findViewById(R.id.videoView)
        playPauseButton = findViewById(R.id.playPauseButton)
        seekBar = findViewById(R.id.seekBar)
        //pdfView = findViewById(R.id.pdfView)
        showHandoutButton = findViewById(R.id.showHandoutButton)

        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.ias_video_new)

        videoView.setVideoURI(videoUri)

        playPauseButton.setOnClickListener {
            if (isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
            isPlaying = !isPlaying
        }

        videoView.setOnPreparedListener { mediaPlayer ->
            seekBar.max = mediaPlayer.duration
        }

        videoView.setOnCompletionListener {
            isPlaying = false
        }

        videoView.setOnErrorListener { mediaPlayer, _, _ ->
            mediaPlayer.reset()
            isPlaying = false
            false
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // No action needed here
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // No action needed here
            }
        })

        showHandoutButton.setOnClickListener {
            val intent=Intent(this,PDFActivity::class.java)
            startActivity(intent)
        }

    }


}