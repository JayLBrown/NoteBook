package com.example.notebookresearch.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notebookresearch.R;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.researchBoard) {
            Intent loginIntent = new Intent(this, BoardActivity.class);
            startActivity(loginIntent);


        } else if (item.getItemId() == R.id.questionnaire) {
            Intent searchIntent = new Intent(this, QuestionnaireActivity.class);
            startActivity(searchIntent);
        } else if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
