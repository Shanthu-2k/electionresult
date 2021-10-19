package com.example.agrishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class Nav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    OrderDB orderDB;

    NavigationView navigationView;
    Toolbar toolbar;
    private ImageView i1, i2, i3, i4, i5, i6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        i1 = findViewById(R.id.imageView3);
        i2 = findViewById(R.id.imageView4);
        i3 = findViewById(R.id.imageView5);
        i4 = findViewById(R.id.imageView6);
        i5 = findViewById(R.id.imageView7);
        i6 = findViewById(R.id.imageView8);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        drawerLayout = findViewById(R.id.drawyer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(Nav.this, Login.class);
                startActivity(intent);
                break;
            case R.id.nav_order:
                setContentView(R.layout.sample1);
                recyclerView = findViewById(R.id.recycle1);
                orderDB = new OrderDB(this);
                OrderAdapter adapter1 = new OrderAdapter(this, orderDB.getOrder(null));
                recyclerView.setAdapter(adapter1);
                break;
            case R.id.nav_about:
                intent = new Intent(Nav.this, About.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClick(View v) {
        if(v==i1)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getAllData(null));
            recyclerView.setAdapter(adapter);
        }
        if(v==i2)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getVeg(null));
            recyclerView.setAdapter(adapter);

        }
        if(v==i3)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getOils(null));
            recyclerView.setAdapter(adapter);

        }
        if(v==i4)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getFlowers(null));
            recyclerView.setAdapter(adapter);

        }
        if(v==i5)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getCP(null));
            recyclerView.setAdapter(adapter);

        }
        if(v==i6)
        {
            setContentView(R.layout.sample);
            recyclerView=findViewById(R.id.recycle);
            databaseHelper =new DatabaseHelper(this);
            Adapter adapter=new Adapter(this,databaseHelper.getMilk(null));
            recyclerView.setAdapter(adapter);

        }
    }


}
