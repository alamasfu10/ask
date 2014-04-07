package com.example.ask;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.ask.PreguntasSQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NuevaPregunta extends Activity {

//	private int id;
//	private String fecha;
//	private String text;
//	private int nRespuestas;
//	Usuario usuario;
//	
//	public NuevaPregunta() {}
//	public NuevaPregunta (	  Usuario usuario, 
//							  String fecha, 
//							  String text, 
//							  int nRespuestas){	
//		this.usuario = usuario;
//		this.fecha = fecha;
//		this.text = text;
//		this.nRespuestas = nRespuestas;	
//	}
//	
//	public int getId() {return id;}
//	public Usuario getUsuario() {return usuario;}
//	public String getFecha() {return fecha;}
//	public String getText() {return text;}
//	public int getNRespuestas() {return nRespuestas;}
//	
//	public void setId(int id) {this.id = id;}
//	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
//	public void setFecha(String fecha) {this.fecha = fecha;}
//	public void setText(String text) {this.text = text;}
//	public void setNRespuestas(int nRespuestas) {this.nRespuestas = nRespuestas;}


final int MAX_COUNT = 180;

AlertDialog.Builder nueva;

	
PreguntasSQLiteHelper preguntasDB;
SQLiteDatabase db;
Cursor c;

ArrayList<String> preguntas;


public void nuevaPregunta(){


	preguntasDB = new PreguntasSQLiteHelper (this, "Preguntas", null, 1);		
	db = preguntasDB.getWritableDatabase();
	
	//preguntasDB.onCreate(db);
	System.out.println(db);

	
//	View v = this.getLayoutInflater().inflate(R.layout.nueva_pregunta, null);
//	EditText editText = (EditText) v.findViewById(R.id.id1);
//	String s1 = editText.getText().toString();

	String nombre = "Hola";
	String apellidos = "Hola";
	String numero = "Hola";
	String calle = "Hola";
	String twitter = "Hola";
	
	if(db != null)
	{      	          

		String rellenar ="INSERT INTO Preguntas (col_nombre, col_apellidos, col_numero, col_calle, col_twitter) " +
                "VALUES ('" + nombre + "', '" + apellidos + "', '" + numero + "', '" + calle + "', '" + twitter + "')" ;

        db.execSQL(rellenar);     

        db.close();                               
       

        
        
	}   
	Intent intent = new Intent (this, MainActivity.class);
	startActivity(intent);   
}


public String getFecha(){
	Calendar c = Calendar.getInstance();
	Time now = new Time();
	return c.toString() + " " + now.toString();
}



	public void crearDialogo() {
		
		final EditText txtStatus;
		final TextView lblCount;
		
		
	    nueva = new AlertDialog.Builder(this);
	    AlertDialog alert = nueva.create();


	    View v = this.getLayoutInflater().inflate(R.layout.nueva_pregunta, null);
	    alert.setView(v);

	    alert.show();  
	    
	    
	    txtStatus = (EditText) v.findViewById(R.id.id1);
	    lblCount =  (TextView) v.findViewById(R.id.id2);

	    // Attached Listener to Edit Text Widget
	    txtStatus.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {

				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			public void afterTextChanged(Editable s) {
				
				int count = MAX_COUNT - s.length();
				lblCount.setText(Integer.toString(count));
				if(count < 0)
				{
					lblCount.setTextColor(Color.RED);
				}
				
			}
		});

		Button enviar = (Button) v.findViewById(R.id.enviar);
		enviar.setOnClickListener(new OnClickListener() {
			
            public void onClick(View v) {    
            	System.out.println("hola3");
            	nuevaPregunta();
              }
       });
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_pregunta);
		
		crearDialogo();
	

		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva, menu);
		return true;
	}


	
}
