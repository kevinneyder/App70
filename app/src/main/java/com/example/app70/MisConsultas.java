package com.example.app70;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MisConsultas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MisConsultas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MisConsultas extends Fragment {
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
    public MisConsultas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MisConsultas.
     */
    // TODO: Rename and change types and number of parameters
    public static MisConsultas newInstance(String param1, String param2) {
        MisConsultas fragment = new MisConsultas();
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


    //aqui se realiza la anteraccion
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista= inflater.inflate(R.layout.fragment_mis_consultas, container, false);
        lst=(ListView)vista.findViewById(R.id.lv_citas_proximas);
        String contain [] = new String[]{"19/12/19:   consulta oftanmologia",
                "19/6/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "11/4/18:   consulta medicina general","19/12/4:   consulta odontologia",
                "12/11/18:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "13/12/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
        };
        ArrayAdapter<String> adap=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain);
        lst.setAdapter(adap);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                eleccion();
            }
        });
        
        lst=(ListView)vista.findViewById(R.id.lv_citas_en_espera);
        String contain2 [] = new String[]{"19/12/19:   consulta oftanmologia",
                "19/6/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "11/4/18:   consulta medicina general","19/12/4:   consulta odontologia",
                "12/11/18:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "13/12/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
        };
        ArrayAdapter<String> adap2=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain2);
        lst.setAdapter(adap2);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                eleccion();
            }
        });



        ////
        lst=(ListView)vista.findViewById(R.id.lv_citas_perdidas);
        String contain3 [] = new String[]{"19/12/19:   consulta oftanmologia",
                "19/6/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "11/4/18:   consulta medicina general","19/12/4:   consulta odontologia",
                "12/11/18:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "13/12/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
        };
        ArrayAdapter<String> adap3=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain3);
        lst.setAdapter(adap3);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fr_mis_consultas, new Descripcion());
                transaction.commit();
            }
        });



        /////////////
        lst=(ListView)vista.findViewById(R.id.lv_citas_realizadas);
        String contain4 [] = new String[]{"19/12/19:   consulta oftanmologia",
                "19/6/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "11/4/18:   consulta medicina general","19/12/4:   consulta odontologia",
                "12/11/18:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
                "13/12/19:   consulta oftanmologia","19/12/4:   consulta oftanmologia",
        };
        ArrayAdapter<String> adap4=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain4);
        lst.setAdapter(adap4);

        //si hace click en la lista

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fr_mis_consultas, new Descripcion());
                transaction.commit();
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

        builer.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fr_mis_consultas, new Especialidades());
                transaction.commit();

            }
        });
        builer.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Se elimino su reserva con exito",Toast.LENGTH_LONG).show();
            }
        });
        builer.setNeutralButton("Ninguno", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialogo=builer.create();
        dialogo.setTitle("Elige una opcion");
        dialogo.setView(vistas);
        dialogo.show();
        //
    }
}
