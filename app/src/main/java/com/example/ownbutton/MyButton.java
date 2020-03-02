package com.example.ownbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
        init(context);//생성되자마자 함수호출
    }

    public MyButton(Context context, AttributeSet attrs) { //xml용 생성자
        super(context, attrs);
        init(context);//생성되자마자 함수호출
    }

    public void init(Context context){
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.WHITE);

        float textsize = getResources().getDimension(R.dimen.text_default);//sp사이즈 가져오기
        setTextSize(textsize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.BLACK);
                setTextSize(getResources().getDimension(R.dimen.text_big));
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.WHITE);
                setTextSize(getResources().getDimension(R.dimen.text_default));
                break;
        }

        invalidate();//onDraw 함수를 호출해서 onTouch 함수를 실행해주는 함수

        return true;
    }
}
