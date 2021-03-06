package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.provider.BaseColumns;

/**
 * Created by Jibril on 10/30/17.
 */

public final class DataBaseSchema {

    private DataBaseSchema() {}

    public static class ElectrosTable implements BaseColumns {
        public static final String TABLE_NAME = "Electros";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WATTS = "watts";//Watts per hour.
        public static final String COLUMN_IMAGE = "image";

    }

    public static class EventsTable implements BaseColumns {
        public static final String TABLE_NAME = "Events";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_HOUR = "hour";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_USE = "use"; //In hours

    }
}
