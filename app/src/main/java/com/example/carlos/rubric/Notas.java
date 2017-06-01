package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;

/**
 * Created by carlos on 16/04/17.
 */
@Table(database = AppDatabase.class)

public class Notas {
    @PrimaryKey
    String Estudiante;
    @Column
    double nota;
    @Unique
    String Evaluacion;

}
