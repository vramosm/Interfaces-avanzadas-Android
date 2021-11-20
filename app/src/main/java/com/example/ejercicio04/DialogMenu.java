package com.example.ejercicio04;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogMenu extends DialogFragment {

    public static DialogMenu newInstance() {

        return new DialogMenu();
    }

    //Creo que Dialog que aparece al pulsar en el icono
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.Dialogo));
        builder.setPositiveButton(R.string.Aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogMenu, int which) {

            }
        });

        return builder.create();
    }
}

