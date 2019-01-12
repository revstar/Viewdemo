package com.revstar.viewdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
//
//        tv.setLeft(3432);
//        tv.setTop(343535);
//        tv.setRight(34534);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"textview被点击",Toast.LENGTH_SHORT).show();
            }
        });

        getData();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tv.scrollTo(-20,0);
                ViewGroup.MarginLayoutParams params= (ViewGroup.MarginLayoutParams) tv.getLayoutParams();
                params.width+=100;
                params.leftMargin+=100;
                tv.requestLayout();
//                ObjectAnimator.ofFloat(tv,"translationX",0,100).
//                        setDuration(2000).start();
                getData();
            }
        });

    }

    private void getData() {

        int left=tv.getLeft();
        int right=tv.getRight();
        int top=tv.getTop();
        int bottom=tv.getBottom();

        float translationX= tv.getTranslationX();
        float translationY=  tv.getTranslationY();

        float x=tv.getX();
        float y=tv.getY();


        Log.d(TAG,"left="+left);
        Log.d(TAG,"right="+right);
        Log.d(TAG,"top="+top);
        Log.d(TAG,"bottom="+bottom);
        Log.d(TAG,"translationX="+translationX);
        Log.d(TAG,"translationY="+translationY);
        Log.d(TAG,"translationY="+translationY);
        Log.d(TAG,"x="+x);
        Log.d(TAG,"y=="+y);



    }
}
