package app.oswaldogh89.marvelhero.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.oswaldogh89.marvelhero.Entities.Item;
import app.oswaldogh89.marvelhero.R;


public class ComicsAdapter extends BaseAdapter {
    private final Activity actividad;
    private final List<Item> lista;

    public ComicsAdapter(Activity actividad, List<Item> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item_lv_comics, null, true);


        TextView textView = view.findViewById(R.id.txtName);
        textView.setText(lista.get(position).getName());


        return view;
    }

    public int getCount() {
        return lista.size();
    }

    public Object getItem(int position) {
        return lista.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
}