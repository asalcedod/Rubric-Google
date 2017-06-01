package com.example.carlos.rubric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class EvaluacionActivity extends AppCompatActivity implements AdapterEstudiante.RecyclerClickListner {
    private RecyclerView recyclerView;
    private AdapterEstudiante adapterEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);

        recyclerView = (RecyclerView) findViewById(R.id.activity_evaluacion_recycler);
        String asignatura = getIntent().getStringExtra("Nombre").toString();
        List<Cursando> list = new Select().from(Cursando.class).where(Cursando_Table.Asignatura.is(asignatura)).queryList();
        List<Estudiante> est = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            est.add(new Estudiante(list.get(i).getEstudiante()));
        }
        adapterEstudiante = new AdapterEstudiante(est);
        recyclerView.setAdapter(adapterEstudiante);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(view.getContext(), AddNotaActivity.class);
        TextView textView = (TextView) view.findViewById(R.id.row_textview);
        intent.putExtra("Nombre", textView.getText().toString());
        startActivityForResult(intent, 0);
    }
}
