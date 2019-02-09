package com.example.cnkua.rdihackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class UserDashboardActivity extends AppCompatActivity {
    Button signOutButton ;
    Button addRefugee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        signOutButton = (Button) findViewById(R.id.SignOut);
        addRefugee = (Button)findViewById(R.id.addRefugee);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this,MainActivity.class));
                FirebaseAuth.getInstance().signOut();
            }
        });

        addRefugee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashboardActivity.this,RefugeeRegistrationActivity.class));
            }
        });
    }
}
