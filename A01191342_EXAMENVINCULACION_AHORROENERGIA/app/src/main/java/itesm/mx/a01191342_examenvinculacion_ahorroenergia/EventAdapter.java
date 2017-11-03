package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/30/17.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private Context context;

    public EventAdapter (Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_events, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_event);
        TextView tvDate = (TextView) convertView.findViewById(R.id.text_dateEvent);
        ImageView ivImageEvent = (ImageView) convertView.findViewById(R.id.image_event);

        Event event = getItem(position);
        tvName.setText(event.getType());
        tvDate.setText(event.getDate());
        ivImageEvent.setImageResource(MasterData.getInstance().getElectro(MasterData.getInstance().getElectro(event.getType())).getPicture());

        return convertView;
    }
}
