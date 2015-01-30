package com.homeelementsweb.salesapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ingenierodesarrollo1 on 30/01/2015.
 */
public class AdapterDetalle extends ArrayAdapter<Detalle> {

    public AdapterDetalle(Context context, List<Detalle> objects)
    {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo con image_list_view.xml
            listItemView = inflater.inflate(
                    R.layout.detalle_pedido_listview,
                    parent,
                    false);
        }
        //Obteniendo instancias de los elementos
        TextView codigo = (TextView)listItemView.findViewById(R.id.listCodigo);
        TextView descripcion = (TextView)listItemView.findViewById(R.id.listDescripcion);
        TextView saldo = (TextView)listItemView.findViewById(R.id.listSaldo);
        TextView cantidad = (TextView)listItemView.findViewById(R.id.listCantidad);
        TextView valor = (TextView)listItemView.findViewById(R.id.listValor);
        TextView observaciones = (TextView)listItemView.findViewById(R.id.listObservaciones);

        Detalle item = getItem(position);

        codigo.setText(String.valueOf(item.getCodigo()));
        descripcion.setText(item.getDescripcion());
        saldo.setText("Saldo: "+String.valueOf(item.getSaldo()));
        cantidad.setText("Cantidad: "+String.valueOf(item.getCantidad()));
        valor.setText("Valor: "+String.valueOf(item.getValor()));
        observaciones.setText(item.getObservaciones());

        return listItemView;
    }


}
