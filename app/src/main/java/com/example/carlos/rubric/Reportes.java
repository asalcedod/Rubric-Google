package com.example.carlos.rubric;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Reportes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Reportes extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RadioGroup radioGroup;
    private Spinner spinnerEst;

    public Reportes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reportes, container, false);
        final Spinner spinner = (Spinner) view.findViewById(R.id.freportes_spinner_asig);
        List<Asignatura> asignaturas = new Select().from(Asignatura.class).queryList();
        ArrayAdapter<Asignatura> adapter = new ArrayAdapter<Asignatura>(view.getContext(), R.layout.spinner_item, asignaturas);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        radioGroup = (RadioGroup) view.findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_eva:
                        final String asignatura = spinner.getSelectedItem().toString();
                        List<Evaluacion> asignaturas = new Select().from(Evaluacion.class).queryList();
                        ArrayAdapter<Evaluacion> adapterarray = new ArrayAdapter<Evaluacion>(getContext(), R.layout.spinner_item, asignaturas);
                        adapterarray.setDropDownViewResource(R.layout.spinner_item);
                        spinnerEst.setAdapter(adapterarray);
                        spinnerEst.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radio_est:
                        final String asignatura2 = spinner.getSelectedItem().toString();

                        List<Cursando> asignaturas2 = new Select().from(Cursando.class).where(Cursando_Table.Asignatura.is(asignatura2)).queryList();
                        ArrayAdapter<Cursando> adapterarray2 = new ArrayAdapter<Cursando>(getContext(), R.layout.spinner_item, asignaturas2);
                        adapterarray2.setDropDownViewResource(R.layout.spinner_item);
                        spinnerEst.setAdapter(adapterarray2);
                        spinnerEst.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        spinnerEst = (Spinner) view.findViewById(R.id.freportes_spinner_es);
        return view;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void comprobarModoPago(View view) {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radio_eva) {


        } else {
            if (radioGroup.getCheckedRadioButtonId() == R.id.radio_est) {


            }
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
