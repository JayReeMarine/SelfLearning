package com.fit2081.week4lecturefollowing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    TextView textView;

    public static final String TAG="Week_5_lec_tag";

    GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.results_id);

        counter =0;
        View greenView= findViewById(R.id.green_view_id);
        View redView = findViewById(R.id.red_view_id);
        View blueView = findViewById(R.id.blue_view_id);

        mDetector= new GestureDetectorCompat(this, new MyGestureListener());

//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                counter++;
//                textView.setText(String.valueOf(counter));
//            }
//        });

        greenView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int eventType=motionEvent.getActionMasked();
                int x = (int)motionEvent.getX();
                int y = (int)motionEvent.getY();
                textView.setText("Green");

                switch (eventType){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG,"Touch Down"+"(X="+x+", Y="+y+")");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG,"Touch Move"+"(X="+x+", Y="+y+")");
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d(TAG,"Touch up"+"(X="+x+", Y="+y+")");
                        break;
                }

                return true;
            }
        });

        blueView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                textView.setText("BLUE");
                mDetector.onTouchEvent(event);
                return true;
                //if it's false it will move on to the next view so always put return true
            }
        });

        redView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textView.setText("Red");
                return true;
            }
        });




    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        textView.setText("ACTIVITY");
        return true;
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e){
            textView.setText("Double tap");
            //saveItem
            //saveinvoice
            return true;
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e){
            textView.setText("Long press");
        }
        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e){
            textView.setText("sinlge press");
            return true;
        }


        @Override
        public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {

            if(distanceX<1)
                textView.setText("vertical scrolling");
            else if(distanceY<1){
                textView.setText("Horizontal scrolling");
            }
            return true;
        }
    }
}