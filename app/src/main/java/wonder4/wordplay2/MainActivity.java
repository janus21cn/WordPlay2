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

        Button GotoQuiz = (Button)findViewById(R.id.btn_quiz);

        playBtn.setOnClickListener(new View.OnClickListener() {
        Button drawBtn = (Button) findViewById(R.id.btn_draw);
        drawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WordOne.class);
                startActivity(intent);
            }
        });


        GotoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Question1.class);
                startActivity(intent);
            }
        });


    }



}
