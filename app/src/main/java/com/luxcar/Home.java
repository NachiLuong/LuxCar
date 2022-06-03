package com.luxcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.luxcar.Adapter.AdapterBrand;
import com.luxcar.Adapter.AdapterCar;
import com.luxcar.models.entities.Brand;
import com.luxcar.models.entities.Car;


import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView.Adapter adapterBrand, adapterCar;
    private RecyclerView rvCategories, rvFood;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.colse);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        recyclerViewCategories();
        recyclerViewFood();
    }

    private void recyclerViewCategories() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(linearLayoutManager);

        ArrayList<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand("Honda 1","car_loading"));
        brandList.add(new Brand("Honda 1","car_loading"));


        adapterBrand = new AdapterBrand(adapterBrand);
        rvCategories.setAdapter(adapterBrand);

    }

    private void recyclerViewFood() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rvFood = findViewById(R.id.rvFood);
        rvFood.setLayoutManager(linearLayoutManager);



        ArrayList<Car> carlist = new ArrayList<>();
        carlist.add(new Car("car_loading", "car_loading", "", 10000));
        carlist.add(new Car("car_loading", "car_loading", "", 5000));

        adapterCar = new AdapterCar(carlist);
        rvFood.setAdapter(adapterCar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        drawerLayout.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.car:
                Toast.makeText(this,"Xe",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(this,"Liên hệ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this,"Đăng xuất",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}