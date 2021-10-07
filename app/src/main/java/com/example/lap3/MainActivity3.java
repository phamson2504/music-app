package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.Image;
import android.os.Bundle;
import android.os.IBinder;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lap3.MyService.MyBinder;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {
    private MyService myService;
    private boolean isBound = false;
    private ServiceConnection connection;
    ImageButton btOn;
    String vd = "dung";
    private ImageView imageView;
    private TextView ten,caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btOn= findViewById(R.id.imageButton);
        imageView = findViewById(R.id.detalAnh);
        ten = findViewById(R.id.detailname);
        caption = findViewById(R.id.detailcamption);
        Intent intent1 = getIntent();
        Item item = (Item) intent1.getSerializableExtra("item");
        imageView.setImageResource(item.getHinhAnh());
        caption.setText(item.getCaption());
        ten.setText(item.getName());

        connection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {

                isBound = false;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyBinder binder = (MyBinder) service;
                myService = binder.getService();
                isBound = true;
            }
        };
        final Intent intent =
                new Intent(MainActivity3.this,
                        MyService.class);

        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vd=="dung"){
                    bindService(intent, connection, Context.BIND_AUTO_CREATE);
                    vd="sai";
                }else {
                    if(isBound){
                        unbindService(connection);
                        isBound = false;
                        vd="dung";
                    }

                }

            }
        });

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();

        //below methods are used for adding enter and exit transition.
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
        findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                overridePendingTransition(R.anim.enter1_x, R.anim.exit1_x);


            }
        });
    }
}