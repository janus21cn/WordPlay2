package wonder4.wordplay2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    int Result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button gohome = (Button)findViewById(R.id.gobegining_btn);
        Intent intent=getIntent();
        Result=intent.getIntExtra("Score5",0);

        int sonuc= Result;

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        TextView t=(TextView)findViewById(R.id.textResult);

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(Result.this,MainActivity.class);
                startActivity(goback);
            }
        });


        bar.setNumStars(5);
        bar.setStepSize(1);
        bar.setRating(sonuc);

        switch (sonuc)
        {
            case 1: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 4:t.setText("Hmmmm.. Someone's been reading a lot");
                break;
            case 5:t.setText("Well Done.. You are Great!!!");
                break;
        }
    }
}
