package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventDetail extends AppCompatActivity {

    private ArrayList<Electro> electrosList;
    private ArrayList<Event> eventList;

    private ImageView ivPicture;
    private TextView tvNameElectro;
    private TextView tvKwh;
    private TextView tvDate;
    private TextView tvTotal;
    private TextView tvUse;

    private EventsOperations dao;

    private static String DEBUG_TAG = "EVENT_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ivPicture = (ImageView) findViewById(R.id.image_event_detail);
        tvNameElectro = (TextView) findViewById(R.id.text_detail_event);
        tvKwh = (TextView) findViewById(R.id.text_event_kwh_detail);
        tvDate = (TextView) findViewById(R.id.text_event_date);
        tvTotal = (TextView) findViewById(R.id.text_total_event);
        tvUse = (TextView) findViewById(R.id.text_use_detail);

        dao = new EventsOperations(this.getApplicationContext());
        dao.open();

        eventList = dao.getAllEvents();
        electrosList = MasterData.getInstance().getAllElectros();

        Bundle data = getIntent().getExtras();
        if (data != null) {
            setViewDetail(data.getInt("position"));
        }

    }

    private void setViewDetail(int position) {
        ivPicture.setImageResource(electrosList.get(MasterData.getInstance().getElectro(eventList.get(position).getType())).getPicture());
        tvNameElectro.setText(eventList.get(position).getType());
        tvKwh.setText(electrosList.get(MasterData.getInstance().getElectro(eventList.get(position).getType())).getWatts() + " KWH");
        tvDate.setText(eventList.get(position).getDate() + " " + eventList.get(position).getHour());
        tvTotal.setText("Consumo: " + eventList.get(position).getUse()*electrosList.get(MasterData.getInstance().getElectro(eventList.get(position).getType())).getWatts() + " KWH");
        tvUse.setText("Uso: " + eventList.get(position).getUse() + " Hora(s)");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
        dao.open();
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
        dao.close();
        super.onPause();
        Log.d(DEBUG_TAG, "onPause() has been called.");
    }
}
