package wonder4.wordplay2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        Switch gameVoice = (Switch) findViewById(R.id.gameVoiceTog);
            if (gameVoice.isChecked()==true)
                wordsound.setVolume(0,0);
            else
                wordsound.setVolume(1,0);
        Switch music = (Switch) findViewById(R.id.musicTog);

        Switch cellData = (Switch) findViewById(R.id.cellTog);
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
