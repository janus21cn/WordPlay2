package wonder4.wordplay2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WordOne extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_one);

        initWithLight();
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
            if(value<100){
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
