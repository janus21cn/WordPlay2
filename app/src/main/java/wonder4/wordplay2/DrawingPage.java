package wonder4.wordplay2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Jonathan on 4/28/2016.
 */
public class DrawingPage extends AppCompatActivity {

    private DrawingView drawView;
    private ImageButton currPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_page);

        drawView = (DrawingView)findViewById(R.id.drawing);

        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);

        currPaint = (ImageButton) paintLayout.getChildAt(0);

        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
    }

    public void paintClicked(View view){
        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();

            drawView.setColor(color);

            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }
    }

}
