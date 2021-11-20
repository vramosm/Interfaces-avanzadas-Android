package com.example.ejercicio04;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;


public class MainFragment extends Fragment {

    ProgressBar progreso;
    ObjectAnimator progressAnimator;
    Button primerBoton;
    Button segundoBoton;
    EditText primeraUrl;
    WebView webView;
    EditText segundaUrl;

    //Una vez se inicie el programa aparece el snackbar
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mostrarsnackbar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View main = inflater.inflate(R.layout.main_fragment, container, false);

        //Se crea la funcion correspondiente a la primera url y el primer boton,

        primeraUrl = (EditText) main.findViewById(R.id.primeraUrl);
        primerBoton = (Button) main.findViewById(R.id.primerBoton);

        primerBoton.setEnabled(false);

        primeraUrl.addTextChangedListener(new TextWatcher() {

            //Se programa de tal forma que el boton de busqueda este inhabilitado hasta haber introducido algun texto
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!primeraUrl.getText().toString().trim().isEmpty()) {
                    primerBoton.setEnabled(true);
                } else {
                    primerBoton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//Se crea el onClick para introducir la url en el primer Webview
        primerBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                webView = getActivity().findViewById(R.id.primerWebview);
                webView.loadUrl(primeraUrl.getText().toString());

                progreso = (ProgressBar) getActivity().findViewById(R.id.barra);
                progreso.setRotation(0);
                progressAnimator = ObjectAnimator.ofInt(progreso, "progress", 0, 100);
                progressAnimator.setDuration(1000);
                progressAnimator.start();

            }
        });
//Se repite el proceso con el segundo boton y la segunda url
        segundaUrl = (EditText) main.findViewById(R.id.segundaUrl);
        segundoBoton = (Button) main.findViewById(R.id.segundoBoton);

        segundoBoton.setEnabled(false);

        segundaUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!segundaUrl.getText().toString().trim().isEmpty()) {
                    segundoBoton.setEnabled(true);
                } else {
                    segundoBoton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        segundoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progreso = (ProgressBar) getActivity().findViewById(R.id.barra);
                progreso.setRotation(0);
                progressAnimator = ObjectAnimator.ofInt(progreso, "progress", 0, 100);
                progressAnimator.setDuration(1000);
                progressAnimator.start();

            }
        });

        return main;
    }

    //Se define el mensaje del snackbar,su duracion y funcionamiento
    public void mostrarsnackbar() {

        Snackbar.make(getActivity().findViewById(android.R.id.content), R.string.Snack, Snackbar.LENGTH_SHORT)
                .setAction("X", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .show();
    }

}
