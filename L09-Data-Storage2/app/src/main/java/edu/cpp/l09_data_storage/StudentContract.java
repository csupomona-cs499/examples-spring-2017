package edu.cpp.l09_data_storage;

import android.provider.BaseColumns;

/**
 * Created by yusun on 5/1/17.
 */

public class StudentContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentEntry.TABLE_NAME + " (" +
                    StudentEntry._ID + " INTEGER PRIMARY KEY," +
                    StudentEntry.COLUMN_NAME_NAME + " TEXT," +
                    StudentEntry.COLUMN_NAME_MAJOR + " TEXT," +
                    StudentEntry.COLUMN_NAME_AGE + " INTEGER)";

//    private static final String SQL_DELETE_ENTRIES =
//            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    public static class StudentEntry implements BaseColumns {

        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_MAJOR = "major";
        public static final String COLUMN_NAME_AGE = "age";
    }
}
