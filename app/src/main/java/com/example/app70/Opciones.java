package com.example.app70;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;

public class Opciones extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Especialidades.OnFragmentInteractionListener,
        MiDisponibilidad.OnFragmentInteractionListener, EleccionHorario.OnFragmentInteractionListener,
        MisConsultas.OnFragmentInteractionListener, Descripcion.OnFragmentInteractionListener,
        MisExamenes.OnFragmentInteractionListener, MisMedicamentos.OnFragmentInteractionListener,
        InformacionMedicamento.OnFragmentInteractionListener, Doctores.OnFragmentInteractionListener, AcercaDe.OnFragmentInteractionListener,
        Avisos.OnFragmentInteractionListener {


    //atributo que cree para que me muestre Avisos al iniciar la app
    private static int mostrarAviso;

    public Opciones() {
        mostrarAviso = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        if (mostrarAviso == 1) {
            Fragment miFragment = new Avisos();
            getSupportFragmentManager().beginTransaction().replace(R.id.pantallaPrincipal, miFragment).commit();
            DrawerLayout auxiliar = findViewById(R.id.drawer_layout);
            auxiliar.closeDrawer(GravityCompat.START);
            mostrarAviso=2;
            //y...... funcionno xD
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }


    //cuando seleccione alguna de las opciones de la barra de opciones de 3 puntos
    //ids de res->menu->opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment miFragment = null;
        boolean seleccionado = false;

        if (id == R.id.item_list_especialidades) {
            seleccionado = true;
            miFragment = new Especialidades(1);
        } else {
            if (id == R.id.item_lst_medicos) {
                seleccionado = true;
                miFragment = new Doctores();
            } else {
                if (id == R.id.item_avisos) {
                    seleccionado = true;
                    miFragment = new Avisos();

                } else {
                    if (id == R.id.item_desarrolladores) {
                        seleccionado = true;
                        miFragment = new AcercaDe();
                    }
                }
            }
        }
        if (seleccionado) {
            getSupportFragmentManager().beginTransaction().replace(R.id.pantallaPrincipal, miFragment).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //cuando seleccione alguna de las opciones del menu desplegable
    //ids de res->menu->activity_opciones
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment miFragment = null;
        boolean seleccionado = false;

        if (id == R.id.solicitarConsulta) {
            seleccionado = true;
            miFragment = new Especialidades();
        } else {
            if (id == R.id.misConsultas) {
                seleccionado = true;
                miFragment = new MisConsultas();
            } else {
                if (id == R.id.misExamenes) {
                    seleccionado = true;
                    miFragment = new MisExamenes();
                } else {
                    if (id == R.id.misMedicamentos) {
                        seleccionado = true;
                        miFragment = new MisMedicamentos();
                    } else {
                        if (id == R.id.informacionDeMedicamentos) {
                            seleccionado = true;
                            miFragment = new InformacionMedicamento();
                        } else {
                            if (id == R.id.cerrarSesion) {
                                finish();


                            }
                        }
                    }
                }
            }
        }

        if (seleccionado) {
            getSupportFragmentManager().beginTransaction().replace(R.id.pantallaPrincipal, miFragment).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}
