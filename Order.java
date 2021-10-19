package com.example.agrishop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class Order extends AppCompatActivity  {
    private ImageView pImageView;
    private EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9,ed10;
    private TextView ed11;
    Button b11,bt;
    int total=0,p,q;
    private String id, name, price, contact, description, quantity, phone, address;
    private boolean insert1 = false;
    private OrderDB dbHelper;

Uri uri;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ed9 = findViewById(R.id.ID);
        ed1 = findViewById(R.id.Name);
        ed2 = findViewById(R.id.Price);
        ed4 = findViewById(R.id.Contact);
        ed5 = findViewById(R.id.Desc);
        ed6 = findViewById(R.id.quantity);
        ed7 = findViewById(R.id.Phone);
        ed8 = findViewById(R.id.Address);
        ed10=findViewById(R.id.units);
        ed11=findViewById(R.id.total);
        b11 = findViewById(R.id.add);
        bt=findViewById(R.id.amount);
        dbHelper=new OrderDB(this);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              purchased();
            }
        });
        Intent in = getIntent();

        id = in.getStringExtra("ID");
        name=in.getStringExtra("NAME");
        price=in.getStringExtra("PRICE");
        contact=in.getStringExtra("CONTACT");
        quantity=in.getStringExtra("QUANTITY");
        description=in.getStringExtra("DESC");


            ed9.setText(id);
            ed1.setText(name);
            ed2.setText(price);
            ed4.setText(contact);
            ed5.setText(description);


        }
        private void purchased()
        {

            String s9=ed10.getText().toString().trim();
            if((s9.equals("gram")) || (s9.equals("grams")) )
            {
                String s3 = ed2.getText().toString().trim();
                String s4 =ed6.getText().toString().trim();

                double priceamount= Double.parseDouble(s3);
                double quant=Double.parseDouble(s4);
                double tot=(priceamount/1000)*quant;
                ed11.setText(""+tot);

            }
            else if((s9.equals("kilogram")) || (s9.equals("kilolitre")) || s9.equals("kilograms") || s9.equals("kilolitres"))
            {
                String s3 = ed2.getText().toString().trim();
                String s4 =ed6.getText().toString().trim();
                double priceamount= Double.parseDouble(s3);
                double quant=Double.parseDouble(s4);
                double tot=(priceamount)*(quant);
                ed11.setText(""+tot);
            }
            else if((s9.equals("millilitre")) || (s9.equals("millilitres")))
            {
                String s3 = ed2.getText().toString().trim();
                String s4 =ed6.getText().toString().trim();
                double priceamount= Double.parseDouble(s3);
                double quant=Double.parseDouble(s4);
                double tot=(priceamount/1000)*(quant);
                ed11.setText(""+tot);
            }
            else if( (s9.equals("litre")) || (s9.equals("litres")))
            {
                String s3 = ed2.getText().toString().trim();
                String s4 =ed6.getText().toString().trim();
                double priceamount= Double.parseDouble(s3);
                double quant=Double.parseDouble(s4);
                double tot=(priceamount)*(quant);
                ed11.setText(""+tot);
            }

        }






    private void getData() {

        String s1 = ed9.getText().toString().trim();
            String s2 =ed1.getText().toString().trim();
            String s3 = ed2.getText().toString().trim();
            String s4 =ed6.getText().toString().trim();
            String s5 = ed4.getText().toString().trim();
            String s6 =ed5.getText().toString().trim();
            String s7 = ed7.getText().toString().trim();
            String s8=ed8.getText().toString().trim();
            String s9=ed10.getText().toString().trim();
            String s10=ed11.getText().toString().trim();

        Boolean regDetails=dbHelper.insertOrder(""+s1,""+s2,""+s3,""+s4,""+s5,""+s6,""+s7,""+s8,""+s9,""+s10);
        if(regDetails == true)
        {
            Toast.makeText(this,"Ordered Succesfully!",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this,"Ordered Failed!",Toast.LENGTH_SHORT).show();
        }





        }
    }

