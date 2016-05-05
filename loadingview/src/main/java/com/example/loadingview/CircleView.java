package com.example.loadingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yy on 2016/5/4.
 */
public class CircleView extends View {
    Paint mpaint;
    int mcolor;


    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mpaint=new Paint();
        mpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mpaint.setAntiAlias(true);
        mcolor=getResources().getColor(R.color.circle);
        mpaint.setColor(mcolor);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/4,mpaint);

    }
}
