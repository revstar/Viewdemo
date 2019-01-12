package com.revstar.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.TextView;
;import androidx.appcompat.widget.AppCompatTextView;

/**
 * Create on 2019/1/12 16:33
 * author revstar
 * Email 1967919189@qq.com
 */
public class CustomView extends AppCompatTextView {

    public static final String TAG="CustomView";

    private int mScaledTouchSlop;
    //上次滑动的坐标
    private int mLastX=0;
    private int mLastY=0;
    //屏幕最大宽度高度
    private int maxWidth=0;
    private int maxHeight=0;



    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, @androidx.annotation.Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public CustomView(Context context, @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    private void initData(Context context){

        mScaledTouchSlop=ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Log.d(TAG,"str"+mScaledTouchSlop);
        WindowManager wm= (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        maxWidth=wm.getDefaultDisplay().getWidth();
        maxHeight=wm.getDefaultDisplay().getHeight();

        Log.d(TAG,"maxWidth="+maxWidth);
        Log.d(TAG,"maxHeight"+maxHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        //边界判断
        x=x<0?0:x;
        y=y<0?0:y;
        x=x>maxWidth?maxWidth:x;
        y=y>maxHeight?maxHeight:y;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                int deltaX=x-mLastX;
                int deltaY=y-mLastY;
                Log.d(TAG,"move,deltaX："+deltaX+"deltaY:"+deltaY);
                int translationX= (int) (getTranslationX()+deltaX);
                int translationY= (int) (getTranslationY()+deltaY);
                setTranslationX(translationX);
                setTranslationY(translationY);
                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;


        }
        mLastX=x;
        mLastY=y;
        return true;
    }


}
