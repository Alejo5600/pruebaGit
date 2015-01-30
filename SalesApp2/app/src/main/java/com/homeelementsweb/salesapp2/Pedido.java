package com.homeelementsweb.salesapp2;

import android.app.ActionBar;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Pedido extends FragmentActivity {
    private TextView nombreCliente;
    private FragmentTabHost tabHost;
    private String nomC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        //Tab1 tab1 = Tab1.newInstance(getIntent().getExtras());
        Bundle datosCabecera = new Bundle();
        datosCabecera.putString("NombreCliente",getIntent().getExtras().getString("Cliente"));
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Encabezado"),Tab1.class, datosCabecera);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Detalle"),Tab2.class, null);
        tabHost.setCurrentTab(0);







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pedido, menu);
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

    public String getNombreCliente(){
        return this.nomC;
    }
}
