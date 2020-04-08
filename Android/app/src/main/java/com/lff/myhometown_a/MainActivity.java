package com.lff.myhometown_a;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.caresyx.myhometown2.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        Button bn=(Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText name = (EditText) findViewById(R.id.name);
                Person p = new Person(name.getText().toString());
                //把p打包发送
                Bundle data= new Bundle();
                data.putSerializable("person", p);
                Intent intent = new Intent(MainActivity.this, Menua.class);
                intent.putExtras(data);//数据传递
                startActivity(intent);
                finish();
            }
        });
    }
}

