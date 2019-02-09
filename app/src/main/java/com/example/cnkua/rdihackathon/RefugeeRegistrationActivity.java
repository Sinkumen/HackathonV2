package com.example.cnkua.rdihackathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RefugeeRegistrationActivity extends AppCompatActivity {

    EditText firstNameField;
    EditText lastNameField;
    EditText emailField;
    EditText phoneNumberField;
    EditText ageField;
    EditText origineField;
    RadioGroup genderChoice;
    Button RegisterButton;
    FloatingActionButton CameraButton;
    Button BackButton;
    ImageView img;
    DatabaseReference reference;

    private Refugee refugee;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refugee_registration);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Refugee");
        firstNameField = (EditText)findViewById(R.id.RFirstNameField);
        lastNameField = (EditText)findViewById(R.id.RLastNameField);
        emailField = (EditText)findViewById(R.id.REmailField);
        phoneNumberField = (EditText)findViewById(R.id.RPhoneNumberField);
        ageField = (EditText)findViewById(R.id.RAgeField);
        origineField = (EditText)findViewById(R.id.ROriginField);
        genderChoice = (RadioGroup)findViewById(R.id.Gender);
        RegisterButton = (Button)findViewById(R.id.registerButton);
        CameraButton = (FloatingActionButton)findViewById(R.id.CameraButton);
        BackButton = (Button) findViewById(R.id.backButton);
        img =(ImageView) findViewById(R.id.ImagefromCamera);


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName= firstNameField.getText().toString();
                String LastName= lastNameField.getText().toString();
                String Email= emailField.getText().toString();
                int PhoneNumber= Integer.parseInt(phoneNumberField.getText().toString());
                int Age = Integer.parseInt(ageField.getText().toString());
                String Origin = origineField.getText().toString();
                RadioButton rb = (RadioButton)findViewById(genderChoice.getCheckedRadioButtonId());
                String Gender= rb.getText().toString();
                refugee = new Refugee(FirstName,LastName,Age,Gender,Email,PhoneNumber,Origin);
                reference.child(Integer.toString(refugee.getId())).setValue(refugee);
                Toast.makeText(RefugeeRegistrationActivity.this,"Refugee Registerd Successfully",Toast.LENGTH_LONG).show();
            }
        });

        CameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(bitmap);
    }
}
