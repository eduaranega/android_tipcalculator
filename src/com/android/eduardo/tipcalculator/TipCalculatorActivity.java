package com.android.eduardo.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private boolean isEmpty(EditText etText) {
	    if (etText.getText().toString().trim().length() > 0) {
	        return false;
	    } else {
	        return true;
	    }
	}
	
	public void calculateTip(View view) {
		
		double percentage = Double.parseDouble((String) view.getTag()) / 100;
		
		EditText etAmount = (EditText)findViewById(R.id.editAmount);
		TextView tvTip = (TextView)findViewById(R.id.textTip);
		
		if (!isEmpty(etAmount)) {
			double tip = percentage * Double.parseDouble(etAmount.getText().toString());
			DecimalFormat df = new DecimalFormat("'$ '0.00");
			tvTip.setText(df.format(tip));	
		}
		else {
			tvTip.setText("$ 0.00");	
		}
	}
	
}
