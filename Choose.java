package com.example.agrishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
public class Choose extends AppCompatActivity implements OnClickListener {
    private ImageView b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        b1 = findViewById(R.id.imageView3);
        b2 = findViewById(R.id.imageView4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            Intent intent = new Intent(this, FarmerLogin.class);
            startActivity(intent);
        }
        if(v==b2)
        {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }
}