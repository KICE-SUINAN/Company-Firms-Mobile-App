package com.example.navsidebar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.account) {
                    Toast.makeText(MainActivity.this, "Account Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.help) {
                    Toast.makeText(MainActivity.this, "Help Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.about) {
                    Toast.makeText(MainActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.logout) {
                    Toast.makeText(MainActivity.this, "Log out Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.share) {
                    Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.rate) {
                    Toast.makeText(MainActivity.this, "Rate Us Selected", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}