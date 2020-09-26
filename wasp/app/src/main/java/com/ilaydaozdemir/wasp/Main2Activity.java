package com.ilaydaozdemir.wasp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter(this));
        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("İSTEKLER");
                        tab.setIcon(R.drawable.request);
                        break;
                    }
                    case 1: {
                        tab.setText("ARKADAŞLAR");
                        tab.setIcon(R.drawable.friends);
                        break;
                    }
                    case 2: {
                        tab.setText("SOHBET");
                        tab.setIcon(R.drawable.chat);
                        break;
                    }
                }

            }
        });
        tabLayoutMediator.attach();
    }

    @Override
    protected void onStart() {

        if (currentUser == null) {

            Intent mainIntent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
