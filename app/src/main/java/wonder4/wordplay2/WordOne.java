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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WordOne extends AppCompatActivity {

    private SensorManager sensorManager;
    private Animation animation;
    String[] words={"Boy","Dog","Duck","Bird","Elephant"};
    String[] imgs={"boy","dog", "duckw","bird","elephant"};
    String[] sounds={"boy","dog", "duck","bird","elepha"};
    String wd;
    public int i=1;
    ImageView img;
    MediaPlayer wordsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_one);

        initWithLight();

        img= (ImageView) findViewById(R.id.imageView1);

        wordsound = MediaPlayer.create(WordOne.this, R.raw.boy);
        Button englishBtn = (Button) findViewById(R.id.btn_english);
        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordsound.start();            }
        });

        Button rightBtn = (Button) findViewById(R.id.btn_right);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
                if(i<5){
                    wd=words[i];
                    int imgID = getResources().getIdentifier(imgs[i] , "drawable", getPackageName());
                    int soundID = getResources().getIdentifier(sounds[i] , "raw", getPackageName());
                    wordsound= MediaPlayer.create(WordOne.this, soundID);
                    img.setImageResource(imgID);
                    ((TextView)findViewById(R.id.w1)).setText(words[i]);
                    i++;
                }else{
                    img.clearAnimation();
                    Intent intent = new Intent(WordOne.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button leftBtn = (Button) findViewById(R.id.btn_left);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
                if(i>0){
                    i--;
                    wd=words[i];
                    int imgID = getResources().getIdentifier(imgs[i] , "drawable", getPackageName());
                    int soundID = getResources().getIdentifier(sounds[i] , "raw", getPackageName());
                    wordsound= MediaPlayer.create(WordOne.this, soundID);
                    img.setImageResource(imgID);
                    ((TextView)findViewById(R.id.w1)).setText(words[i]);

                }else{
                    img.clearAnimation();
                    Intent intent = new Intent(WordOne.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        Button homeBtn = (Button) findViewById(R.id.btn_home);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
                Intent intent = new Intent(WordOne.this, MainActivity.class);
                startActivity(intent);
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
            if(value<=5){
                wordone.setBackgroundResource(R.drawable.bgnight);
                animation = AnimationUtils.loadAnimation(WordOne.this, R.anim.translate);
                img.startAnimation(animation);

            }else if(value<100){
                animation = AnimationUtils.loadAnimation(WordOne.this, R.anim.rotate);
                img.startAnimation(animation);
            }else {
                wordone.setBackgroundResource(R.drawable.bgsun);
                animation = AnimationUtils.loadAnimation(WordOne.this, R.anim.scale);
                img.startAnimation(animation);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}
