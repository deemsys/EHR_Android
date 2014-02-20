package com.deemsys.ehr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;





public class splashscreen extends Activity {
	
	 private static int SPLASH_TIME_OUT = 9000;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.splashscreen);
	 
	        new Handler().postDelayed(new Runnable() {
	 
	          
	            @Override
	            public void run() {
	                
	                Intent i = new Intent(splashscreen.this,MainActivity.class);
	                startActivity(i);
	 
	               
	                finish();
	            }
	        }, SPLASH_TIME_OUT);
	    }
	 

}
