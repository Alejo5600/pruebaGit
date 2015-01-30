package com.homeelementsweb.salesapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ingenierodesarrollo1 on 26/01/2015.
 */
public class Tab1 extends Fragment {

   private String nomCliente;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       //TextView customer = (TextView) getView().findViewById(R.id.nCliente);
        View vista =inflater.inflate(R.layout.tab1, container, false);

        String nombre = getArguments().getString("NombreCliente");
        TextView n = (TextView) vista.getRootView().findViewById(R.id.txtNCliente);
        n.setText(nombre);
       return vista;




    }

    public void setNomCliente(String nombre){
        this.nomCliente = nombre;
    }

}