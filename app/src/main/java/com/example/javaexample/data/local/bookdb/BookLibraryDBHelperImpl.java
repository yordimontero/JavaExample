package com.example.javaexample.data.local.bookdb;

import static com.example.javaexample.application.AppConstants.COLUMN_BOOK_AUTHOR;
import static com.example.javaexample.application.AppConstants.COLUMN_BOOK_ID;
import static com.example.javaexample.application.AppConstants.COLUMN_BOOK_PAGES;
import static com.example.javaexample.application.AppConstants.COLUMN_BOOK_TITLE;
import static com.example.javaexample.application.AppConstants.DB_BOOK_LIBRARY_NAME;
import static com.example.javaexample.application.AppConstants.DB_BOOK_LIBRARY_VERSION;
import static com.example.javaexample.application.AppConstants.LIBRARY_TABLE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookLibraryDBHelperImpl extends SQLiteOpenHelper implements BookLibraryDBHelper {

    private Context context;

    public BookLibraryDBHelperImpl(@Nullable Context context) {
        super(context, DB_BOOK_LIBRARY_NAME, null, DB_BOOK_LIBRARY_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
            Create Table - SQL Schema.
        */
        String queryCreateLibraryTable = "CREATE TABLE " + LIBRARY_TABLE +
                " (" + COLUMN_BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BOOK_TITLE + " TEXT, " +
                COLUMN_BOOK_AUTHOR + " TEXT, " +
                COLUMN_BOOK_PAGES + " INTEGER" + ");";

        db.execSQL(queryCreateLibraryTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

         String queryDropLibraryTableIfExists = "DROP TABLE IF EXISTS " + LIBRARY_TABLE + ";";
         db.execSQL(queryDropLibraryTableIfExists);
         onCreate(db);

    }

}
