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

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Profile extends AppCompatActivity implements OnClickListener {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ed1 =(EditText)findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.email);
        ed3 = (EditText)findViewById(R.id.Phone);
        ed4 = (EditText)findViewById(R.id.address);
        ed5 =(EditText) findViewById(R.id.birthdate);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b4=(Button)findViewById(R.id.bt4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        String name= ed1.getText().toString();
        String email= ed2.getText().toString();
        String Phone= ed3.getText().toString();
        String address= ed4.getText().toString();
        String dob= ed5.getText().toString();
        SQLiteDatabase db=openOrCreateDatabase("agrishop", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS profile(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,email VARCHAR,Phone NUMBER(10),address VARCHAR,dob Date)");

        if(v==b1)
        {
            try{
                String sql = "insert into profile(name,email,Phone,address,dob)values(?,?,?,?,?)";
                SQLiteStatement statement = db.compileStatement(sql);
                statement.bindString(1,name);
                statement.bindString(2,email);
                statement.bindString(3,Phone);
                statement.bindString(4,address);
                statement.bindString(5,dob);
                statement.execute();
                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_LONG).show();

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed1.requestFocus();

            }
            catch(Exception ex) {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show();
            }

        }
        if(v==b2)
        {
            if(ed2.getText().toString().trim().length()==0) {
                showMessage("Error", "Please enter Email Id ");
                return;

            }
            Cursor c=db.rawQuery("SELECT * FROM profile WHERE email='"+ed2.getText()+"'", null);
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Email id: "+c.getString(2)+"\n");
                buffer.append("Phone no: "+c.getString(3)+"\n\n");
                buffer.append("Address: "+c.getString(4)+"\n\n");
                buffer.append("Date Of Birth: "+c.getString(5)+"\n\n");
            }
            showMessage("Profile Details", buffer.toString());
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();

        }
        if(v==b3)
        {
            if(ed2.getText().toString().trim().length()==0) {
                showMessage("Error", "Please enter Email Id ");
                return;

            }
            Cursor c=db.rawQuery("SELECT * FROM profile WHERE email='"+ed2.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM profile WHERE email='"+ed2.getText()+"'");
                showMessage("Success", "Record Deleted");
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed1.requestFocus();
            }
            else
            {
                showMessage("Error", "Invalid ");
            }

        }
        if(v==b4)
        {
            // Checking for empty roll number
            if(ed2.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Email id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM profile WHERE email='"+ed2.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE profile SET name='" + ed1.getText() + "',Phone='" + ed3.getText() + "',address='" + ed4.getText() +"',dob='" + ed5.getText() +
                        "' WHERE email='"+ed2.getText()+"'");
                showMessage("Success", "Record Modified");

            }
            else {
                showMessage("Error", "Invalid Email");
            }
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();
        }
    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}








