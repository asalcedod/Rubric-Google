package com.example.carlos.rubric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class contenido extends AppCompatActivity {

    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    TextView tv;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String var="",num="",asig,cat,peso,elem,niv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_contenido);
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        num=getIntent().getStringExtra("elementos");
        var=getIntent().getStringExtra("niveles");
        elem=num;
        niv=var;
        cat=getIntent().getStringExtra("categoria");
        tv=(TextView) findViewById(R.id.textView2);
        tv.setText("Categoria: " + cat);
        peso=getIntent().getStringExtra("pesoc");
        asig=getIntent().getStringExtra("asignatura");
        tam=Integer.parseInt(num);
        for(int i=0;i<tam;i++) {
            addChild(ii);
            ii++;
        }
    }
    public void remove(){
        int i=0;
        while(i<relativeLayout.size()) {
            chek=(CheckBox) relativeLayout.get(i).findViewById(R.id.delet);
            if (chek.isChecked()) {
                layout.removeViewAt(i);
                relativeLayout.remove(i);
                i=0;
            }else{
                i++;
            }
        }
    }

    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        id = R.layout.elem;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Elemento "+(i));
        text2= (EditText) rl.findViewById(R.id.peso);
        text2.setHint("X%");
        relativeLayout.add(rl);
        layout.addView(rl);
    }

    public void delet(View view) {
        remove();
    }

    public void next(View view) {
        for (int i = 0; i < tam; i++){
            Intent in1 = new Intent(this, conenido2.class);
            text=(EditText) relativeLayout.get(i).findViewById(R.id.editText);
            text4=(EditText) relativeLayout.get(i).findViewById(R.id.peso);
            in1.putExtra("asignatura",asig);
            in1.putExtra("pesoc",peso);
            in1.putExtra("categoria",cat);
            in1.putExtra("elementos",elem);
            in1.putExtra("niveles", var);
            in1.putExtra("name", text.getText().toString());
            intents.add(in1);
            Elements elementos = new Elements();
            elementos.setElemento(text.getText().toString());
            elementos.setCategoria(cat);
            elementos.setnN(Integer.parseInt(elem));
            elementos.setPeso(Integer.parseInt(text4.getText().toString()));
            elementos.save();
            startActivityForResult(in1, i);
        }
        finish();
    }
}
