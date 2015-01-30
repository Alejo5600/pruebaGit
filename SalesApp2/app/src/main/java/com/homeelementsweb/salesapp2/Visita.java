package com.homeelementsweb.salesapp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Visita extends Activity {
    private String itemSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        ListView lstOpciones = (ListView) findViewById(R.id.listView);
        //Se registra la lista para que pueda mostrar un menú contextual
        registerForContextMenu(lstOpciones);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_visita, menu);
        final String[] datos =
                new String[]{"Cliente 1","Cliente 2","Cliente 3","Cliente 4","Cliente 5","Cliente 6","Cliente 7","Cliente 8","Cliente 9","Cliente 10"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        ListView lstOpciones = (ListView) findViewById(R.id.listView);
        lstOpciones.setAdapter(adaptador);

        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        ListView lstLista = (ListView) findViewById(R.id.listView);
        //se verifica que el menu que se este pidiendo sea sobre la lista
        // y no sobre ningun otro elemento visual
        if(v.getId()==R.id.listView){
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo)menuInfo;
            //Se obtiene el la opcion seleccionada para mostrarla como titulo del menu
            itemSeleccionado = lstLista.getAdapter().getItem(info.position).toString();
            menu.setHeaderTitle(itemSeleccionado);
            //Se asocia el menu xml
            inflater.inflate(R.menu.menu_ctx_list, menu);
        }
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

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //Se verifica que opcion del menú contextual fue seleccionada
        switch (item.getItemId()) {
            case R.id.CtxPedido:
                Intent i = new Intent(Visita.this,Pedido.class);
                Bundle b = new Bundle();
                b.putString("Cliente",itemSeleccionado);
                i.putExtras(b);
                startActivity(i);
                return true;
            case R.id.CtxRecaudo:
                return true;
            /*case R.id.buscarCliente:
                AlertDialog alerta = new AlertDialog.Builder(this).create();
                alerta.setTitle("Error de autenticación");
                alerta.setMessage("El nombre de usuario o la contraseña son incorrectos");
                alerta.setButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alerta.show();
                return true;*/
            default:
                return false;
        }
    }

}
