package com.example.ask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 

public class PreguntasSQLiteHelper extends SQLiteOpenHelper {
 
    String crearTabla = "CREATE TABLE Preguntas (" +
    		"col_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
    		"col_nombre TEXT, " +
    		"col_apellidos TEXT, " +
    		"col_numero TEXT, " +
    		"col_calle TEXT, " +
    		"col_twitter TEXT" +
    		") ";
    
    public PreguntasSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
        
    @Override
    public void onCreate(SQLiteDatabase db) {      
        db.execSQL(crearTabla);
    }
 
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
 
        db.execSQL("DROP TABLE IF EXISTS Preguntas");
 
        db.execSQL(crearTabla);
    }    
}