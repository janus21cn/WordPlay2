package wonder4.wordplay2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WordFive extends AppCompatActivity {

    private SensorManager sensorManager;
    private ImageView imgView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_five);

        initWithLight();

        imgView = (ImageView)findViewById(R.id.imageView5);
        Button leftBtn = (Button) findViewById(R.id.btn_left5);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordFive.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button homeBtn = (Button) findViewById(R.id.btn_home5);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordFive.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final MediaPlayer catsound = MediaPlayer.create(WordFive.this, R.raw.cat);
        Button englishBtn = (Button) findViewById(R.id.btn_english5);
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
            RelativeLayout wordfive = (RelativeLayout)findViewById(R.id.wordfive);
            if(value<50){
                animation = AnimationUtils.loadAnimation(WordFive.this, R.anim.translate);
                imgView.startAnimation(animation);

            }else{

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}