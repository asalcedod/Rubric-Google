package com.example.carlos.rubric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class nrubrica extends AppCompatActivity {

    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    CheckBox chek;
    Button add,del;
    int id,tam=0,n,ii=1,lvl=0;
    String asg="",num="",s="";
    private ViewGroup layout;
    private ScrollView scrollView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrubrica);
        myRef.setValue("Hola");
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        text2=(EditText)findViewById(R.id.name);
        text3=(EditText)findViewById(R.id.tam);
        text4=(EditText)findViewById(R.id.lvl);
        add=(Button)findViewById(R.id.add);
        del=(Button)findViewById(R.id.delet);
        s=getIntent().getStringExtra("nueva");
        if(s.equals("No")){
            text3.setEnabled(false);
            text4.setEnabled(false);
            add.setEnabled(false);
            del.setEnabled(false);
            asg=getIntent().getStringExtra("rubrica");
            List<Rubric> ru = new Select().from(Rubric.class).where(Rubric_Table.Rubric.is(asg)).queryList();
            for (Rubric rub : ru) {
                tam=rub.cat;
                text3.setText(""+tam);
                text4.setText(""+rub.lvl);
                //Toast.makeText(this, text4.getText().toString(), Toast.LENGTH_LONG).show();
                text2.setText(""+rub.Rubric);
                text2.setEnabled(false);
                crea(tam);
            }
            int ix=0;
            List<Category> c = new Select().from(Category.class).where(Category_Table.Rubrica.is(asg)).queryList();
            for (Category ca : c) {
                text=(EditText) relativeLayout.get(ix).findViewById(R.id.editText);
                text.setText(ca.Categoria);
                text4=(EditText) relativeLayout.get(ix).findViewById(R.id.nelem);
                text4.setText(""+ca.nE);
                ix++;
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("tamaño",tam);
    }

    @SuppressLint("InlinedApi")
    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        id = R.layout.cat;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Categoria "+(i));
        text3= (EditText) rl.findViewById(R.id.nelem);
        text3.setHint("Elem");
        relativeLayout.add(rl);
        layout.addView(rl);
    }
    public void remove(){
        int i=0;
        while(i<relativeLayout.size()) {
            chek=(CheckBox) relativeLayout.get(i).findViewById(R.id.delet);
            if (chek.isChecked()) {
                layout.removeViewAt(i);
                relativeLayout.remove(i);
                tam--;
                i=0;
            }else{
                i++;
            }
        }
        text3.setText(""+tam);
    }
    public void crea(int n){
        for(int i=0;i<n;i++) {
            addChild(ii);
            ii++;
        }
    }
    public void add(View view) {
        //Creamos el evento de agregar EditText segun la necesidad
        //Con el ciclo podemos crear n editText segun el usuario (con eso creamos los elementos
        //que pide el profesor Augusto
        tm= (EditText) findViewById(R.id.tam);
        num = tm.getText().toString();
        if(num.equals("")){
            n=0;
        }else{
            n=Integer.parseInt(num);
            tam=tam+n;
        }
        for(int i=0;i<n;i++) {
            addChild(ii);
            ii++;
        }
    }

    public void delet(View view) {
        remove();
    }

    private void writeNewRubri(String rubricname, int cat, int lvl) {
        FBRubric fbr=new FBRubric(rubricname,cat,lvl);

        myRef.child("rubrics").child(rubricname).setValue(fbr);
    }

    public void next(View view) {
        asg=text2.getText().toString();
        Rubric rubrica = new Rubric();
        rubrica.setRubric(asg);
        rubrica.setAsignatura(asg);
        rubrica.setCat(tam);
        rubrica.setLvl(Integer.parseInt(text4.getText().toString()));
        rubrica.save();
        writeNewRubri(asg,tam,Integer.parseInt(text4.getText().toString()));
        text4= (EditText) findViewById(R.id.lvl);
        for (int i = 0; i < tam; i++){
            Intent in = new Intent(this, contenido.class);
            text = (EditText) relativeLayout.get(i).findViewById(R.id.editText);
            text3 = (EditText) relativeLayout.get(i).findViewById(R.id.nelem);
            in.putExtra("elementos", text3.getText().toString());
            in.putExtra("categoria",text.getText().toString());
            in.putExtra("niveles",text4.getText().toString());
            in.putExtra("asignatura",asg);
            intents.add(in);
            Category categoria = new Category();
            categoria.setCategoria(text.getText().toString());
            categoria.setnE(Integer.parseInt(text3.getText().toString()));
            categoria.setRubrica(asg);
            categoria.save();
            startActivityForResult(in, i);
        }
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}
