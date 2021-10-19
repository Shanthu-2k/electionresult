package com.example.agrishop;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.database.Cursor;
public class Register extends AppCompatActivity implements OnClickListener {
    EditText ed1, ed2, ed3;
    Button b1,b2;
    DatabaseHelper1 dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1 = (EditText) findViewById(R.id.email);
        ed2 = (EditText) findViewById(R.id.pass);
        ed3 = (EditText) findViewById(R.id.cpass);
        dbHelper=new DatabaseHelper1(this);
        b1 = (Button) findViewById(R.id.ok);
        b2=findViewById(R.id.login);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    public void onClick(View v) {


        if (v == b1) {
            String s1 = ed1.getText().toString().trim();
            String s2 = ed2.getText().toString().trim();
            String s3 = ed3.getText().toString().trim();
            if(s1.equals("") || s2.equals("") || s3.equals(""))
            {
                Toast.makeText(this,"Don't make empty!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(s2.equals(s3))
                {
                 Boolean user=dbHelper.checkUser(s1);
                 if(user==false)
                 {
                   Boolean regDetails=dbHelper.insertRegister(s1,s2);
                   if(regDetails == true)
                   {
                       Toast.makeText(this,"Registered Succesfully!",Toast.LENGTH_SHORT).show();

                   }
                   else
                   {
                       Toast.makeText(this,"Registered Failed!",Toast.LENGTH_SHORT).show();
                   }
                 }
                 else
                 {
                     Toast.makeText(this,"User already exist!",Toast.LENGTH_SHORT).show();
                 }
                }
                else
                {
                    Toast.makeText(this,"Password do not match",Toast.LENGTH_SHORT).show();
                }
            }




        }
        if(v==b2)
        {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }

}

