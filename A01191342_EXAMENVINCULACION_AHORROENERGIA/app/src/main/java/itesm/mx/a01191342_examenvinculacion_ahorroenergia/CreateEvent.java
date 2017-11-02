package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateEvent extends AppCompatActivity implements View.OnClickListener{

    private TextView date;
    private List<String> spinnerArray;
    private ArrayAdapter<String> adapter;
    private EventsOperations dao;
    private Button addButton;
    private Calendar calendar;
    private Spinner sItems;
    private EditText etUse;
    private String sDate;
    private String sHour;

    private String DEBUG_TAG = "CREATE_EVENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        dao = new EventsOperations(this);
        dao.open();

        date = (TextView) findViewById(R.id.text_dateCreation);
        addButton = (Button) findViewById(R.id.button_addEvent);
        sItems = (Spinner) findViewById(R.id.spinner);
        etUse = (EditText) findViewById(R.id.edit_horasUso);
        calendar = Calendar.getInstance();
        Log.d("DATE", "Current time => " + calendar.getTime());

        spinnerArray =  MasterData.getInstance().getAllElectroNames();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems.setAdapter(adapter);

        // Now we display formattedDate value in TextView. DateFormat dd/mm/yyyy hh:mm.
        sDate =
                calendar.get(Calendar.DAY_OF_MONTH) + "/" +
                calendar.get(Calendar.MONTH) + "/" +
                calendar.get(Calendar.YEAR);

        sHour = calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE);

        date.setText(sDate + " " + sHour);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

//        if (etUse.getText().equals("")) {
            String sInput = date.getText().toString() + " " +  sItems.getSelectedItem().toString() + " " +  R.drawable.meditation + " " + Integer.parseInt(etUse.getText().toString());
            Event event = new Event(sDate, sHour, sItems.getSelectedItem().toString(), R.drawable.meditation, Integer.parseInt(etUse.getText().toString()));
            Log.d(DEBUG_TAG, sInput);
            dao.addEvent(event);
            Toast.makeText(this, "Evento agregado exitosamente", Toast.LENGTH_SHORT).show();
            finish();
//        } else {
//            Toast.makeText(this, "Porfavor ingrese horas de uso.", Toast.LENGTH_SHORT).show();
//        }
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
}
