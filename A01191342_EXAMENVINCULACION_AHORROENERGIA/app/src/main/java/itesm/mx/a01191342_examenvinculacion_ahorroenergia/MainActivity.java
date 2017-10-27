package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnEventSelectedListener, OnElectroSelectedListener{

    public static String DEBUG_TAG = "TAG_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    @Override
    public void onEventSelected(int position) {
        switch (position) {
            case 0:
                Log.d(DEBUG_TAG, "Position Event: " + position);
                break;
            case 1:
                Log.d(DEBUG_TAG, "Position Event: " + position);
                break;
        }
    }


    @Override
    public void onElectroSelected(int position) {
        switch (position) {
            case 0:
                Log.d(DEBUG_TAG, "Position Electrodomestic: " + position);
                break;
            case 1:
                Log.d(DEBUG_TAG, "Position Electrodomestic: " + position);
                break;
        }
    }
}
