package com.example.ask;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NuevaRespuesta extends Activity {

	final int MAX_COUNT = 300;
	
public void crearDialogo() {
		
		final EditText txtStatus;
		final TextView lblCount;
		
		
	    AlertDialog.Builder nueva = new AlertDialog.Builder(this);
	    nueva.create();

	    LayoutInflater inflater = this.getLayoutInflater();

	    View v = inflater.inflate(R.layout.nueva_pregunta, null);

	    nueva.setView(v);

	    nueva.show();  
	    
	    
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
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_nueva_respuesta);
		crearDialogo();
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;

	}

}
