package com.ssstor.guesslocation.ui.playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.databinding.FragmentPlaygroundBinding


class PlaygroundFragment : Fragment(), YouTubePlayerListener {
    private var _vb: FragmentPlaygroundBinding? = null
    private val vb get() = _vb!!
    var displayHeight: Int = 0
    var displayWidth: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vb = FragmentPlaygroundBinding.inflate(inflater, container, false)

        return vb.root
    }

    override fun onStart() {
        super.onStart()
        val videoPath:String = App.currentPageLevelsList[App.currentLevelId-1].levelVideoPath
        playVideoByPath( videoPath)
    }

   private fun playVideoByPath(path: String) {
       val iFramePlayerOptions: IFramePlayerOptions = IFramePlayerOptions.Builder()
           .controls(0)
           .ivLoadPolicy(3)
           .ccLoadPolicy(1)
           .build()
       vb.pgYoutubePlayer?.initialize(this, true, iFramePlayerOptions)
       vb.pgYoutubePlayer?.enterFullScreen()

    }

    companion object {
        fun newInstance() = PlaygroundFragment()
    }

    override fun onApiChange(youTubePlayer: YouTubePlayer) {

    }

    override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {

    }

    override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {

    }

    override fun onPlaybackQualityChange(
        youTubePlayer: YouTubePlayer,
        playbackQuality: PlayerConstants.PlaybackQuality
    ) {

    }

    override fun onPlaybackRateChange(
        youTubePlayer: YouTubePlayer,
        playbackRate: PlayerConstants.PlaybackRate
    ) {

    }

    override fun onReady(youTubePlayer: YouTubePlayer) {
        youTubePlayer.loadVideo("unSFkZQiqDs",0F)
    }

    override fun onStateChange(youTubePlayer: YouTubePlayer, state: PlayerConstants.PlayerState) {

    }

    override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {

    }

    override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {

    }

    override fun onVideoLoadedFraction(youTubePlayer: YouTubePlayer, loadedFraction: Float) {

    }


}