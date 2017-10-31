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
    private Calendar getDate;
    private Spinner sItems;
    private EditText etUse;

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
        getDate = Calendar.getInstance();
        Log.d("DATE", "Current time => " + getDate.getTime());

        spinnerArray =  MasterData.getInstance().getAllElectroNames();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems.setAdapter(adapter);

        // Now we display formattedDate value in TextView
        date.setText(String.valueOf(getDate.getTime()));
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String sInput = date.getText().toString() + " " +  sItems.getSelectedItem().toString() + " " +  R.drawable.meditation + " " + Integer.parseInt(etUse.getText().toString());
        Event event = new Event(date.getText().toString(), sItems.getSelectedItem().toString(), R.drawable.meditation, Integer.parseInt(etUse.getText().toString()));
        Log.d(DEBUG_TAG, sInput);
        dao.addEvent(event);
        Toast.makeText(this, "Evento agregado exitosamente", Toast.LENGTH_SHORT).show();
        finish();
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
