package com.hanora.mahmoud.oht105.java;

import android.provider.BaseColumns;

/**
 * Created by Muhammad on 6/13/2016.
 */
public final class DBContract {
    public static final String DB_NAME = "TheDataBase.db";
    public static final int VERSION = 1;


    public DBContract() {
    }

    public static abstract class Figuers implements BaseColumns {
        public static final String TABLE_NAME = "figures";

        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_BRIEF = "brief";
        public static final String COLUMN_NAME_DATE_FROM = "from";
        public static final String COLUMN_NAME_DATE_TO = "to";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_FRONTNOTE = "frontnote";
    }
}
