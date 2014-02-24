/**
 * 2014 - Semester b
 * PostPC ex1 - 12% Tip Calculator Android app implementation.
 * 
 * Author: Tzafrir Harazy
 * CS Username: tzafrirharaz
 */

package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity implements OnClickListener {

	private final double TIP_PERCENTAGE = 0.12;
	private final double ROUND_PARAM = 0.5;
	private final char CURRENCY_SIGN = '$';
	
	private EditText billAmount;
	private CheckBox roundCheckBox;
	private Button calcButton;
	private TextView tipResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_caculator);
		billAmount = (EditText) findViewById(R.id.billAmountInput);
		roundCheckBox = (CheckBox) findViewById(R.id.roundCheckBox);
		calcButton = (Button) findViewById(R.id.calcButton);
		calcButton.setOnClickListener(this);
		tipResult = (TextView) findViewById(R.id.tipResult);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Double input = Double.parseDouble(billAmount.getText().toString());
		Double tip = input * TIP_PERCENTAGE;
		if (roundCheckBox.isChecked()) {
			tipResult.setText(CURRENCY_SIGN + round(tip));
		}
		else {
			tipResult.setText(CURRENCY_SIGN + tip.toString());
		}
	}

	/**
	 * A method that rounds its input number to the closest natural number.  
	 * 
	 * @param num - a real valued number.
	 * @return the closest natural number to the input.
	 */
	private String round(Double num) {
		if ((num - Math.floor(num)) < ROUND_PARAM) {
			return Integer.toString((int) Math.floor(num));
		}
		else {
			return Integer.toString((int) Math.floor(num));
		}
	}


}
