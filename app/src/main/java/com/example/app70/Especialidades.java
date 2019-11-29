package com.example.app70;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Especialidades extends Fragment {
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
    private int opcion;
    private int back;


    //creado en el centro
    Conexion conecet;
    DatosEspecialidades especialidaes;
    ArrayList<DatosEspecialidades> especialidadesArrayList;
    ArrayAdapter<DatosEspecialidades> especialidadesArrayAdapter;
    MainActivity main;
    ArrayList<DatosEspecialidades>arreglo =new ArrayList<>(  );


    public Especialidades() {
     opcion=0;
     int back=0;
        conecet= new Conexion();
        main = new MainActivity();
    }

    //;p sobrecargo para los items de la barra de opciones
    public Especialidades(int num){
        conecet= new Conexion();
        opcion=num;
        main= new MainActivity();
    }

    public static Especialidades newInstance(String param1, String param2) {
        Especialidades fragment = new Especialidades();
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


    //aqui se realiza la interaccion
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        vista=inflater.inflate(R.layout.fragment_especialidades, container, false);
        lst=(ListView)vista.findViewById(R.id.lv_especialidades);
        //recuperamos los datos de la bd

        conecet.getInicializarFirebase();
        conecet.databaseReference.child( "Especialidades" ).addValueEventListener( new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                for(DataSnapshot recuperando2: dataSnapshot.getChildren()) {
                    especialidaes = recuperando2.getValue( DatosEspecialidades.class );
                    arreglo.add( especialidaes );


                }

                for(DatosEspecialidades e:arreglo){
                    System.out.println(e.getNombre()+"---");
                }
                //ArrayAdapter<DatosEspecialidades> especialidadesArrayAdapter = new ArrayAdapter<DatosEspecialidades>(this, android.R.layout.simple_list_item_1, arreglo);
                //lst.setAdapter( especialidadesArrayAdapter );

                //pasarDatos( especialidadesArrayList );
                //especialidadesArrayAdapter = new ArrayAdapter<DatosEspecialidades>( this, android.R.layout.simple_list_item_1, especialidadesArrayList );
                //lst.setAdapter( especialidadesArrayAdapter );
                System.out.println("********************"+arreglo.size()+"***********************");
                String contain [] = new String[arreglo.size()];/*{"Alergología",
                "Anestesiología",
                "Cardiología",
                "Gastroenterología",
               };*/
                int ni=0;
                for(DatosEspecialidades e:arreglo){
                    contain[ni]=e.getNombre();
                    ni+=1;
                }


                //lo mostramos en el listView
                ArrayAdapter<String> adap=new ArrayAdapter<String>(requireContext(),R.layout.modificaciones_sobre_listas,contain);
                lst.setAdapter(adap);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


        /*String contain [] = new String[]{"Alergología",
                "Anestesiología",
                "Cardiología",
                "Gastroenterología",
               };*/


        //llenarLista();
        //evento click

        //si presionaron una especialidad solicitando atencion usamos la sobreacrga del contrucctor por lo de la barra superior derecha
     if(opcion==0) {
         lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 FragmentTransaction transaction = getFragmentManager().beginTransaction();
                 transaction.replace(R.id.fr_Especialidades, new MiDisponibilidad());
                 transaction.commit();
             }
         });
     }
     else{
         lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 FragmentTransaction transaction = getFragmentManager().beginTransaction();
                 transaction.replace(R.id.fr_Especialidades, new Doctores());
                 transaction.commit();
             }
         });
     }
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void llenarLista(){


    }
    public void pasarDatos(ArrayList<DatosEspecialidades> contain){
        String [] pepa=new String[contain.size()];
        int i=0;
        for(DatosEspecialidades e:contain) {

            pepa[i]=e.getNombre();

            i+=1;
        }
        ArrayAdapter<String> adap = new ArrayAdapter<String>( requireContext(), R.layout.modificaciones_sobre_listas, pepa );
        lst.setAdapter( adap );
    }

}
