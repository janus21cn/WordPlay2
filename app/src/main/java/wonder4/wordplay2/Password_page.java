package wonder4.wordplay2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by erogacki on 4/21/16.
 */
public class Password_page extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Create TextView to display random number word "numbers"
        final TextView word_numberview = (TextView) findViewById(R.id.word_password);
// Button to initiate random number for String "numbers"
        Button pushbtn = (Button) findViewById(R.id.get_word_btn);
// Create EditText for input of numeral to represent "numbers"
        final EditText number_view = (EditText) findViewById(R.id.number_password);
// Button to initiate check of valid numeral entry and start of intent if valid
        Button enterbtn =(Button) findViewById(R.id.enter_pwbtn);
// Declaration of arrays and random number generator
        final String[] number = new String[0];

        final String[] numbers = {"Ninety-Two", "Eighty-Seven", "Twenty-Four", "Fifty-Six", "Sixty-One", "Seventy-Eight", "Fifteen", "Forty-Three", "Thirty-Nine", "Five"};

        final String[] number_numbers = {"92", "87", "24", "56", "61", "78", "15", "43", "39", "5"};

        final int rando = (int) ((Math.random() * 10) + 1);
// OnClick to get and post in TextView
        pushbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                word_numberview.setText(numbers[rando]);
            }
        });
// On click to check entry validity and send to next page or make a toast to indicate invalid entry
        enterbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number[0] = number_numbers[rando];
                if (!(number_view.getText().toString().equals(" ")) && number_view.getText().toString().equals(number[0])){
                            Intent intent = new Intent(Password_page.this, Settings.class);
                            startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "invalid response", Toast.LENGTH_SHORT).show();
                }

            }
    });

    }
}
