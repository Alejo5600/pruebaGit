package com.homeelementsweb.salesapp2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class ListaDetalle extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_detalle);

        List detalles = new ArrayList<Detalle>();

        detalles.add(new Detalle(1010,"Esta es la primera descripción",
                12500000, 50, 20700, "Esta es la primera observación"));
        detalles.add(new Detalle(1020,"Esta es la Segunda descripción",
                7800000, 25, 15400, "Esta es la Segunda observación"));

        //Instancia del ListView
        ListView lista = (ListView)findViewById(R.id.lista);

        //Inicializar el adaptador con la fuente de datos
        ArrayAdapter adaptador = new AdapterDetalle(
                this,
                detalles);

        //Relacionando la lista con el adaptador
        lista.setAdapter(adaptador);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
