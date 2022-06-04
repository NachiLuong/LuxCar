package com.luxcar.activities.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.luxcar.R;
import com.luxcar.activities.login.LoginActivity;
import com.luxcar.adapters.BrandAdapter;
import com.luxcar.adapters.CarAdapter;
import com.luxcar.models.entities.Brand;
import com.luxcar.models.entities.Car;
import com.luxcar.repositories.impls.BrandRepository;
import com.luxcar.repositories.impls.CarRepository;


import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView.Adapter adapterBrand, adapterCar;
    private RecyclerView rvBrand, rvCar;

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
        recyclerViewBrand();
        recyclerViewCar();
    }

    private void recyclerViewBrand() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvBrand = findViewById(R.id.rvCategories);
        rvBrand.setLayoutManager(linearLayoutManager);

        ArrayList<Brand> brandList = (ArrayList<Brand>) BrandRepository.instance().findAll();
        // find all


        adapterBrand = new BrandAdapter(brandList);
        rvBrand.setAdapter(adapterBrand);

    }

    private void recyclerViewCar() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rvCar = findViewById(R.id.rvCar);
        rvCar.setLayoutManager(linearLayoutManager);



        ArrayList<Car> carList = (ArrayList<Car>) CarRepository.instance().findAll();
        //findALl

        adapterCar = new CarAdapter(carList);
        rvCar.setAdapter(adapterCar);
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
                Intent intent= new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(this,"Log out Susses", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return false;
    }
}