package wonder4.wordplay2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Question5 extends AppCompatActivity {
    int Score5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Intent intent=getIntent();
        Score5 = intent.getIntExtra("Score4",0);

        final String answer = "DUCK";

        ImageButton leftarrow = (ImageButton)findViewById(R.id.left_arrow);
        final Button answer1 = (Button)findViewById(R.id.answer_13);
        final Button answer2 = (Button)findViewById(R.id.answer_14);
        final Button answer3 = (Button)findViewById(R.id.answer_15);

        answer1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button1_Text =  answer1.getText().toString();
                if(answer.equals(button1_Text)){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question5.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Result Page", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question5.this,Result.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question5.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button2_Text =  answer2.getText().toString();
                if(answer.equals(button2_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question5.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Result Page", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question5.this,Result.class);
                            int e = ++Score5;
                            intent.putExtra("Score5",e);


                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question5.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }

        });

        answer3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String button3_Text = answer3.getText().toString();
                if(answer.equals(button3_Text)){AlertDialog.Builder alertDialog=new AlertDialog.Builder(Question5.this);
                    alertDialog.setMessage("Correct Answer");
                    alertDialog.setPositiveButton("Go to Result Page", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Question5.this,Result.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }else {
                    AlertDialog.Builder alertDialog1=new AlertDialog.Builder(Question5.this);
                    alertDialog1.setMessage("Wrong Answer");
                    alertDialog1.show();}

            }

        });


        leftarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question5.this,Question4.class);
                startActivity(intent);


            }

        });

    }
}
