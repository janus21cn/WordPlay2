package wonder4.wordplay2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by erogacki on 4/28/16.
 */
public class Help_Page extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button feedback = (Button) findViewById(R.id.f_backbutton);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    //    Button devWebsite = (Button) findViewById(R.id.dev_WebSite);


    }
}