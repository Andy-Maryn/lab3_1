package com.example.androidlab3_part1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_film);

        // find all items in the activity

        TextView title = findViewById(R.id.title2);
        TextView date = findViewById(R.id.date2);
        TextView origin = findViewById(R.id.origin);
        ImageView imageView = findViewById(R.id.imageViewTitle);
        TextView description = findViewById(R.id.description);

        // put data from previous activity
        Bundle bundle = getIntent().getExtras();
        title.setText(getIntent().getStringExtra("title"));
        date.setText(getIntent().getStringExtra("date"));
        origin.setText(getIntent().getStringExtra("origin"));
        description.setText(getIntent().getStringExtra("description"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));

        // button to get back to recycle wiev
        Button back = findViewById(R.id.back);
        // back button to list
        back.setOnClickListener(view -> {
            onBackPressed();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
