package com.adodge.sample.videoeverything

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()
    }

    fun playVideo() {
        val player: SimpleExoPlayer = SimpleExoPlayer.Builder(applicationContext).build()

        // Bind the player to the view.
        val playerView = this.findViewById<StyledPlayerView>(R.id.player_view);

        // Build the media item.
        val mediaItem: MediaItem = MediaItem.fromUri("http://10.0.2.2:9000/sol-levante/master.m3u8")
//        val mediaItem: MediaItem = MediaItem.fromUri("https://c3de9703f5e8.ngrok.io/sol-levante/master.m3u8")

        // Set the media item to be played.
        player.setMediaItem(mediaItem)

        // Prepare the player.
        player.prepare()

        // Attach the player and start the playback.
        playerView?.let {
            it.player = player
            player.play()
        }
    }
}
