package com.example.app70;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EleccionHorario.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EleccionHorario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EleccionHorario extends Fragment {
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
    public EleccionHorario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EleccionHorario.
     */
    // TODO: Rename and change types and number of parameters
    public static EleccionHorario newInstance(String param1, String param2) {
        EleccionHorario fragment = new EleccionHorario();
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
        vista=inflater.inflate(R.layout.fragment_eleccion_horario, container, false);
        lst=(ListView)vista.findViewById(R.id.listaHorarios);
        String contain [] = new String[]{"14:15 - 15:15"  , "16:15 -17:15  " ,
                "16:15 -17:15","14:15 - 15:15"  , "16:15 -17:15  " ,"16:15 -17:15","16:15 -17:15","14:15 - 15:15"  , "16:15 -17:15  " ,"16:15 -17:15"
        };

        ArrayAdapter<String> adap=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain);
        lst.setAdapter(adap);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                eleccion();
            }
        });
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


    public void eleccion(){
        //mensaje emergente
        LayoutInflater imagenAlert=LayoutInflater.from(requireContext());
        final View vistas=imagenAlert.inflate(R.layout.imagen_mensaje,null);

        AlertDialog.Builder builer=new AlertDialog.Builder(requireContext());
        //builer.setMessage("lolas");

        builer.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"se registro su reserva exitosamente",Toast.LENGTH_LONG).show();
            }
        });
        builer.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Se elimino su reserva con exito",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog dialogo=builer.create();
        dialogo.setTitle("Confirmar Reserva!");
        dialogo.setView(vistas);
        dialogo.show();
        //
    }
}
