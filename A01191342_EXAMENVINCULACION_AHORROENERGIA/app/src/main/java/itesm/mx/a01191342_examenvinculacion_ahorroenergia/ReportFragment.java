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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment implements View.OnClickListener{

    private static final String DEBUG_TAG = "TAG_FRAG_REPORT";
    private String getDatePicker;
    private ArrayList<Event> eventList;
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

    private EventsOperations dao;

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

        dao = new EventsOperations(this.getContext());//HERE POSSIBLE PROBLEM.
        dao.open();

        Log.d(DEBUG_TAG, "onCreateView() has been called.");

        btnSearch.setOnClickListener(this);

        return rootView;
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the list is selected(clicked).

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    @Override
    public void onClick(View view) {

        cleanTextViews();
        getEventsReport();
        Log.d(DEBUG_TAG, "Report.onClick() has been called.");
    }

    public void cleanTextViews() {
        tvLicuadora.setText("0");
        tvEstereo.setText("0");
        tvCafetera.setText("0");
        tvRadiograbadora.setText("0");
        tvLavadora.setText("0");
        tvHorno.setText("0");
        tvPlancha.setText("0");
        tvVentilador.setText("0");
        tvTelevisor.setText("0");
        tvRefrigerador.setText("0");
    }
    public void getEventsReport() {

        ArrayList<Event> eventList = dao.getAllEvents();
        getDatePicker = String.valueOf(datePicker.getDayOfMonth()) + "/" + String.valueOf(datePicker.getMonth()) + "/" + String.valueOf(datePicker.getYear());

        Log.d(DEBUG_TAG, getDatePicker);

        for (int i = 0; i < eventList.size(); i++) {

            if (eventList.get(i).getDate().equals(getDatePicker)) {
                Log.d(DEBUG_TAG, eventList.get(i).getType());

                switch (eventList.get(i).getType())
                {
                    case "Licuadora":
                        tvLicuadora.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvLicuadora.getText().toString()) + eventList.get(i).getUse()*125));
                        break;
                    case "Estereo musical":
                        tvEstereo.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvEstereo.getText().toString()) + eventList.get(i).getUse()*100));
                        break;
                    case "Cafetera":
                        tvCafetera.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvCafetera.getText().toString()) + eventList.get(i).getUse()*895));
                        break;
                    case "Radiograbadora":
                        tvRadiograbadora.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvRadiograbadora.getText().toString()) + eventList.get(i).getUse()*70));
                        break;
                    case "Lavadora ropa (automatica)":
                        tvLavadora.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvLavadora.getText().toString()) + eventList.get(i).getUse()*510));
                        break;
                    case "Horno de microondas":
                        tvHorno.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvHorno.getText().toString()) + eventList.get(i).getUse()*1450));
                        break;
                    case "Plancha":
                        tvPlancha.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvPlancha.getText().toString()) + eventList.get(i).getUse()*1000));
                        break;
                    case "Ventilador":
                        tvVentilador.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvVentilador.getText().toString()) + eventList.get(i).getUse()*85));
                        break;
                    case "Televisor color":
                        tvTelevisor.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvTelevisor.getText().toString()) + eventList.get(i).getUse()*400));
                        break;
                    case "Refrigerador":
                        tvRefrigerador.setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                tvRefrigerador.getText().toString()) + eventList.get(i).getUse()*610));
                        break;
                    default:
                        break;
                }
            }
        }
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
