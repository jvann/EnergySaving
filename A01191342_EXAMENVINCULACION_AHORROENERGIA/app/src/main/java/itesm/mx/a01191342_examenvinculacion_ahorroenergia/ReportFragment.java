package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment implements View.OnClickListener{

    private static final String DEBUG_TAG = "TAG_FRAG_REPORT";
    private View rootView;
    private DatePicker datePicker;
    private Button btnSearch;
    private TextView tvLicuadora;
    private TextView tvEstereo;
    private TextView tvCafetera;
    private TextView tvRadiograbadora;
    private TextView tvLavadora;
    private TextView tvHorno;
    private TextView tvPlancha;
    private TextView tvVentilador;
    private TextView tvTelevisor;
    private TextView tvRefrigerador;

    public ReportFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(DEBUG_TAG, "onCreate() has been called.");
    }

    public static ReportFragment newInstance() {

        return new ReportFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_report, container, false);
        datePicker = (DatePicker) rootView.findViewById(R.id.datePicker);
        btnSearch = (Button) rootView.findViewById(R.id.button_search);
        tvLicuadora = (TextView) rootView.findViewById(R.id.text_1);
        tvEstereo = (TextView) rootView.findViewById(R.id.text_3);
        tvCafetera = (TextView) rootView.findViewById(R.id.text_5);
        tvRadiograbadora = (TextView) rootView.findViewById(R.id.text_7);
        tvLavadora = (TextView) rootView.findViewById(R.id.text_9);
        tvHorno = (TextView) rootView.findViewById(R.id.text_11);
        tvPlancha = (TextView) rootView.findViewById(R.id.text_13);
        tvVentilador = (TextView) rootView.findViewById(R.id.text_15);
        tvTelevisor = (TextView) rootView.findViewById(R.id.text_17);
        tvRefrigerador = (TextView) rootView.findViewById(R.id.text_19);

        Log.d(DEBUG_TAG, "onCreateView() has been called.");

        btnSearch.setOnClickListener(this);

        return rootView;
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the lsit is selected(clicked).

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    @Override
    public void onClick(View view) {

        Log.d(DEBUG_TAG, "Report.onClick() has been called.");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(DEBUG_TAG, "onPause() has been called.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(DEBUG_TAG, "onStop() has been called.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(DEBUG_TAG, "onDestroyView() has been called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(DEBUG_TAG, "onDestroy() has been called.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(DEBUG_TAG, "onDetach() has been called.");
    }
}
