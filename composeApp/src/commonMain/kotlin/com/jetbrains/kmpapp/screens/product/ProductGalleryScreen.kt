/*
package com.beeshop.app.ui.module.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.media3.common.MediaItem
import com.beeshop.app.utils.player.rememberManagedExoPlayer
import com.github.fengdai.compose.media.Media
import com.github.fengdai.compose.media.ResizeMode
import com.github.fengdai.compose.media.ShowBuffering
import com.github.fengdai.compose.media.SurfaceType
import com.github.fengdai.compose.media.rememberMediaState
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun ProductGalleryScreen() {
    val url="https://storage.googleapis.com/downloads.webmproject.org/av1/exoplayer/bbb-av1-480p.mp4"
    val player by rememberManagedExoPlayer()
    val state = rememberMediaState(player = player)

    val mediaItem = remember(url) { MediaItem.Builder().setMediaId(url).setUri(url).build() }
    Media(
        state = state,
        // following parameters are optional
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        surfaceType = SurfaceType.SurfaceView,
        resizeMode = ResizeMode.Fit,
        keepContentOnPlayerReset = false,
        useArtwork = true,
        showBuffering = ShowBuffering.Always,
        buffering = {
            Box(Modifier.fillMaxSize(), Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    ) { state ->

    }

    LaunchedEffect(key1 = Unit, block = {
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    })
}*/
