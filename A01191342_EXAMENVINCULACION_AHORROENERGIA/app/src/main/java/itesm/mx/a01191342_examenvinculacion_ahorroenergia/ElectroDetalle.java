package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElectroDetalle extends AppCompatActivity {

    private ArrayList<Electro> electrosList;
    private ImageView ivPicture;
    private TextView tvNameElectro;
    private TextView tvKwh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electro_detalle);

        ivPicture = (ImageView) findViewById(R.id.image_electro_detail);
        tvNameElectro = (TextView) findViewById(R.id.text_detail_electro);
        tvKwh = (TextView) findViewById(R.id.text_kwh_detail);

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
}
