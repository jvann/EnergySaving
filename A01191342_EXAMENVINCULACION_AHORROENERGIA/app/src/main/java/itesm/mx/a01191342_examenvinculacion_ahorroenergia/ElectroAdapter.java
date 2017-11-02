package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/30/17.
 */

public class ElectroAdapter extends ArrayAdapter<Electro> {

    private Context context;

    public ElectroAdapter (Context context, ArrayList<Electro> electros) {
        super(context, 0, electros);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_electros, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_electro);
        TextView tvKwh = (TextView) convertView.findViewById(R.id.text_kwh);

        Electro electro = getItem(position);

        tvName.setText(electro.getNameE());
        tvKwh.setText(electro.getWatts() + " KWH");

        return convertView;
    }
}
