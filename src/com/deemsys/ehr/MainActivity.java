package com.deemsys.ehr;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actbar=getActionBar();
	    actbar.show();
	    actbar.setSubtitle("Electronic Healthcare record");
        setContentView(R.layout.activity_main);
        
        
        
        TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec adminspec = tabHost.newTabSpec("Admin");
        // setting Title and Icon for the Tab
        adminspec.setIndicator("Admin Login", getResources().getDrawable(R.drawable.icon_admin_tab));
        Intent adminIntent = new Intent(this, adminlogin.class);
        adminspec.setContent(adminIntent);
         
        // Tab for Songs
        TabSpec doctorspec = tabHost.newTabSpec("Doctor");        
        doctorspec.setIndicator("Doctor Login", getResources().getDrawable(R.drawable.icon_doctor_tab));
        Intent doctorIntent = new Intent(this, doctorlogin.class);
        doctorspec.setContent(doctorIntent);
         
        // Tab for Videos
        TabSpec patientspec = tabHost.newTabSpec("Patient");
        patientspec.setIndicator("Patient Login", getResources().getDrawable(R.drawable.icon_patient_tab));
        Intent patientIntent = new Intent(this, patientlogin.class);
        patientspec.setContent(patientIntent);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(adminspec); // Adding admin tab
        tabHost.addTab(doctorspec); // Adding doctor tab
        tabHost.addTab(patientspec); // Adding patient tab
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
