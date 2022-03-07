package com.example.javaexample.data.local.productdb;

import static com.example.javaexample.application.AppConstants.COLUMN_PRODUCT_ID;
import static com.example.javaexample.application.AppConstants.COLUMN_PRODUCT_NAME;
import static com.example.javaexample.application.AppConstants.DB_PRODUCT_NAME;
import static com.example.javaexample.application.AppConstants.DB_PRODUCT_VERSION;
import static com.example.javaexample.application.AppConstants.PRODUCTS_TABLE;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.javaexample.data.model.Product;

public class ProductDBHandlerDataSourceImpl extends SQLiteOpenHelper implements ProductDBHandlerDataSource {

    public ProductDBHandlerDataSourceImpl(
            @Nullable Context context,
            @Nullable String name,
            @Nullable SQLiteDatabase.CursorFactory factory,
            int version
    ) {
        super(context, DB_PRODUCT_NAME, factory, DB_PRODUCT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateProductTable = "CREATE TABLE " + PRODUCTS_TABLE + " ( " + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_NAME + " TEXT);";
        db.execSQL(queryCreateProductTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String queryDeleteProductsTableIfAlreadyExists = "DROP TABLE IF EXISTS " + PRODUCTS_TABLE;
        db.execSQL(queryDeleteProductsTableIfAlreadyExists);
        onCreate(db);

    }

    @Override
    public void createProduct(Product product) {
        /*
            Método para crear un producto en la base de datos.
        */
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, product.getProductName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(PRODUCTS_TABLE, null, values);
        db.close();

    }

    @Override
    public void deleteProduct(String productName) {
        /*
            Método para eliminar un producto en la base de datos.
        */
        String queryDeleteProduct = "DELETE FROM " + PRODUCTS_TABLE + " WHERE " + COLUMN_PRODUCT_NAME + " = " + productName + ";";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(queryDeleteProduct);
    }

    @SuppressLint("Range")
    @Override
    public String dbToString() {
        /*
            Método para convertir la base de datos a String.
        */
        String dbString = "";
        String querySelectAllFromProductsTable = "SELECT * FROM " + PRODUCTS_TABLE + ";";

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(querySelectAllFromProductsTable, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            if (cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME)) != null) {
                dbString += cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME));
                dbString += "\n";
            }

            cursor.moveToNext();

        }

        db.close();

        return dbString;

    }

}