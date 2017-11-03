package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/31/17.
 */

public class MasterData {
    private static MasterData instance = null;

    private ArrayList<Electro> listElectros;
    private ArrayList<String> listElectroNames;

    private MasterData() {

        createData();
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

    private void createData() {

        listElectros = new ArrayList<Electro>();

        Electro electro;
        electro = new Electro ("Licuadora", 125, R.drawable.blender);
        listElectros.add(electro);
        electro = new Electro ("Estereo musical", 100, R.drawable.stereo);
        listElectros.add(electro);
        electro = new Electro ("Cafetera", 895, R.drawable.coffee);
        listElectros.add(electro);
        electro = new Electro ("Radiograbadora", 70, R.drawable.radio);
        listElectros.add(electro);
        electro = new Electro ("Lavadora ropa (automatica)", 510, R.drawable.washing);
        listElectros.add(electro);
        electro = new Electro ("Horno de microondas", 1450, R.drawable.microwave);
        listElectros.add(electro);
        electro = new Electro ("Plancha", 1000, R.drawable.iron);
        listElectros.add(electro);
        electro = new Electro ("Ventilador", 85, R.drawable.fan);
        listElectros.add(electro);
        electro = new Electro ("Televisor color", 400, R.drawable.television);
        listElectros.add(electro);
        electro = new Electro ("Refrigerador", 610, R.drawable.fridge);
        listElectros.add(electro);

        listElectroNames = new ArrayList<String>();

        String electroName;
        electroName = new String ("Licuadora");
        listElectroNames.add(electroName);
        electroName = new String ("Estereo musical");
        listElectroNames.add(electroName);
        electroName = new String ("Cafetera");
        listElectroNames.add(electroName);
        electroName = new String ("Radiograbadora");
        listElectroNames.add(electroName);
        electroName = new String ("Lavadora ropa (automatica)");
        listElectroNames.add(electroName);
        electroName = new String ("Horno de microondas");
        listElectroNames.add(electroName);
        electroName = new String ("Plancha");
        listElectroNames.add(electroName);
        electroName = new String ("Ventilador");
        listElectroNames.add(electroName);
        electroName = new String ("Televisor color");
        listElectroNames.add(electroName);
        electroName = new String ("Refrigerador");
        listElectroNames.add(electroName);

    }

    public ArrayList<Electro> getAllElectros () {
        return this.listElectros;
    }

    public ArrayList<String> getAllElectroNames () {
        return listElectroNames;
    }

    public Electro getElectro(int index) { return listElectros.get(index); }

    public int getElectro(String name) {

        for (int i = 0; i < listElectros.size(); i++) {
            if (listElectros.get(i).getNameE().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
