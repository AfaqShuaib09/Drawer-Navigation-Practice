package com.example.appdrawernav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navView;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.customToolBar);
        setSupportActionBar(toolbar);
        navView = (NavigationView) findViewById(R.id.nav_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.webActivity:
                        Toast.makeText(getApplicationContext(),"Opening Fb", Toast.LENGTH_LONG).show();
                        String url = "https://web.facebook.com/afaq.shoaib.9/";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.shareActivity:
                        Toast.makeText(getApplicationContext(),"Share", Toast.LENGTH_LONG).show();
                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "AppBar Practice");
                            String shareMessage= "\nLet me recommend you this application\n\n";
                            shareMessage = shareMessage + ": https://github.com/AfaqShuaib09/App-Bar-Practice";
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "choose one"));
                        } catch(Exception e) {
                            e.toString();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Activity2:
                        Toast.makeText(getApplicationContext(),"User Details:\n Name: Afaq\n" +
                                "Designation: Software Engineer", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
    }
}