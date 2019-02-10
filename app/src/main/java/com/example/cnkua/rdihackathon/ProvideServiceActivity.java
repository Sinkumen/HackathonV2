package com.example.cnkua.rdihackathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProvideServiceActivity extends AppCompatActivity {

    private FloatingActionButton CameraButton;
    private CircleImageView img;
    private LinearLayout myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_service);

        CameraButton = (FloatingActionButton)findViewById(R.id.CameraButton);
        img =(CircleImageView)findViewById(R.id.ImagefromCamera);
        myInfo = (LinearLayout)findViewById(R.id.individualInfo);




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
        img.setBackgroundResource(R.color.transparent);
        img.setImageBitmap(bitmap);
        myInfo.setVisibility(View.VISIBLE);

    }
}
