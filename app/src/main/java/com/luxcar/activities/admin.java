package com.luxcar.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.luxcar.R;

//import android.widget.Toolbar;

public class admin extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        createComponents();
        actionToolBar();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void actionToolBar() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout, toolbar,
                R.string.admin_menu_open,R.string.admin_menu_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void createComponents() {
        drawerLayout = findViewById(R.id.dlAdmin);
        toolbar= findViewById(R.id.tbAdmin);
        navigationView= findViewById(R.id.nvAdmin);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.admin_menu_user:
                Toast.makeText(this,"Trinh hâm", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_menu_brand:
                Toast.makeText(this,"Trinh đù", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_menu_car:
                Toast.makeText(this,"Trinh vvvv", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_menu_warehouse:
                Toast.makeText(this,"Trinh hjj", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_menu_changePass:
                Toast.makeText(this,"Trinh cccc", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_menu_logout:
                Toast.makeText(this,"Trinh cccx", Toast.LENGTH_SHORT).show();
                return true;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else onBackPressed();
    }
}
