package wonder4.wordplay2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playBtn = (Button) findViewById(R.id.btn_Play);
        playBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this, WordOne.class);
                   startActivity(intent);
               }
           });

        Button drawBtn = (Button) findViewById(R.id.btn_draw);
        drawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawingPage.class);
                startActivity(intent);
            }
        });

        Button GotoQuiz = (Button)findViewById(R.id.btn_quiz);
        GotoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Question1.class);
                startActivity(intent);
            }
        });

        Button GotoSettings = (Button)findViewById(R.id.btn_settings);
        GotoSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Password_page.class);
                startActivity(intent);
            }
        });


    }



}
