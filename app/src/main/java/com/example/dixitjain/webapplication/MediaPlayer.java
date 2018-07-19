package com.example.dixitjain.webapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MediaPlayer extends YouTubeBaseActivity {

    //VideoView youtubepalyerView;
    YouTubePlayerView youtubepalyerView ;
    YouTubePlayer.OnInitializedListener youtubeListener;
    Button playButton ;

    private static final String API_KEY = "AIzaSyDJJPl1ph48EfPt0vJ_bmZo4tWK_WjoXEI";


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        youtubepalyerView = findViewById(R.id.videoView);
        playButton = findViewById(R.id.playYoutube);

        youtubeListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadPlaylist("PLgspcG46J4mzLJI5O6lp5relrKhLxgtip");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                youtubepalyerView.initialize(API_KEY, youtubeListener);

            }
        });


    }
}
