package wonder4.wordplay2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Question3 extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private boolean isColor = false;
    private View view;
    private long lastUpdate;
    int Score3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        view = findViewById(R.id.linear3);
        view.setBackgroundColor(Color.YELLOW);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        Intent intent=getIntent();
        Score3 = intent.getIntExtra("Score2",0);

        final String answer = "BIRD";
        ImageButton rightarrow = (ImageButton)findViewById(R.id.right_arrow);
        ImageButton leftarrow = (ImageButton)findViewById(R.id.left_arrow);
        final Button answer1 = (Button)findViewById(R.id.answer_7);
        final Button answer2 = (Button)findViewById(R.id.answer_8);
        final Button answer3 = (Button)findViewById(R.id.answer_9);

        final ImageView imageView = new ImageView(getApplicationContext());
        final ImageView imageViewMad = new ImageView(getApplicationContext());
        Button homepagequiz3 = (Button)findViewById(R.id.gobegining_btn3);

        imageView.setImageResource(R.drawable.smile);
        imageViewMad.setImageResource(R.drawable.mad);

        homepagequiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Question3.this,MainActivity.class);
                startActivity(intent);
            }
        });

        answer1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button1_Text =  answer1.getText().toString();
                if(answer.equals(button1_Text)){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question3.this);
                    alertDialog.setView(imageView);
                    alertDialog.setInverseBackgroundForced(true);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question4.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question3.this);
                    alertDialog1.setView(imageViewMad);
                    alertDialog1.setInverseBackgroundForced(true);
                    alertDialog1.setCancelable(false);
                    alertDialog1.setPositiveButton("TRY AGAIN!!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question3.class);
                            int c = Score3;
                            intent.putExtra("Score3",c);
                            startActivity(intent);
                        }
                    });
                    alertDialog1.show();}

            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button2_Text =  answer2.getText().toString();
                if(answer.equals(button2_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question3.this);
                    alertDialog.setView(imageView);
                    alertDialog.setInverseBackgroundForced(true);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question4.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question3.this);
                    alertDialog1.setView(imageViewMad);
                    alertDialog1.setInverseBackgroundForced(true);
                    alertDialog1.setCancelable(false);
                    alertDialog1.setPositiveButton("TRY AGAIN!!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question3.class);
                            int c = Score3;
                            intent.putExtra("Score3",c);
                            startActivity(intent);
                        }
                    });
                    alertDialog1.show();}

            }

        });

        answer3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button3_Text = answer3.getText().toString();
                if(answer.equals(button3_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question3.this);
                    alertDialog.setView(imageView);
                    alertDialog.setInverseBackgroundForced(true);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question4.class);
                            int c = ++Score3;
                            intent.putExtra("Score3",c);


                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question3.this);
                    alertDialog1.setView(imageViewMad);
                    alertDialog1.setInverseBackgroundForced(true);
                    alertDialog1.setCancelable(false);
                    alertDialog1.setPositiveButton("TRY AGAIN!!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question3.this,Question3.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog1.show();}

            }

        });

        rightarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question3.this,Question4.class);
                int c = Score3;
                intent.putExtra("Score3",c);
                startActivity(intent);


            }

        });

        leftarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question3.this,Question2.class);
                int c = Score3;
                intent.putExtra("Score3",c);
                startActivity(intent);


            }

        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();


        if (accelationSquareRoot >= 2) //it will be executed if you shuffle
        {

            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;//updating lastUpdate for next shuffle
            if (isColor) {
                view.setBackgroundColor(Color.YELLOW);

            } else {
                view.setBackgroundColor(Color.GRAY);
            }
            isColor = !isColor;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
