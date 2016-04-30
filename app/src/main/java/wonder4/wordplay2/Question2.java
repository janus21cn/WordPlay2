package wonder4.wordplay2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Question2 extends AppCompatActivity {

    int Score2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intent=getIntent();
        Score2 = intent.getIntExtra("Score",0);


        final String answer = "CAT";
        ImageButton rightarrow = (ImageButton)findViewById(R.id.right_arrow);
        ImageButton leftarrow = (ImageButton)findViewById(R.id.left_arrow);
        final Button answer1 = (Button)findViewById(R.id.answer_4);
        final Button answer2 = (Button)findViewById(R.id.answer_5);
        final Button answer3 = (Button)findViewById(R.id.answer_6);

        answer1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button1_Text =  answer1.getText().toString();
                if(answer.equals(button1_Text)){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question2.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question2.this,Question3.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question2.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button2_Text =  answer2.getText().toString();
                if(answer.equals(button2_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question2.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question2.this,Question3.class);
                            int b = ++Score2;
                            intent.putExtra("Score2",b);
                            startActivity(intent);

                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question2.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }

        });


        answer3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button3_Text = answer3.getText().toString();
                if(answer.equals(button3_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question2.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question2.this,Question3.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question2.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }

        });

        rightarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question2.this,Question3.class);
                startActivity(intent);


            }

        });

        leftarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question2.this,Question1.class);
                startActivity(intent);


            }

        });
    }
}
