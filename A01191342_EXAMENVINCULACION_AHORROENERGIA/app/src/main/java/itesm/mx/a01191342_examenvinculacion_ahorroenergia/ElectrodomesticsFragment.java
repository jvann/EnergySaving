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
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectrodomesticsFragment extends ListFragment {

    private static final String DEBUG_TAG = "TAG_FRAG_ELECTROS";

    public ElectrodomesticsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(DEBUG_TAG, "onCreate() has been called.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(DEBUG_TAG, "onCreateView() has been called.");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        String[] electroNames = getResources().getStringArray(R.array.nombre_electrodomesticos);

        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the lsit is selected(clicked).
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, electroNames));

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        OnElectroSelectedListener listener = (OnElectroSelectedListener) getActivity();

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
