package com.example.carlos.rubric;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Asignaturas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Asignaturas extends Fragment implements Adapter.RecyclerClickListner {

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    protected ArrayList<Asignatura> mDataset = new ArrayList();
    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected Adapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected FloatingActionButton floatingActionButton;
    private OnFragmentInteractionListener mListener;
    private android.app.FragmentManager supportFragmentManager;

    //Buenas
    public Asignaturas() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asignaturas, container, false);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fasignatura_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddAsignatura.class);
                startActivityForResult(intent, 0);
            }
        });
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fasignaturas_recycler);
        mDataset = (ArrayList<Asignatura>) new Select().from(Asignatura.class).queryList();
        mAdapter = new Adapter(mDataset);
        mAdapter.setRecyclerClickListner(this);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public android.app.FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }

    //Click del item para que te lleve  a una nueva asignatura
    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(getContext(), AsignaturasActivity.class);
        TextView textView = (TextView) view.findViewById(R.id.row_textview);

        intent.putExtra("Nombre", textView.getText().toString());
        startActivityForResult(intent, 0);
    }

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
