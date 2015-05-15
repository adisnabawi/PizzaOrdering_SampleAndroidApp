package com.example.pizzaordering;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayOrder extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_order);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		String messageadd = intent.getStringExtra(MainActivity.ORDER_ADD);
		String messageadd1 = intent.getStringExtra(MainActivity.ORDER_ADD2);
		String messageadd2 = intent.getStringExtra(MainActivity.ORDER_ADD3);
		double total = 10;
		if(messageadd == null)
		{
		messageadd = "With no Cheese + ";
		total = 10;
		}
		
		
		if(messageadd1 == null)
		{
		messageadd1 = " with no Mushroom  ";
		total = 10 + 0.5;
		}
		if(messageadd2 == null)
		{
		messageadd2 = "  + with no Tomato. ";
		total = 10 +0.5;
		}
		
		if(message !=null)
		{
			int a = Integer.parseInt(message);
			total = total*a;
		}
		
		final String result = ("Your order is "+message +" \n " + messageadd + messageadd1 + messageadd2 +"\n\n Your total:" + total + "\n\n" + "If you agree, we will now activate your sms to complete your order.");
		
		TextView tv = (TextView) findViewById(R.id.textView1);
	    tv.setTextSize(30);
		tv.setText(result);
	
		
		Button button = (Button) findViewById(R.id.buttonORDER);
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String number = "0132737059";
            	try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(number, null, result, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
            	/*
            	Uri smsUri = Uri.parse("sms:+60175728145");
            	Intent sendIntent = new Intent(Intent.ACTION_VIEW, smsUri);
            	sendIntent.putExtra("Message of Pizza", result); 
            	startActivity(sendIntent);
            	*/
            }
        });
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_order, menu);
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
