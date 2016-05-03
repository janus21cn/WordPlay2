package wonder4.wordplay2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PWord_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pword_page);

// Create TextView to display random number word "numbers"
            final TextView word_numberview = (TextView) findViewById(R.id.word_password);
// Button to initiate random number for String "numbers"
            Button pushbtn = (Button) findViewById(R.id.get_word_btn);
// Create EditText for input of numeral to represent "numbers"
            final EditText number_view = (EditText) findViewById(R.id.number_password);
// Button to initiate check of valid numeral entry and start of intent if valid
            Button enterbtn =(Button) findViewById(R.id.enter_pwbtn);
// Declaration of arrays and random number generator
            final String number[]= new String[0];

            final String[] numbers = {"Ninety-Two", "Eighty-Seven", "Twenty-Four", "Fifty-Six", "Sixty-One", "Seventy-Eight", "Fifteen", "Forty-Three", "Thirty-Nine", "Five"};

            final String[] number_numbers = {"92", "87", "24", "56", "61", "78", "15", "43", "39", "5"};

            final int rando = (int) ((Math.random() * 9));


            Log.d("numbers[rando]", "numbers[rando] = "+ numbers[rando]);
            Log.d("number_numbers[rando]", "number_numbers[rando] = "+ number_numbers[rando]);
// OnClick to get and post in TextView
            pushbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    word_numberview.setText(numbers[rando]);

                }
            });
// On click to check entry validity and send to next page or make a toast to indicate invalid entry
       // number [0] = number_numbers[rando];
        assert enterbtn != null;
        enterbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Log.d("number[0]", "number[0] = "+ number[0]);
                    //number[0] = number_numbers[rando];
                    if (!(number_view.getText().toString().equals(" ")) && number_view.getText().toString().equals(number_numbers[rando])){
                        Intent intent = new Intent(PWord_page.this, SettingsActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "invalid response", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }


