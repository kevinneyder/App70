package com.example.app70;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre,contrasena;
    Conexion conecet;
    Usuario user;
    DatosEspecialidades especialidadesDetalles;
    private static int n=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conecet= new Conexion();
        conecet.getInicializarFirebase();
        user= new Usuario();
        nombre=(EditText)findViewById( R.id.txt_correo );
        contrasena=(EditText)findViewById( R.id.txt_password );

    }

    public void irAmenu(View view) {
        user.setNombre( nombre.getText().toString() );
        user.setContrasena( contrasena.getText().toString() );
        conecet.databaseReference.child( "Usuario" ).child(user.getNombre()).setValue( user );
                Toast.makeText(this,"agregado",Toast.LENGTH_LONG).show();

        //para la variable statica
        n+=1;
        //
        getEspecialidadesArrayList();
        verLLenado();
        Intent siguiente = new Intent(this, Opciones.class);
        startActivity(siguiente);
        finish();
    }
    private void verLLenado(){
        if(n<=1){

        }
    }

    public void getEspecialidadesArrayList() {

        String contain[] = new String[]{"Alergología",
                "Anestesiología",
                "Cardiología",
                "Gastroenterología",
                "Endocrinología",
                "Geriatría",
                "Hematología",
                "Infectología",
                "Medicina aeroespacial",
                "Medicina del deporte",
                "Medicina del trabajo",
                "Medicina de urgencias",
                "Medicina familiar y comunitaria",
                "Medicina física y rehabilitación",
                "Medicina intensiva",
                "Medicina interna",
                "Medicina forense",
                "Medicina preventiva y salud pública",
                "Nefrología",
                "Neumología",
                "Neurología",
                "Nutriología",
                "Oncología médica",
                "Oncología radioterápica",
                "Pediatría",
                "Psiquiatría",
                "Reumatología",
                "Toxicología"};
        for (String e : contain) {
            //ArrayList<String> aux = new ArrayList<String>(  );
            especialidadesDetalles= new DatosEspecialidades();
            especialidadesDetalles.setNombre( e );
            //especialidaes = new DatosEspecialidades();
            //especialidaes.setNombre( e );
            //aux.add( e );
            conecet.databaseReference.child( "Especialidades" ).child(especialidadesDetalles.getNombre()).setValue( especialidadesDetalles );




        }
    }

}
