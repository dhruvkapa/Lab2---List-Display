package com.example.listdisplay;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView detailTitle;
    private ImageView detailImage;
    private TextView detailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize views
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailDescription = findViewById(R.id.detailDescription);

        // Get data from Intent
        String title = getIntent().getStringExtra("title");
        int imageResId = getIntent().getIntExtra("imageResId", 0); // fallback = 0
        String description = getIntent().getStringExtra("description");

        // Set title with fallback
        if (title != null && !title.isEmpty()) {
            detailTitle.setText(title);
        } else {
            detailTitle.setText("No title provided");
        }

        // Set image with fallback
        if (imageResId != 0) {
            detailImage.setImageResource(imageResId);
        } else {
            detailImage.setImageResource(android.R.drawable.ic_menu_report_image);
        }

        // Set description with fallback
        if (description != null && !description.isEmpty()) {
            detailDescription.setText(description);
        } else {
            detailDescription.setText("No description available");
        }
    }
}
