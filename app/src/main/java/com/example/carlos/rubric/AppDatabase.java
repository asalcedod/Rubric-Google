package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by carlos on 14/04/17.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "CompanyDatabase";

    public static final int VERSION = 5;
}
