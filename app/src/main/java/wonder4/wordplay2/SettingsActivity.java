package wonder4.wordplay2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by erogacki on 4/28/16.
 */
public class SettingsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        final AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        // Mute and unmute music
        final Switch music = (Switch) findViewById(R.id.musicTog);
        music.setChecked(true);

        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
                else {
                    amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 1, 1);
                    Toast.makeText(getApplicationContext(), "Music turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });


/*
setWifiEnable?
            else
                tmanager.getDataState(TelephonyManager.DATA_CONNECTED);

*/

        final Switch notifications = (Switch) findViewById(R.id.noticeTog);
        notifications.setChecked(true);
        notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    notifications.setChecked(true);
                else {
                    notifications.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Notifications turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button home = (Button) findViewById(R.id.homeBtn_Set);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
