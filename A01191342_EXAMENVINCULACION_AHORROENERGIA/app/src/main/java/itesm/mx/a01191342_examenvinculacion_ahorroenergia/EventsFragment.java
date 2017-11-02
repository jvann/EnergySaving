package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
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
public class EventsFragment extends Fragment implements AdapterView.OnItemClickListener{

    private static final String DEBUG_TAG = "TAG_FRAG_EVENTS";

    private ArrayList<Event> listEvents;
    private EventAdapter adapter;
    private EventsOperations dao;
    private ListView listEvent;
    private View view;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(DEBUG_TAG, "onCreate() has been called.");
    }

    public static EventsFragment newInstance() {

        return new EventsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(DEBUG_TAG, "onCreateView() has been called.");

        view = inflater.inflate(R.layout.fragment_events, container, false);

        dao = new EventsOperations(this.getContext());//HERE POSSIBLE PROBLEM.
        dao.open();
        refreshView(view);

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

    public void refreshView(View view) {
        listEvent = (ListView) view.findViewById(R.id.list_events);
        listEvents = showProducts();
        listEvent.setOnItemClickListener(this);
        adapter = new EventAdapter(getContext(), listEvents);
        listEvent.setAdapter(adapter);
    }

    public ArrayList<Event> showProducts() {

        ArrayList<Event> eventList = dao.getAllEvents();

        if (eventList != null) {
            return eventList;
        } else {
            return null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        OnItemClickedListener listener = (OnItemClickedListener) getActivity();

        Log.d(DEBUG_TAG, "onListItemClick() has been called.");
        listener.onEventSelected(position);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
        dao.open();
        refreshView(view);
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
