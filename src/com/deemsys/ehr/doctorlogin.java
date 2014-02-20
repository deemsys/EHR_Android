//Copyrights 2014, deemsysinc
//Author uday JC

package com.deemsys.ehr;
//headers
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class doctorlogin extends Activity {
	private EditText username;
	private EditText password;
	private Button Login;
	final Context context = this;
	Button change;
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	
 
    setContentView(R.layout.doctorlogin_layout);
    logging();
    Button registerdoctor = (Button)findViewById(R.id.register);

    registerdoctor.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        Intent intent = new Intent(doctorlogin.this, doctorregist.class);
        startActivity(intent);
      }

    });
}
private void logging() 
{
	// TODO Auto-generated method stub
	username = (EditText) findViewById(R.id.Ledituname);
	username.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Validation.hasText(username);
        }	
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
        public void onTextChanged(CharSequence s, int start, int before, int count){}
    });
	
	password = (EditText) findViewById(R.id.Leditpw);
	password.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Validation.hasText(password);
        }	
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
        public void onTextChanged(CharSequence s, int start, int before, int count){}
    });
	
	Login= (Button) findViewById (R.id.login);
    Login.setOnClickListener(new View.OnClickListener() {
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
   // Toast.makeText(this, "Registering...", Toast.LENGTH_LONG).show();
    final Dialog dialog = new Dialog(context);
		 dialog.setContentView(R.layout.dialogbox);
		 dialog.setTitle("Sucess!");
		 dialog.setCancelable(false);
	 dialog.setCanceledOnTouchOutside(false);
		 TextView txt = (TextView) dialog.findViewById(R.id.errorlog);
		  txt.setText("Login In Successfull.");
		  Button dialogButton = (Button) dialog.findViewById(R.id.release);
		  dialogButton.setOnClickListener(new OnClickListener() {
			  public void onClick(View vd) {
				 change.setEnabled(true);
				 dialog.dismiss();
		
		}
		});
		  dialog.show();
}

private boolean checkValidation() {
    boolean ret = true;

    if (!Validation.hasText(username))
    	ret = false;
    if (!Validation.hasText(password)) 
    	ret = false;

    return ret;
}

}
