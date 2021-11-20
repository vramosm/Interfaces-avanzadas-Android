package com.example.ejercicio04;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class PrimerFragment extends Fragment {

    EditText primeraUrl;

    //Se programa de tal forma que detecte la url introducida en el MainFragment y lo muestre en el Webview de este fragment
    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.primer_fragment, container, false);

        primeraUrl = (EditText) getActivity().findViewById(R.id.primeraUrl);

        WebView mywebview = view.findViewById(R.id.primerWebview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setBuiltInZoomControls(true);

        if (primeraUrl.getText().toString().trim().isEmpty()) {
            mywebview.loadUrl("https://www.google.com");
        } else {
            mywebview.loadUrl(primeraUrl.getText().toString().trim());
        }

        mywebview.setWebViewClient(new WebViewClient());
        return mywebview;
    }

}


