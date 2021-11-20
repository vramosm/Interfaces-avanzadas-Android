package com.example.ejercicio04;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SegundoFragment extends Fragment {

    EditText segundaUrl;

    //Se programa de tal forma que detecte la url introducida en el MainFragment y lo muestre en el Webview de este fragment
    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segundo_fragment, container, false);

        segundaUrl = (EditText) getActivity().findViewById(R.id.segundaUrl);

        WebView mywebview1 = view.findViewById(R.id.webview2);
        mywebview1.getSettings().setJavaScriptEnabled(true);
        mywebview1.getSettings().setBuiltInZoomControls(true);

        if (segundaUrl.getText().toString().trim().isEmpty()) {
            mywebview1.loadUrl("https://www.google.com");
        } else {
            mywebview1.loadUrl(segundaUrl.getText().toString().trim());
        }

        mywebview1.setWebViewClient(new WebViewClient());

        return view;
    }

}


