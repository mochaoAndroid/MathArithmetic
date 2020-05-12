package com.demo.amt.demoapp;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button detail, toptic, gamepackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detail = (Button) findViewById(R.id.detail);
        toptic = (Button) findViewById(R.id.toptic);
        gamepackage = (Button) findViewById(R.id.gamepackage);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.amt.gamestore.plugin","com.amt.gamestore.InitActivity");
//                intent.setAction("com.android.smart.terminal.iptv");
                String url = "";
                switch (v.getId()) {
                    case R.id.detail:
//                        url = "http://221.228.33.240:10018/jumpPage/index.html?type=1&jumpId=1&contentCode=30000000369518979";
                        url = "{\"contentCode\":\"30000000268209240\",\"data\":\"\",\"isLauncherEntrance\":\"true\",\"jumpId\":1}";
                        break;
                    case R.id.gamepackage:
                        url = "http://221.228.33.240:10018/jumpPage/index.html?type=1&jumpId=2&contentCode=36000000265439186";
                        break;
                    case R.id.toptic:
                        url = "http://221.228.33.240:10018/jumpPage/index.html?type=1&jumpId=4&contentCode=211000000887225724&data=http%3a%2f%2f221.228.33.240%3a10018%2fHB-SC-topic%2ftopic.html%3fcodeId%3d211000000887225724";
                        break;
                    default:
                        break;
                }
                try {
                    intent.putExtra("intentMsg", url);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        detail.setOnClickListener(onClickListener);
        toptic.setOnClickListener(onClickListener);
        gamepackage.setOnClickListener(onClickListener);
    }
}