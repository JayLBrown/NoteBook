package com.example.notebookresearch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView  mTitleTv, mDescriptionTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        ActionBar actionBar = getSupportActionBar();

        mImageIv = findViewById(R.id.imageView);
        mTitleTv = findViewById(R.id.Title);
        mDescriptionTv = findViewById(R.id.Description);

        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDescription");

        byte[] myBytes = getIntent().getByteArrayExtra("iImage");
        //decode image so it populates after post is clicked on

        Bitmap bitmap = BitmapFactory.decodeByteArray(myBytes,0, myBytes.length);

        actionBar.setTitle(mTitle);


        mTitleTv.setText(mTitle);
        mDescriptionTv.setText(mDescription);
        mImageIv.setImageBitmap(bitmap);

    }
}
