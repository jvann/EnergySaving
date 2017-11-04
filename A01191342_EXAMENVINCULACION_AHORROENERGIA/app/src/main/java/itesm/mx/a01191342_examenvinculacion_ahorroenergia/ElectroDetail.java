package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
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

    private GestureDetectorCompat mDetector;
    private MyGestureListener myGestureListener;

    private int indice;

    private static String DEBUG_TAG = "ELECTRO_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electro_detalle);

        View view = findViewById(R.id.layout_detalle_electro);
        view.setOnTouchListener(this);

        myGestureListener = new MyGestureListener();
        mDetector = new GestureDetectorCompat(this, myGestureListener);

        ivPicture = (ImageView) findViewById(R.id.image_electro_detail);
        tvNameElectro = (TextView) findViewById(R.id.text_detail_electro);
        tvKwh = (TextView) findViewById(R.id.text_kwh_detail);
        ivPicture.setOnTouchListener(this);
        electrosList = MasterData.getInstance().getAllElectros();

        Bundle data = getIntent().getExtras();
        if (data != null) {
            setViewDetail(data.getInt("position"));
        }

        indice = 0;

    }

    private void setViewDetail(int position) {
        ivPicture.setImageResource(electrosList.get(position).getPicture());
        tvNameElectro.setText(electrosList.get(position).getNameE());
        tvKwh.setText(electrosList.get(position).getWatts() + " KWH");
    }

        @Override
        public boolean onTouch(View view, MotionEvent event) {
//            int action = event.getAction();
//
//            switch(action) {
//                case (MotionEvent.ACTION_DOWN) :
//                    Log.d(DEBUG_TAG,"Action was DOWN");
//                    return true;
//                case (MotionEvent.ACTION_MOVE) :
//                    Log.d(DEBUG_TAG,"Action was MOVE");
//                    return true;
//                case (MotionEvent.ACTION_UP) :
//                    Log.d(DEBUG_TAG,"Action was UP");
//                    return true;
//                case (MotionEvent.ACTION_CANCEL) :
//                    Log.d(DEBUG_TAG,"Action was CANCEL");
//                    return true;
//                case (MotionEvent.ACTION_OUTSIDE) :
//                    Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
//                            "of current screen element");
//                    return true;
//                default :
//                    return super.onTouchEvent(event);
//            }
            mDetector.onTouchEvent(event);
            return true;
        }

    public class MyGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener  {

        public String DEBUG_TAG = "GESTURE_LISTENER";

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d(DEBUG_TAG, "onShowPress");
        }
        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(DEBUG_TAG, "onLongPress");
        }
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(DEBUG_TAG, "onSingleTapUp");
            return false;
        }
        @Override
        public boolean onScroll(MotionEvent e, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(DEBUG_TAG, "onScroll");
            return false;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling");
            if (e1.getX() > e2.getX()) {
                Log.d(DEBUG_TAG, "onFling RIGHT");
                if (indice >= 9) {
                    indice = 0;
                } else {
                    indice = indice + 1;
                }

                setViewDetail(indice);
            }
            if (e1.getX() < e2.getX()) {
                Log.d(DEBUG_TAG, "onFling LEFT");

                if (indice <= 0) {
                    indice = 9;
                } else {
                    indice = indice - 1;
                }

                setViewDetail(indice);
            }
            return false;
        }
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDown");
            return false;
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d(DEBUG_TAG, "onSingleTapConfirmed");
            return false;
        }
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDoubleTap");
            return false;
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDoubleTapEvent");
            return false;
        }
    }
}
