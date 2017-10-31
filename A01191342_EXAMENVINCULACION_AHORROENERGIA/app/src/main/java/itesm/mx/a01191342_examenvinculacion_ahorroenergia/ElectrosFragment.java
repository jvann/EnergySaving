package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectrosFragment extends Fragment implements AdapterView.OnItemClickListener{

    private static final String DEBUG_TAG = "TAG_FRAG_ELECTROS";

    private ArrayList<Electro> listElectros;
    private ElectroAdapter adapter;
    private ElectroOperations dao;
    private ListView list;

    public ElectrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(DEBUG_TAG, "onCreate() has been called.");
    }

    public static ElectrosFragment newInstance() {

        return new ElectrosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(DEBUG_TAG, "onCreateView() has been called.");
        View view = inflater.inflate(R.layout.fragment_electros, container, false);

        dao = new ElectroOperations(getContext());//HERE POSSIBLE PROBLEM.
        dao.open();

        list = (ListView) view.findViewById(R.id.list_electros);
        listElectros = showProducts();
        list.setOnItemClickListener(this);
        adapter = new ElectroAdapter(getContext(), listElectros);//HERE POSSIBLE PROBLEM
        list.setAdapter(adapter);

        return view;
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the lsit is selected(clicked).

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    public ArrayList<Electro> showProducts() {

        ArrayList<Electro> electroList = MasterData.getInstance().getAllElectros();

        if (electroList != null) {
            return electroList;
        } else {
            return null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        OnItemClickedListener listener = (OnItemClickedListener) getActivity();

        Log.d(DEBUG_TAG, "onListItemClick() has been called.");
        listener.onElectroSelected(position);
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
