package com.lff.myhometown_a;

import android.app.Activity;
import com.example.caresyx.myhometown2.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

public class Piczjk extends Activity implements View.OnClickListener {

    private AdapterViewFlipper mFlipper = null;
    private Button mPrevBtn = null;
    private Button mAutoBtn = null;
    private Button mNextBtn = null;
    private int[] mImageIds = {
            R.drawable.zjk1,R.drawable.zjk2,R.drawable.zjk3,
            R.drawable.zjk4,R.drawable.zjk5, R.drawable.zjk6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piczjk);

        // 获取界面组件
        mFlipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        mPrevBtn = (Button) findViewById(R.id.prev_bn);
        mAutoBtn = (Button) findViewById(R.id.auto_bn);
        mNextBtn = (Button) findViewById(R.id.next_bn);

        // 为AdapterViewFlipper设置Adapter
        MyFilpperAdapter adapter = new MyFilpperAdapter(this, mImageIds);
        mFlipper.setAdapter(adapter);

        // 为三个按钮设置点击事件监听器
        mPrevBtn.setOnClickListener(this);
        mAutoBtn.setOnClickListener(this);
        mNextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.prev_bn:
                // 显示上一个组件
                mFlipper.showPrevious();
                // 停止自动播放
                mFlipper.stopFlipping();
                break;
            case R.id.auto_bn:
                // 开始自动播放
                mFlipper.startFlipping();
                break;
            case R.id.next_bn:
                // 显示下一个组件。
                mFlipper.showNext();
                // 停止自动播放
                mFlipper.stopFlipping();
                break;
            default:
                break;
        }

    }
}
