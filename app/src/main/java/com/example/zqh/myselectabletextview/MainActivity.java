package com.example.zqh.myselectabletextview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zqh.myselectabletextview.util.SelectableTextHelper;

/**
 * chabge by  17/12/07
 * @author zqh
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button btn;
    private SelectableTextHelper mSelectableTextHelper;
    private GestureDetector simpleOnGestureListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView= (TextView) findViewById(R.id.select_textview);
        btn= (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSelectCopy();
                mSelectableTextHelper.showAllSelect();
            }
        });

        //手势监听，点击非两个选择游标时，退出复制模式
        simpleOnGestureListener=new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                if(mSelectableTextHelper!=null&&!mSelectableTextHelper.isHide){
                    mSelectableTextHelper.destroy();
                }
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                if(mSelectableTextHelper!=null&&!mSelectableTextHelper.isHide){
                    mSelectableTextHelper.destroy();
                }
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
    }

    /**
     * 初始化自由复制类
     */
    private void initSelectCopy(){
        mSelectableTextHelper=new SelectableTextHelper.Builder(mTextView)
                .setSelectedColor(ContextCompat.getColor(this,R.color.colorPrimary))
                .setCursorHandleColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))
                .setEnbleLongClick(false)
                .build();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        simpleOnGestureListener.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
}

