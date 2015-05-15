package com.example.pizzaordering;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity {

	protected static final String EXTRA_MESSAGE = null;
	protected static final String ORDER_ADD = "Cheese Pizza";
	protected static final String ORDER_ADD2 = "with Mushroom ";
	protected static final String ORDER_ADD3 = "with Tomato ";
	
	public static String a1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button buttonorder = (Button) findViewById(R.id.button1);
		buttonorder.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText qn = (EditText) findViewById(R.id.editText5);
				String quantity = qn.getText().toString();
				
				/*EditText em = (EditText) findViewById(R.id.editText2);
				String email = em.getText().toString();
				EditText pn = (EditText) findViewById(R.id.editText3);
				String phoneno = pn.getText().toString();
				EditText add = (EditText) findViewById(R.id.editText4);
				String address = add.getText().toString();
				EditText editText = (EditText) findViewById(R.id.editText1);
				String name = editText.getText().toString();
				
	*/          
				final Intent i = new Intent(MainActivity.this, DisplayOrder.class);
			
				RadioButton rb1 = (RadioButton)findViewById(R.id.radioButton1);
				RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
				RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
				if(rb1.isChecked() == true)
				i.putExtra(ORDER_ADD, "Cheese Pizza");	
				if(rb2.isChecked() == true)
				i.putExtra(ORDER_ADD2, " with Mushroom ");
				if(rb3.isChecked() == true)
				i.putExtra(ORDER_ADD3, " with Tomato ");
				/*boolean checked = ((RadioButton) v).isChecked();
				switch(v.getId()) 
				{
		        case R.id.radioButton1:
		            if (checked)
		                i.putExtra(ORDER_ADD, "Cheese Pizza");
		            break;
		        case R.id.radioButton2:
		            if (checked)
		                // Ninjas rule
		            break;
		        case R.id.radioButton3:
		            if (checked)
		                // Ninjas rule
		            break; 
				}
				
				*/
				i.putExtra(EXTRA_MESSAGE,quantity);
				startActivity(i);
		
			}
		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
