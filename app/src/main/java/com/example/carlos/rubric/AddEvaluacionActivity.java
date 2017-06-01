package com.example.carlos.rubric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class AddEvaluacionActivity extends AppCompatActivity {

    private Toolbar actionBar;
    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evaluacion);
        actionBar = (Toolbar) findViewById(R.id.acitivity_add_evaluacion_toolbar);
        button = (Button) findViewById(R.id.acitivity_add_evaluacion_button);
        spinner = (Spinner) findViewById(R.id.activity_add_evalucion_spinner);
        Rubric rubric = new Rubric();
        /*
        rubric.setRubric("Carlos");
        rubric.setAsignatura("Español");
        */
        List<Rubric> rubrics = new Select().from(Rubric.class).queryList();
        if(!rubrics.isEmpty()) {
            ArrayAdapter<Rubric> adapter = new ArrayAdapter<Rubric>(getApplicationContext(), R.layout.spinner_item, rubrics);
            adapter.setDropDownViewResource(R.layout.spinner_item);
            spinner.setAdapter(adapter);
            actionBar.setTitle("Agregar Evaluación");
            setSupportActionBar(actionBar);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Aquí va la actividad del relleno de
                    //Intent intent = new Intent(this,)
                    //startActivityForResult();
                    String a = spinner.getSelectedItem().toString();
                    Evaluacion evaluacion = new Evaluacion();
                    evaluacion.setRubrica(a);
                    evaluacion.setAsignatura(getIntent().getStringExtra("Asignatura"));
                    evaluacion.save();
                    finish();
                }
            });
        }else{
            Toast.makeText(this, "No existen rubricas en el momento", Toast.LENGTH_LONG).show();
        }

    }
}
