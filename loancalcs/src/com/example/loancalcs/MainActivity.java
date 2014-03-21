package com.example.loancalcs;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.EditText;
import android.util.Log;
import android.text.TextWatcher;
import android.text.Editable;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final EditText loanText1  =(EditText)findViewById(R.id.editText1);
		 final SeekBar sk=(SeekBar) findViewById(R.id.seekBar1);
		 loanText1.addTextChangedListener(new TextWatcher(){
			 
			 @Override 
			 public void beforeTextChanged(CharSequence s, int start,int count,int after){
			 }
			 
			 @Override 
			 public void afterTextChanged(Editable s){
			 }
			 
	            @Override
	            public void onTextChanged(CharSequence s, int start, int before, int count) {
				 try{
					 sk.setProgress(Integer.parseInt(loanText1.getText().toString()));
				 } catch (Exception ex){}
			 }
		 });
		 
		 final EditText LoanVal = (EditText) findViewById(R.id.editText1); 
		 sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			    @Override
			    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			    	int progress1 = progress/1000;
			    	progress = progress1 * 1000;
			    	seekBar.setProgress(progress);
			        LoanVal.setText(String.valueOf(progress));
			        updateEMI();
			    }
			    @Override
			    public void onStartTrackingTouch(SeekBar seekBar) {

			    }

			    @Override
			    public void onStopTrackingTouch(SeekBar seekBar) {

			    }
		 });
		 final SeekBar sk1=(SeekBar) findViewById(R.id.seekBar2);
		 final EditText InterestVal = (EditText) findViewById(R.id.editText2); 
		 sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			    @Override
			    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			        InterestVal.setText(String.valueOf(progress));
			        updateEMI();
			    }
			    @Override
			    public void onStartTrackingTouch(SeekBar seekBar) {

			    }

			    @Override
			    public void onStopTrackingTouch(SeekBar seekBar) {

			    }
		 });
		 final SeekBar sk2=(SeekBar) findViewById(R.id.seekBar3);
		 final EditText TenureVal = (EditText) findViewById(R.id.editText3); 
		 sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			    @Override
			    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			        TenureVal.setText(String.valueOf(progress));
			        updateEMI();
			    }
			    @Override
			    public void onStartTrackingTouch(SeekBar seekBar) {

			    }

			    @Override
			    public void onStopTrackingTouch(SeekBar seekBar) {

			    }
		 });
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void updateEMI(){
		int LoanAmount = ((SeekBar) findViewById(R.id.seekBar1)).getProgress();
		int Interest = ((SeekBar) findViewById(R.id.seekBar2)).getProgress();
		int Tenure = ((SeekBar) findViewById(R.id.seekBar3)).getProgress();
		final EditText emi  = (EditText) findViewById(R.id.editText4);
		if(Interest > 5){
		float monthlyInterest = (float)Interest/1200;
		Log.d("LOan", monthlyInterest + "ismonthly");
		float P = (float) LoanAmount * monthlyInterest; 
		
		System.out.println(P + "is P");
		float X = (float) Math.pow(1+monthlyInterest, Tenure);
		System.out.println(X + "is X");
		float e = P * X /(X -1);
		System.out.println(e + "is e");
		emi.setText(String.valueOf((int)e));
			
		
		}
				//(int)(((LoanAmount * monthlyInterest) * Math.pow((1+monthlyInterest),Tenure)/(Math.pow((1+monthlyInterest),Tenure)-1))));
	}
	

}
