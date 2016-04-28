package wonder4.wordplay2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WordOne extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_one);

        initWithLight();

        Button leftBtn = (Button) findViewById(R.id.btn_left);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordOne.this, WordFive.class);
                startActivity(intent);
            }
        });
        Button homeBtn = (Button) findViewById(R.id.btn_home);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final MediaPlayer catsound = MediaPlayer.create(WordOne.this, R.raw.cat);
        Button englishBtn = (Button) findViewById(R.id.btn_english);
        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catsound.start();            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }
    }

    public void initWithLight() {
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float value = sensorEvent.values[0];
            RelativeLayout wordone = (RelativeLayout)findViewById(R.id.wordone);
            if(value<50){
                wordone.setBackgroundResource(R.drawable.word1c);
            }else{
                wordone.setBackgroundResource(R.drawable.word1);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}
