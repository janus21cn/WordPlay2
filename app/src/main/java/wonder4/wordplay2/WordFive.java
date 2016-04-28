package wonder4.wordplay2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

        Button homeBtn = (Button) findViewById(R.id.btn_home5);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final Intent mainIntent = new Intent(WordFive.this, WordOne.class);
                        WordFive.this.startActivity(mainIntent);
                       WordFive.this.finish();
                    }
                }, 1000);
            }
        });

        Button leftBtn = (Button) findViewById(R.id.btn_left5);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final Intent mainIntent = new Intent(WordFive.this, MainActivity.class);
                        WordFive.this.startActivity(mainIntent);
                        WordFive.this.finish();
                    }
                }, 1000);
            }
        });

        Button rightBtn = (Button) findViewById(R.id.btn_right);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final Intent mainIntent = new Intent(WordFive.this, WordOne.class);
                        WordFive.this.startActivity(mainIntent);
                        WordFive.this.finish();
                    }
                }, 1000);
            }
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
            imgView = (ImageView)findViewById(R.id.imageView5);
            if(value<100){
                animation = AnimationUtils.loadAnimation(WordFive.this, R.anim.translate);
                imgView.startAnimation(animation);
            }else{
                wordone.setBackgroundResource(R.drawable.bg2);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
}
