package com.sharmaumang.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    ImageView mImageView;
    Random mRandom = new Random();
    int lastPosition, newPosition;
    float pivotX,pivotY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.imageView);
        mButton=findViewById(R.id.button);
    }

    public void Spin (View view){

        newPosition = mRandom.nextInt(36000);

        pivotX = mImageView.getPivotX();
        pivotY = mImageView.getPivotY();

        Animation rotate = new RotateAnimation(lastPosition,newPosition, pivotX,pivotY);
        rotate.setDuration(2500);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mButton.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastPosition=newPosition;

        mImageView.startAnimation(rotate);


    }

}