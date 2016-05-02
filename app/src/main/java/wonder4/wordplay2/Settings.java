package wonder4.wordplay2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by erogacki on 4/28/16.
 */
public class Settings extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        // Mute and unmute voice and music
        Switch gameVoice = (Switch) findViewById(R.id.gameVoiceTog);
            if (gameVoice.isChecked()==true)
                amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,0);
            else
                amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 1,1);

        Switch music = (Switch) findViewById(R.id.musicTog);
        if (music.isChecked()==true)
            amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,0);
        else
            amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 1,1);


/*
        TelephonyManager tmanager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        Switch cellData = (Switch) findViewById(R.id.cellTog);
            if (cellData.isChecked()==true) {
               // 2 = data connected
               // 0 = data disconnected
                tmanager.
            }


            else
                tmanager.getDataState(TelephonyManager.DATA_CONNECTED);

*/

        Switch notifications = (Switch) findViewById(R.id.noticeTog);

        Button home = (Button) findViewById(R.id.homeBtn_Set);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
