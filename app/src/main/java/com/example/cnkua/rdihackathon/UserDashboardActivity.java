package com.example.cnkua.rdihackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class UserDashboardActivity extends AppCompatActivity {
    Button signOutButton ;
    CardView registerRefugee;
    CardView registerCitizens;
    CardView registerCompanies;
    CardView provideService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        signOutButton = (Button) findViewById(R.id.SignOut);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this,MainActivity.class));
                FirebaseAuth.getInstance().signOut();
            }
        });


        registerRefugee = (CardView)findViewById(R.id.registerRefugeeCard);
        registerCitizens = (CardView)findViewById(R.id.registerCitizensCard);
        registerCompanies = (CardView)findViewById(R.id.registerCompanyCard);
        provideService = (CardView)findViewById(R.id.provideServiceCard);

        registerRefugee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this,RefugeeRegistrationActivity.class));

            }
        });
        registerCitizens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this,RegisterCitizensActivity.class));

            }
        });
        registerCompanies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UserDashboardActivity.this,RegisterCompanyActivity.class));

            }
        });
        provideService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UserDashboardActivity.this,ProvideServiceActivity.class));

            }
        });
    }
}
