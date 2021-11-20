package com.example.ejercicio04;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class Adaptador extends FragmentPagerAdapter {

    MainFragment mainFragment;
    PrimerFragment primerFragment;
    SegundoFragment segundoFragment;

    public Adaptador(FragmentManager fm) {
        super(fm);
    }

    //Creo los distintos Fragment
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                mainFragment = new MainFragment();
                fragment = mainFragment;
                break;
            case 1:
                primerFragment = new PrimerFragment();
                fragment = primerFragment;
                break;
            case 2:
                segundoFragment = new SegundoFragment();
                fragment = segundoFragment;
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    //Se define el orden de las paginas
    @Override
    public CharSequence getPageTitle(int position) {
        String titulo;
        switch (position) {
            case 0:
                titulo = "Principal";
                break;
            case 1:
                titulo = "1º Web";
                break;
            case 2:
                titulo = "2º Web";
                break;
            default:
                titulo = "";
        }
        return titulo;
    }

}
