package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectrosFragment extends Fragment {

    private static final String DEBUG_TAG = "TAG_FRAG_ELECTROS";

    private ArrayList<Electro> listElectros;
    private ElectroAdapter adapter;
    private ElectroOperations dao;
    private byte[] byteArray = null;
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
        adapter = new ElectroAdapter(getContext(), listElectros);//HERE POSSIBLE PROBLEM
        list.setAdapter(adapter);

        newElectro(2);
//        dao.deleteAllElectros();
//        refreshView();
//        dao.setElectros();
        return view;
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

//        String[] electroNames = getResources().getStringArray(R.array.dummy_electros);
        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the lsit is selected(clicked).

//        setListAdapter(new ArrayAdapter<Electro>(getActivity(), android.R.layout.simple_list_item_activated_1, listElectros));

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    public ArrayList<Electro> showProducts() {

        ArrayList<Electro> electroList = dao.getAllElectros();

        if (electroList != null) {
            return electroList;
        } else {
            return null;
        }
    }

//    @Override
//    public void onListItemClick(ListView listView, View view, int position, long id) {
//        OnItemClickedListener listener = (OnItemClickedListener) getActivity();
//
//        Log.d(DEBUG_TAG, "onListItemClick() has been called.");
//        listener.onElectroSelected(position);
//    }

    public Electro newElectro(int i) {

        //Dummy electrodomestics.
        int watts = i * 25;
        String name = "Test" + i;
        Electro electro = new Electro(name, watts, byteArray);
        long id = dao.addElectro(electro);
        electro.setID(id);

        Toast.makeText(getContext().getApplicationContext(), "Electro added", Toast.LENGTH_SHORT).show();

        return electro;
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
