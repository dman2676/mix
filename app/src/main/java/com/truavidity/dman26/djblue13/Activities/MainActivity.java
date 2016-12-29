package com.truavidity.dman26.djblue13.Activities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.truavidity.dman26.djblue13.Fragment.Hotmix;
import com.truavidity.dman26.djblue13.Fragment.MainFragment;
import com.truavidity.dman26.djblue13.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener,Hotmix.HotMixFragmentInteractionListener {

     MediaPlayer song;
    int pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }




    }
    public void pickMix(){

    }




    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }
    public void play(View view){

        if(song == null){
            song = MediaPlayer.create(this , R.raw.djbluehouse);
            song.start();
            Toast.makeText(MainActivity.this, "Song Play", Toast.LENGTH_SHORT).show();    }

        else if(!song.isPlaying()){
            song.seekTo(pause);
            song.start();
            Toast.makeText(MainActivity.this, "Song Play", Toast.LENGTH_SHORT).show();     }


}
    public void pause(View view){
        if(song!= null){
            song.pause();
            pause = song.getCurrentPosition();
            Toast.makeText(MainActivity.this, "Song Pause", Toast.LENGTH_SHORT).show();
        }
    }
    public void stop(View view){

        song.stop();
        song = null;
        Toast.makeText(MainActivity.this, "Song Stop", Toast.LENGTH_SHORT).show();
    }

  //  Fragment fragment = new SalesFragment();

   // FragmentManager fragmentManager = getFragmentManager();

 //   fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

    @Override
    public void onHotMixFragmentInteraction(Uri uri) {

    }
}
