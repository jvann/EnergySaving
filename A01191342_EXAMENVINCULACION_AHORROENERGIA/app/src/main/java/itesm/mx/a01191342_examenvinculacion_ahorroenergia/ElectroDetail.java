package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElectroDetail extends AppCompatActivity implements View.OnTouchListener {

    private ArrayList<Electro> electrosList;
    private ImageView ivPicture;
    private TextView tvNameElectro;
    private TextView tvKwh;

    private static String DEBUG_TAG = "ELECTRO_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electro_detalle);

        ivPicture = (ImageView) findViewById(R.id.image_electro_detail);
        tvNameElectro = (TextView) findViewById(R.id.text_detail_electro);
        tvKwh = (TextView) findViewById(R.id.text_kwh_detail);
        ivPicture.setOnTouchListener(this);
        electrosList = MasterData.getInstance().getAllElectros();

        Bundle data = getIntent().getExtras();
        if (data != null) {
            setViewDetail(data.getInt("position"));
        }

    }

    private void setViewDetail(int position) {
        ivPicture.setImageResource(electrosList.get(position).getPicture());
        tvNameElectro.setText(electrosList.get(position).getNameE());
        tvKwh.setText(electrosList.get(position).getWatts() + " KWH");
    }

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            int action = event.getAction();

            switch(action) {
                case (MotionEvent.ACTION_DOWN) :
                    Log.d(DEBUG_TAG,"Action was DOWN");
                    return true;
                case (MotionEvent.ACTION_MOVE) :
                    Log.d(DEBUG_TAG,"Action was MOVE");
                    return true;
                case (MotionEvent.ACTION_UP) :
                    Log.d(DEBUG_TAG,"Action was UP");
                    return true;
                case (MotionEvent.ACTION_CANCEL) :
                    Log.d(DEBUG_TAG,"Action was CANCEL");
                    return true;
                case (MotionEvent.ACTION_OUTSIDE) :
                    Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                            "of current screen element");
                    return true;
                default :
                    return super.onTouchEvent(event);
            }
        }
}
