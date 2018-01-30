package com.example.didac.epigapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.example.didac.epigapp.Fragments.DashboardFragment;
import com.example.didac.epigapp.Fragments.HomeFragment;
import com.example.didac.epigapp.R;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import android.support.v4.app.Fragment;





/**
 * Created by Didac on 30/1/18.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SecondaryDrawerItem home = new SecondaryDrawerItem().withIdentifier(1).withName("Home").withIcon(GoogleMaterial.Icon.gmd_home);
        SecondaryDrawerItem dashboard = new SecondaryDrawerItem().withIdentifier(2).withName("Dashboard").withIcon(GoogleMaterial.Icon.gmd_dashboard);


        // Menu Header
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem().withName("Dídac Florensa").withEmail("dfc3@alumnes.udl.cat").withIcon(this.getResources().getDrawable(R.drawable.user))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        home,
                        dashboard
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    Fragment fragment;
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position - 1) {
                            case 0:
                                fragment = new HomeFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_layout, fragment)
                                        .commit();
                            case 1:
                                fragment = new DashboardFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_layout, fragment)
                                        .commit();

                        }

                        return true;
                    }
                })
                .build();

        //When the app starts, HomeFragment is showed.
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, fragment)
                .commit();


    }


}
