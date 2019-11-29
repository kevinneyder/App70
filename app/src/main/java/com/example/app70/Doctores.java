package com.example.app70;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Doctores.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Doctores#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Doctores extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
private View vista;
private ListView lst;

    public Doctores() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Doctores.
     */
    // TODO: Rename and change types and number of parameters
    public static Doctores newInstance(String param1, String param2) {
        Doctores fragment = new Doctores();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_doctores, container, false);
        lst = (ListView) vista.findViewById(R.id.lv_doctores);
        String contain[] = new String[]{"ACEVEDO JHONG, DANIEL",
                "AGURTO RONDOY, MIGUELVICENTE",
                "ALCALÁ NEGRÓN, CHRISTIAN NELSON",
                "ALMORA HERNANDEZ, RAUL EDUARDO",
                "ALOSILLA VELAZCO VERA, JORGE",
                "ALVA CAMPOS, VICTOR",
                "AREVALO LOPEZ, JAVIER",
                "ARIAS HERNANDEZ, ROSARIO",
                "ARROYO RAMÍREZ, EFRAÍN ",
                "ALOCEN BARRERA, MARCO TULIO",
                "BAIOCCHI URETA, CESAR",
                "BAYLÓN ROJAS, ISELA FLOR",
                "BEDOYA CASTILLO, LEONCIA",
                "BEDREGAL CANALES, LUZ MARINA",
                "BEJAR TORRES, RAMIRO ALBERTO",
                "BENAVIDES ESPEJO, JAVIER",
                "BOZA SOLIS, NELSON",
                "CALLE BETANCOURT, CIELITO MERCEDES",
                "CARAZA VILLEGAS, ISABEL FLORISA",
                "CARRERA ABANTO, GIZELLA",
                "CARRILLO SEGURA, ESTALINS",
                "CARRIÓN NEIRA, JORGE AUGUSTO",
                "CASAPIA VALDIVIA, GUILLERMO",
                "CHANCOS MENDOZA, ZARITA",
                "CHIRINOS LACOTERA, CARLOS",
                "CORES MORENO, DORIS",
                "CORTEZ LOZANO, MARIBEL CORINA",
                "CRISPIN QUISPE, ANGEL",
                "DE LOAYZA CONTERNO, ANTONIO"};

        ArrayAdapter<String> adap = new ArrayAdapter<String>(requireContext(), R.layout.modificaciones_sobre_listas, contain);
        lst.setAdapter(adap);
        return vista;
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
