package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/31/17.
 */

public class MasterData {
    private static MasterData instance = null;

    private MasterData() {

        if (instance != null) {
            throw new RuntimeException("Use getInstance() to get a single instance of MasterData");
        }

    }

    public static MasterData getInstance() {
        if (instance == null) {
            synchronized (MasterData.class) {
                if (instance == null) {
                    instance = new MasterData();
                }
            }
        }
        return instance;
    }

    public ArrayList<Electro> getAllElectros () {

        ArrayList<Electro> listElectros = new ArrayList<Electro>();

        Electro electro;
        electro = new Electro ("Licuadora", 125, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Estereo musical", 100, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Cafetera", 895, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Radiograbadora", 70, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Lavadora ropa (automatica) ", 510, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Horno de microondas ", 1450, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Plancha", 1000, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Ventilador", 85, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Televisor color", 400, R.drawable.meditation);
        listElectros.add(electro);
        electro = new Electro ("Refrigerador", 610, R.drawable.meditation);
        listElectros.add(electro);

        return listElectros;
    }
}
