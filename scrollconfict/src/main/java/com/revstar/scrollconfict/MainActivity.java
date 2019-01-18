package com.revstar.scrollconfict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG="MainActivity";
    private HorizontalScrollViewEx mListContainer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        initView();
    }

    private void initView() {
        LayoutInflater inflater=getLayoutInflater();
        mListContainer=findViewById(R.id.container);
        final  int screenWidth=getScreenMetrics(this).widthPixels;
        final  int screenHeight=getScreenMetrics(this).heightPixels;
        for (int i=0;i<3;i++){
            ViewGroup layout= (ViewGroup) inflater.inflate(R.layout.content_layout,mListContainer,false);
            layout.getLayoutParams().width=screenWidth;
            TextView textView=layout.findViewById(R.id.title);
            textView.setText("page"+(i+1));
            layout.setBackgroundColor(Color.rgb(255/(i+1),255/(i+1),0));
            createList(layout);
            mListContainer.addView(layout);
        }

    }

    private void createList(ViewGroup layout) {
        ListView listView=layout.findViewById(R.id.list);
        ArrayList<String>datas=new ArrayList<>();
        for (int i=0;i<50;i++){
            datas.add("name"+i);
        }
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.content_list_item,R.id.name,datas);
        listView.setAdapter(adapter);
    }

    public static DisplayMetrics getScreenMetrics(Context context){
        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return  dm;
    }
}
