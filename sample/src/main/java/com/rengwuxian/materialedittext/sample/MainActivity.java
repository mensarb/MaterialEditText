package com.rengwuxian.materialedittext.sample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		initEnableBt();
		initSingleLineEllipsisEt();
		initSetErrorEt();
		initValidationEt();
  }

	private void initEnableBt() {
		final EditText basicEt = (EditText) findViewById(R.id.basicEt);
		final Button enableBt = (Button) findViewById(R.id.enableBt);
		enableBt.setOnClickListener(v -> {
			basicEt.setEnabled(!basicEt.isEnabled());
			enableBt.setText(basicEt.isEnabled() ? "DISABLE" : "ENABLE");
		});
	}

	private void initSingleLineEllipsisEt() {
		EditText singleLineEllipsisEt = (EditText) findViewById(R.id.singleLineEllipsisEt);
		singleLineEllipsisEt.setSelection(singleLineEllipsisEt.getText().length());
	}

	private void initSetErrorEt() {
		final EditText bottomTextEt = (EditText) findViewById(R.id.bottomTextEt);
		final Button setErrorBt = (Button) findViewById(R.id.setErrorBt);
		setErrorBt.setOnClickListener(v -> bottomTextEt.setError("1-line Error!"));
		
		final Button setError2Bt = (Button) findViewById(R.id.setError2Bt);
    setError2Bt.setOnClickListener(v -> bottomTextEt.setError("2-line\nError!"));
	
		final Button setError3Bt = (Button) findViewById(R.id.setError3Bt);
    setError3Bt.setOnClickListener(v -> bottomTextEt.setError("So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors!"));
	}

	private void initValidationEt() {
		final MaterialEditText validationEt = (MaterialEditText) findViewById(R.id.validationEt);
    validationEt.addValidator(new RegexpValidator("Only Integer Valid!", "\\d+"));
	
		final Button validateBt = (Button) findViewById(R.id.validateBt);
		validateBt.setOnClickListener(v -> {
		  // validate
		  validationEt.validate();
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
