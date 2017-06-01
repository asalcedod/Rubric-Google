package com.example.carlos.rubric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AddNotaActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);
        String title = getIntent().getStringExtra("Nombre").toUpperCase();
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }
}
