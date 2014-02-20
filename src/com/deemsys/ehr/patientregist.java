//Copyrights, DeemsysInc
//Author, Uday JC
package com.deemsys.ehr;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;

public class patientregist extends Activity {
	private EditText patientusername;
	private EditText registeremail;
	private EditText patientpassword;
	private EditText patientconformpassword;
	private Button createaccount;
	final Context context= this;
	Button change;
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	 ActionBar actbar=getActionBar();
	    actbar.show();
	    actbar.setSubtitle("Patient Registration");
	    getActionBar().setDisplayHomeAsUpEnabled(true);
    setContentView(R.layout.patient_regist);
    registerViews();
   
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
       	// Intent intentSignUP=new Intent(getApplicationContext(),Questionnaire.class);
   			//startActivity(intentSignUP);  
           finish();
     }
    return true;
}

private void registerViews()
{
	patientusername = (EditText) findViewById(R.id.editTextUserName);
	patientusername.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Validation.hasText(patientusername);
        }	
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
        public void onTextChanged(CharSequence s, int start, int before, int count){}
    });
	
	registeremail = (EditText) findViewById(R.id.registeremail);
    registeremail.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Validation.isEmailAddress(registeremail, false);
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
        public void onTextChanged(CharSequence s, int start, int before, int count){}
    });
    
    patientpassword  = (EditText) findViewById(R.id.editTextPassword);
    
    patientpassword.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable s) {
         }
         public void beforeTextChanged(CharSequence s, int start, int count, int after){}
         public void onTextChanged(CharSequence s, int start, int before, int count){}
     });
     
   
     
     patientconformpassword = (EditText) findViewById(R.id.editTextConfirmPassword);
     patientconformpassword.addTextChangedListener(new TextWatcher() {
      
         public void afterTextChanged(Editable s) {      	 
         }
         public void beforeTextChanged(CharSequence s, int start, int count, int after){}
         public void onTextChanged(CharSequence s, int start, int before, int count){}
     });

     
     createaccount= (Button) findViewById (R.id.buttonCreateAccount);
     createaccount.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             /*
             Validation class will check the error and display the error on respective fields
             but it won't resist the form submission, so we need to check again before submit
              */
             if ( checkValidation () )
                 submitForm();
            
         }
     });
        
     
}
private void submitForm() {
    // Submit your form here. your form is valid
    //Toast.makeText(this, "Registering...", Toast.LENGTH_LONG).show();
	 final Dialog dialog = new Dialog(context);
	 dialog.setContentView(R.layout.dialogbox);
	 dialog.setTitle("Sucess!");
	 dialog.setCancelable(false);
 dialog.setCanceledOnTouchOutside(false);
	 TextView txt = (TextView) dialog.findViewById(R.id.errorlog);
	  txt.setText("Registration Successfull.");
	  Button dialogButton = (Button) dialog.findViewById(R.id.release);
	  dialogButton.setOnClickListener(new OnClickListener() {
		  public void onClick(View vd) {
			   dialog.dismiss();
			 change.setEnabled(true);
		  }
		});
		  dialog.show();
}

private boolean checkValidation() {
    boolean ret = true;

    if (!Validation.hasText(patientusername)) ret = false;
    if (!Validation.isEmailAddress(registeremail, true)) ret = false;
    if(!Validation.isEqualpass(patientpassword,patientconformpassword,true))
     ret=false; 

    return ret;
}
}