package com.fit2081.week6_lecture_following;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MainActivity extends AppCompatActivity  {

    public static final String TAG="week6_final_lec";

    int counter;
    View frameLayout;
    GestureDetector detector;

    ScaleGestureDetector scaleGestureDetector;
    boolean isScaleGoing=false;

    int pointerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;

        detector=new GestureDetector(this,new MyGestureListener());
        scaleGestureDetector = new ScaleGestureDetector(this,new MyScaleGestureImpl());

        frameLayout = findViewById(R.id.frameLayout);
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x=(int)event.getX();

                pointerId=event.getPointerId(1);
                int index=event.findPointerIndex(pointerId);
                x = (int)event.getX(index);
//                detector.onTouchEvent(event);
                scaleGestureDetector.onTouchEvent(event);

//                int eventType = event.getActionMasked();
//                switch (eventType){
//                    case MotionEvent.ACTION_DOWN:
//                        Log.d(TAG, "down");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        Log.d(TAG, "up");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        Log.d(TAG, "Move");
//                        break;
//                }

                return true;
            }
        });

    }

    class MyScaleGestureImpl extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScaleBegin(@NonNull ScaleGestureDetector detector) {
            Log.d(TAG,"Scale Begin");
            isScaleGoing=true;
            return true;
        }

        @Override
        public boolean onScale(@NonNull ScaleGestureDetector detector) {
            Log.d(TAG,"On scale");
            return true;
        }

        @Override
        public void onScaleEnd(@NonNull ScaleGestureDetector detector) {
            Log.d(TAG,"Scale end");
            isScaleGoing=false;
        }
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            Log.d(TAG,"Long press");
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            Log.d(TAG,"Double Tap conv");
            if(!isScaleGoing){
                //do your logic
            }
            return true;
        }

        @Override
        public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
            counter ++;
            Log.d(TAG,String.format("dis-X=%d, dis-y=%d",((int)distanceX),((int)distanceY)));
            return true;
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG,"gogo");
            return true;
        }
    }


    class MyGestureListenerImpl implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(@NonNull MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            Log.d(TAG,"Long press-Imp;");
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }
}