package wonder4.wordplay2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView ratingValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button feedback = (Button) findViewById(R.id.f_backbutton);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, FeedBack.class);
                startActivity(intent);

            }
        });

        Button devWebsite = (Button) findViewById(R.id.dev_Website);
        devWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://https://github.com"));
                startActivity(intent);
            }
        });


        Button priPolicy = (Button) findViewById(R.id.privacy_policy);
        priPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, PrivacyPolicy.class);
                startActivity(intent);

            }
        });

        Button homepage = (Button) findViewById(R.id.homepage_btnSetting) ;
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //adapted from Android Rating Bar Example http://javarticles.com/2015/04/android-rating-bar-example.html
        ratingBar=(RatingBar) findViewById(R.id.ratingBar);
        ratingValue = (TextView) findViewById(R.id.rating_result);
        ratingValue.setText(String.valueOf(ratingBar.getRating()));

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue.setText(String.valueOf(rating));
            }
        });




    }
}

