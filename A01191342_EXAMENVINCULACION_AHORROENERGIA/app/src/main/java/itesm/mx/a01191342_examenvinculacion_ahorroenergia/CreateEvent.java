package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateEvent extends AppCompatActivity {

    private TextView date;
    private List<String> spinnerArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        date = (TextView) findViewById(R.id.text_dateCreation);
        Calendar c = Calendar.getInstance();
        Log.d("DATE", "Current time => " + c.getTime());

        spinnerArray =  MasterData.getInstance().getAllElectroNames();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        // Now we display formattedDate value in TextView
        date.setText(String.valueOf(c.getTime()));
    }
}
