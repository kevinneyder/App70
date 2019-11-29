package com.example.app70;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conexion {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    MainActivity main;
    public Conexion(){
        main = new MainActivity();
    }
    public void getInicializarFirebase(){

        FirebaseApp.initializeApp(main );
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }

}
