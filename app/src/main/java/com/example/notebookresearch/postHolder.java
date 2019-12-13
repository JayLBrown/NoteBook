package com.example.notebookresearch;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class postHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView mImageView;
    TextView mTitle, mDescription;
    ItemClickListener itemClickListener;

    postHolder(@NonNull View itemView) {
        super(itemView);     this.mImageView = itemView.findViewById(R.id.postImage);
        this.mTitle = itemView.findViewById(R.id.postTitle);
        this.mDescription = itemView.findViewById(R.id.postDescription);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClickListener(v, getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic) {

        this.itemClickListener = ic;
    }
}


