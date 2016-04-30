package wonder4.wordplay2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    int Result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent=getIntent();
        Result=intent.getIntExtra("Score5",0);

        int sonuc= Result;

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        TextView t=(TextView)findViewById(R.id.textResult);

        bar.setNumStars(5);
        bar.setStepSize(1);
        bar.setRating(sonuc);

        switch (sonuc)
        {
            case 1: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:t.setText("aaaaaaaaa");
                break;
            case 4:t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 5:t.setText("Who are you? A trivia wizard???");
                break;
        }
    }
}
