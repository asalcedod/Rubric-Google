package com.example.carlos.rubric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class AddEstudiante extends AppCompatActivity {
    private Toolbar toolbar;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_estudiante);
        button = (Button) findViewById(R.id.add_estudiante_button);
        toolbar = (Toolbar) findViewById(R.id.activity_add_estudiante_toolbar);
        editText = (EditText) findViewById(R.id.aadd_estudiante_edittext);
        toolbar.setTitle("Agregar Estudiante");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Agregar estudiante
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(editText.getText().toString());
                estudiante.save();
                Cursando cursando = new Cursando();
                cursando.setAsignatura(getIntent().getStringExtra("Asignatura"));
                cursando.setEstudiante(editText.getText().toString());
                cursando.save();
                finish();
            }
        });
    }
}
