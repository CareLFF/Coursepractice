package com.lff.myhometown_a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caresyx.myhometown2.R;

public class Menua extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menua);
        TextView name= (TextView) findViewById(R.id.name);
        final Intent intent = getIntent();//它是Intent类本身的一个方法，可以直接返回Intent实例。
        Person p =(Person) intent.getSerializableExtra("person");
        name.setText(p.getName()+",欢迎来到张家口 ！  ");

        Button bn1=(Button)findViewById(R.id.txt);
        Button bn2=(Button)findViewById(R.id.pic);
        Button bn3=(Button)findViewById(R.id.mv);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menua.this,Txtzjk.class);
                startActivity(intent1);
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Menua.this,Piczjk.class);
                startActivity(intent2);
            }
        });

        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Menua.this,Mvzjk.class);
                startActivity(intent3);
            }
        });


    }


}

