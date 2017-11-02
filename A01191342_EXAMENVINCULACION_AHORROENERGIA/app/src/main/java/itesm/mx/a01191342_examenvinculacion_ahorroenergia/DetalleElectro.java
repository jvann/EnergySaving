package itesm.mx.a01191342_examenvinculacion_ahorroenergia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleElectro extends Fragment {

    public static String ELECTRO_INDEX = "electro_index";
    private static String DEBUG_TAG = "DETALLE_ELECTRO_FRAG";
    private int actualElectroIndex;
    private static int index;

    public DetalleElectro() {
        // Required empty public constructor
    }

    public static DetalleElectro newInstance(int position) {
        DetalleElectro detalleElectroFrag = new DetalleElectro();
        Bundle bundle = new Bundle();
        bundle.putInt(ELECTRO_INDEX, position);
        detalleElectroFrag.setArguments(bundle);
        index = position;
        return detalleElectroFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detalle_electro, container, false);
//        setElectroView(index);
        Log.d(DEBUG_TAG, "DETALLE_ELECTROS_INDEX: " + index);
        return rootView;
    }

    public void setElectroView(int index) {
        final MasterData masterData = MasterData.getInstance();

        Electro electro = masterData.getElectro(index);

    }
    @Override
    public void onStart() {
        super.onStart();
//        if (getArguments() != null) {
//            actualElectroIndex = getArguments().getInt(ELECTRO_INDEX);
//        }
//
//        setElectroView(actualElectroIndex);
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
//        dao.open();
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
//        dao.close();
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
