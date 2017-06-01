package com.example.carlos.rubric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import static com.raizlabs.android.dbflow.config.FlowManager.getContext;

public class AsignaturasActivity extends AppCompatActivity implements AdapterEvaluacion.RecyclerClickListner {
    protected List<Evaluacion> mDataset = new ArrayList();
    protected RecyclerView mRecyclerView;
    protected AdapterEvaluacion mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        toolbar = (Toolbar) findViewById(R.id.activity_asignaturas_toolbar);
        String title = getIntent().getStringExtra("Nombre");
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_asignaturas_recycler);
        mDataset = new Select().from(Evaluacion.class).where(Evaluacion_Table.Asignatura.is(title)).queryList();
        mAdapter = new AdapterEvaluacion(mDataset);
        mAdapter.setRecyclerClickListner(this);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    public void Click(View view) {
        switch (view.getId()) {
            case R.id.activity_asignaturas_button_addEstudiante:
                Intent intent = new Intent(this, AddEstudiante.class);
                intent.putExtra("Asignatura", toolbar.getTitle().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.activity_asignaturas_button_addExamen:
                Intent intent2 = new Intent(this, AddEvaluacionActivity.class);
                intent2.putExtra("Asignatura", toolbar.getTitle().toString());
                startActivityForResult(intent2, 0);
                break;
            default:

                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(this, EvaluacionActivity.class);
        TextView textView = (TextView) view.findViewById(R.id.row_textview);
        intent.putExtra("Nombre", toolbar.getTitle().toString());
        startActivityForResult(intent, 0);
    }
}
