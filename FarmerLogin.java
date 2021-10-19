package com.example.agrishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class FarmerLogin extends AppCompatActivity implements OnClickListener {
    Button b1,b2;
    private EditText ed1,ed2;
    DatabaseHelper2 dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);
        ed1=findViewById(R.id.editText1);
        ed2= findViewById(R.id.editText2);
        b2= findViewById(R.id.fsignup);
        b1 = findViewById(R.id.login);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        dbHelper =new DatabaseHelper2(this);
    }
    public void onClick(View v) {
        if(v==b1)
        {
            String s1 = ed1.getText().toString().trim();
            String s2 = ed2.getText().toString().trim();
            if(s1.equals("") || s2.equals(""))
            {
                Toast.makeText(this,"Don't make empty!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Boolean res= dbHelper.checkLogin(s1,s2);
                if(res == true)
                {
                    Intent intent = new Intent(this,NavFarm.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this,"Invalid ",Toast.LENGTH_SHORT).show();
                }
            }


        }
        if(v==b2)
        {
            Intent intent = new Intent(this, FarmerRegister.class);
            startActivity(intent);
        }
    }
}