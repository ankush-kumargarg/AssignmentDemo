package com.demo.assignmentdemo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.demo.assignmentdemo.dto.Hit;

import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity {
    private ImageView iv_preview;
    private TextView tvName, tvLike, tvComment, tvView, tvDownload;
    private RelativeLayout rlContainer;

    private ArrayList<Hit> hitArrayList = new ArrayList<>();
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        iv_preview = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);
        tvLike = findViewById(R.id.tv_like);
        tvComment = findViewById(R.id.tv_comment);
        tvDownload = findViewById(R.id.tv_downlaod);
        tvView = findViewById(R.id.tv_views);
        rlContainer = findViewById(R.id.rl_container);

        if (getIntent() != null) {
            hitArrayList = (ArrayList<Hit>) getIntent().getSerializableExtra("imageList");
            position = getIntent().getIntExtra("position", 0);
        }

        Glide.with(ImageDetailActivity.this).load(hitArrayList.get(position).getPreviewURL()).into(iv_preview);
        tvName.setText(hitArrayList.get(position).getUser());
        tvLike.setText(hitArrayList.get(position).getLikes().toString());
        tvComment.setText(hitArrayList.get(position).getComments().toString());
        tvView.setText(hitArrayList.get(position).getViews().toString());
        tvDownload.setText(hitArrayList.get(position).getDownloads().toString());

    }
}