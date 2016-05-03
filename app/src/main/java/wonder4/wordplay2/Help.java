package wonder4.wordplay2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {

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

            }
        });

        Button priPolicy = (Button) findViewById(R.id.privacy_policy);
        priPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button ratebtn = (Button) findViewById(R.id.rate_btn);
        ratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}

