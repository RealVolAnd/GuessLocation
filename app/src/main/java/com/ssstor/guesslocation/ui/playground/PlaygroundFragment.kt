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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.databinding.FragmentPlaygroundBinding
import com.ssstor.guesslocation.screens.AndroidScreens


class PlaygroundFragment : Fragment(), YouTubePlayerListener {
    private var _vb: FragmentPlaygroundBinding? = null
    private val vb get() = _vb!!
    private lateinit var playerTracker: YouTubePlayerTracker
    private lateinit var youtubePlayer: YouTubePlayer
    private var isPlayerMuted = false
    private var currentPlayerSpeed = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vb = FragmentPlaygroundBinding.inflate(inflater, container, false)
        setListeners()
        return vb.root
    }

    private fun setListeners() {
        vb.pgBackToMenuButton.setOnClickListener {
            App.instance.router.navigateTo(AndroidScreens().home())
        }

        vb.pgRestartButton.setOnClickListener {
            youtubePlayer.seekTo(0F)
        }

        vb.pgMuteButton.setOnClickListener {
            togglePlayerMute()
        }
        vb.pgSpeedButton.setOnClickListener {
            togglePlayerSpeed()
        }

        vb.pgTenSecBackButton.setOnClickListener {
            val tmpSeconds = playerTracker.currentSecond
            var targetSeconds = 0F
            if (tmpSeconds - 10F > 0) targetSeconds = tmpSeconds - 10F
            youtubePlayer.seekTo(targetSeconds)
        }
    }

    private fun togglePlayerMute() {
        if (isPlayerMuted) {
            youtubePlayer.unMute()
            isPlayerMuted = false
            vb.pgMuteButton.text = "Mute"
        } else {
            youtubePlayer.mute()
            isPlayerMuted = true
            vb.pgMuteButton.text = "Unmute"
        }
    }

    private fun togglePlayerSpeed() {
        currentPlayerSpeed++
        if (currentPlayerSpeed == 1) {
            youtubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_1_5)
            vb.pgSpeedButton.text = "Rate 1.5x"
        } else if (currentPlayerSpeed == 2) {
            youtubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_2)
            vb.pgSpeedButton.text = "Rate 2x"
        } else if (currentPlayerSpeed == 3) {
            currentPlayerSpeed = 0
            youtubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_1)
            vb.pgSpeedButton.text = "Rate 1x"
        }
    }

    override fun onStart() {
        super.onStart()
        val videoPath: String = App.currentPageLevelsList[App.currentLevelId - 1].levelVideoPath
        playVideoByPath(videoPath)
    }

    override fun onDestroy() {
        vb.pgYoutubePlayer?.release()
        super.onDestroy()
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
        playerTracker = YouTubePlayerTracker()
        youtubePlayer = youTubePlayer
        youtubePlayer.addListener(playerTracker)
        youtubePlayer.loadVideo("__Eo-dvEH7g", 0F)
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