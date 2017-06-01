package com.example.carlos.rubric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddAsignatura extends AppCompatActivity {

    private Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asignatura);
        mButton = (Button) findViewById(R.id.addAsignatura_button);
        mEditText = (EditText) findViewById(R.id.aadd_estudiante_edittext);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Asignatura asignatura = new Asignatura();
                asignatura.setNombre(mEditText.getText().toString());
                asignatura.save();
                finish();
            }
        });
    }


}
