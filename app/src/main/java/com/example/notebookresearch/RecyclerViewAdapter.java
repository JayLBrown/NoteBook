package com.example.notebookresearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<postHolder> {

    Context c;
    ArrayList<PostModel> models;

    public RecyclerViewAdapter(Context c, ArrayList<PostModel> models) {
        this.c = c;
        this.models = models; //creates list of arrays
    }

    @NonNull
    @Override
    public postHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null); //this line inflates/creates row

        return new postHolder(view); /// this will return view to holder classssss
    }

    @Override
    public void onBindViewHolder(@NonNull final postHolder postHolder, int position) {

        postHolder.mTitle.setText(models.get(position).getTitle());
        postHolder.mDescription.setText(models.get(position).getDecription());
        postHolder.mImageView.setImageResource(models.get(position).getImg());


        postHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gTitle = models.get(position).getTitle();
                String gDescription = models.get(position).getDecription(); //gets data from post
                BitmapDrawable bitmapDrawable = (BitmapDrawable)postHolder.mImageView.getDrawable(); //retrieves image from post

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream =  new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[] bytes = stream.toByteArray();

                //this intent populates the data
                Intent intent = new Intent(c, AnotherActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDescription", gDescription);
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}