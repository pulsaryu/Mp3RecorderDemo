package me.yuxing.mp3recorderdemo;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.buihha.audiorecorder.Mp3Recorder;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;


/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/

public class MyActivity extends Activity {

    private boolean isRecording;
    private AudioRecord audioRecord;
    private OutputStream output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Mp3Recorder recorder = new Mp3Recorder();

        (findViewById(R.id.record)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    recorder.startRecording();
                } catch(IOException e) {
                    Log.d("MainActivity", "Start error");
                }
            }
        });

        (findViewById(R.id.stop)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    recorder.stopRecording();
                } catch(IOException e) {
                    Log.d("MainActivity", "Stop error");
                }
            }
        });

    }
}
