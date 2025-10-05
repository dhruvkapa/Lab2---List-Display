package com.example.listdisplay;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// The screen that will display the RecyclerView list
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Get the RecyclerView from XML
        RecyclerView rv = findViewById(R.id.rvRecipes);

        // Read span from XML (1 in portrait, 2 in landscape)
        int span = getResources().getInteger(R.integer.recipe_span);
        rv.setLayoutManager(new GridLayoutManager(this, span));

        //Provide the data + the adapter that renders each row
        rv.setAdapter(new RecipeAdapter(Recipe.sample()));
    }
}