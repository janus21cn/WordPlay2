package wonder4.wordplay2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Addapted from How to send Email from Android www.mkyong.com/android/how-to-sendemail-in-android
        EditText emailMessage = (EditText) findViewById(R.id.feedback_message);

        Button feedBack = (Button) findViewById(R.id.btn_feedback);
        

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });

    }


        //Start a new activity for sending a feedback emailAdded Feed
        private void sendFeedback() {
            final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
            _Intent.setData(Uri.parse("mailto:"));
            _Intent.setType("text/html");
            _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
            _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
            _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
            startActivity(_Intent.createChooser(_Intent, "Choose an Email Client :"));
            finish();
        }

    }


