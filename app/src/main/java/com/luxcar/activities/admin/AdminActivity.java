package com.luxcar.activities.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.luxcar.R;
import com.luxcar.activities.admin.fragment.BrandActivity;
import com.luxcar.activities.admin.fragment.CarActivity;
import com.luxcar.activities.admin.fragment.ChangePassActivity;
import com.luxcar.activities.admin.fragment.UserActivity;
import com.luxcar.activities.admin.fragment.WarehouseActivity;
import com.luxcar.activities.login.LoginActivity;
import com.luxcar.configurations.ApplicationProperties;

//import android.widget.Toolbar;

public class AdminActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    int curFragment = ApplicationProperties.ADMIN_FRAGMENT_USER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        createComponents();
        actionToolBar();

        navigationView.setNavigationItemSelectedListener(this);
        replayFragment(new UserActivity());
        navigationView.getMenu().findItem(R.id.admin_menu_user).setChecked(true);
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.admin_menu_user:
                if (curFragment != ApplicationProperties.ADMIN_FRAGMENT_USER){
                    replayFragment(new UserActivity());
                    curFragment = ApplicationProperties.ADMIN_FRAGMENT_USER;
                    break;
                }
            case R.id.admin_menu_brand:
                if (curFragment != ApplicationProperties.ADMIN_FRAGMENT_BRAND){
                    replayFragment(new BrandActivity());
                    curFragment = ApplicationProperties.ADMIN_FRAGMENT_BRAND;
                    break;
                }
            case R.id.admin_menu_car:
                if (curFragment != ApplicationProperties.ADMIN_FRAGMENT_CAR){
                    replayFragment(new CarActivity());
                    curFragment = ApplicationProperties.ADMIN_FRAGMENT_CAR;
                    break;
                }
            case R.id.admin_menu_warehouse:
                if (curFragment != ApplicationProperties.ADMIN_FRAGMENT_WAREHOUSE){
                    replayFragment(new WarehouseActivity());
                    curFragment = ApplicationProperties.ADMIN_FRAGMENT_WAREHOUSE;
                    break;
                }
            case R.id.admin_menu_changePass:
                if (curFragment != ApplicationProperties.ADMIN_FRAGMENT_CHANGEPASS){
                    replayFragment(new ChangePassActivity());
                    curFragment = ApplicationProperties.ADMIN_FRAGMENT_CHANGEPASS;
                    break;
                }

            case R.id.admin_menu_logout:
                Intent intent= new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(this,"Log out Susses", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else onBackPressed();
    }
    private void replayFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flAdmin, fragment);
        fragmentTransaction.commit();
    }
}
