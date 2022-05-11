package com.luxcar.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.luxcar.R;

import java.util.Objects;

public class admin extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        createComponents();
        actionToolBar();
    }

    private void actionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
        System.out.println("aaaaaa");
    }

    private void createComponents() {
        drawerLayout = findViewById(R.id.dlAdmin);
        toolbar= findViewById(R.id.tbAdmin);
        navigationView= findViewById(R.id.nvAdmin);
        listView= findViewById(R.id.lvAdmin);
    }
}
