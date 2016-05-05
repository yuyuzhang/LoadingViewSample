package com.example.loadingview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

import java.util.zip.Inflater;

public class LoadingView extends FrameLayout {

    private CircleView mcircleview;

    public LoadingView(Context context) {
        this(context,null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view= LayoutInflater.from(getContext()).inflate(R.layout.activity_loading_view,null);
        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        mcircleview=(CircleView)view.findViewById(R.id.circleview);
        addView(view,layoutParams);
        startloading();
    }

    private void init(Context context, AttributeSet attrs){

    }

    public void startloading(){
        ObjectAnimator objectAnimator=new ObjectAnimator().ofFloat(mcircleview,"translationY",100).setDuration(2000);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.play(objectAnimator);

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                upthrow();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animatorSet.start();
    }


    public void upthrow(){
        ObjectAnimator objectAnimator =new ObjectAnimator().ofFloat(mcircleview,"translationY",-50).setDuration(100);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startloading();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
