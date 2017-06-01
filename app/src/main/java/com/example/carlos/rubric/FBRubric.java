package com.example.carlos.rubric;

/**
 * Created by asalcedod on 31/05/17.
 */

public class FBRubric {
    public String rubricname;
    public int cat;
    public int lvl;


    public FBRubric() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public FBRubric(String rubricname, int cat, int lvl) {
        this.rubricname = rubricname;
        this.cat = cat;
        this.lvl = lvl;
    }

}
