package com.example.ejercicio04;


import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager paginas;
    Adaptador adaptador;

    //Introduzco el TabLayout, el Viewpager y el Adaptador
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);
        paginas = findViewById(R.id.paginas);
        adaptador = new Adaptador(getSupportFragmentManager());
        paginas.setAdapter(adaptador);
        tabs.setupWithViewPager(paginas);

    }

    //Habilito las opciones del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Introduzco el item en el menu y lo relaciono con el Dialog
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DialogMenu dialogmenu = DialogMenu.newInstance();
        dialogmenu.show(getSupportFragmentManager(), "Dialogo");
        return super.onOptionsItemSelected(item);
    }


}
