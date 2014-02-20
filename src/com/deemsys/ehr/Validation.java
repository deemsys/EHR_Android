//Copyright, DeemsysInc
//Author, Uday JC

package com.deemsys.ehr;

import android.widget.EditText;
import java.util.regex.Pattern;



public class Validation 
{
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$";
	private static final String Username_REGEX ="^[_A-Za-z0-9.@-]+$";
	
	private static final String Username_MSG = "Only a-z,0-9,_,@,.- allowed ";
	private static final String ERR_MSG = "Field cannot be empty";
	private static final String EMAIL_MSG = "Invalid Email";
	
	private static final String REQUIRED_MSG = "Field cannot be empty";
	private static final String REQUIRED_MSGOLD = "Invalid password";
	private static final String req_MSG = "Invalid username";
	
	private static final String PASS_MSG="Password Mismatch";
    private static final String emt="Field cannot be empty";
    
    
    public static boolean isUsername(EditText editText, boolean required)
    {
        return isValid(editText, Username_REGEX,Username_MSG, required);
    }
    public static boolean isEmailAddress(EditText editText, boolean required) 
    {
        return isValid(editText, EMAIL_REGEX,EMAIL_MSG, required);
    }
    public static boolean isEqualpass(EditText editText,EditText editText1,boolean required)
    {
    	
    	return isequal(editText,editText1,required);
    }
    
    
 // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {
 
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);
 
        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;
 
        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };
 
        return true;
    }
 
    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {
 
        String text = editText.getText().toString().trim();
        editText.setError(null);
 
        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }
 
        return true;
    }
    
 /*   public static boolean hasText2(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

     
        if (text.length() == 0) {
            editText.setError(ERR_MSG);
            return false;
        }

        return true;
    }
    */
    public static boolean isequal(EditText pass, EditText confirmpass,boolean required ) {
        String text = pass.getText().toString().trim();
        String text1 = confirmpass.getText().toString().trim();
        pass.setError(null);
       confirmpass.setError(null);
       if ( required && !hasText(pass)&& !hasText(confirmpass) ) 
    	   return false;
       
     if(!text.equals(text1)){
    	 pass.setError(PASS_MSG);
        	confirmpass.setError(PASS_MSG);
        	return false;
        	}
        return true;
       
    }
    
    public static boolean hasText1(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

       
        if (text.length() == 0) {
            editText.setError(req_MSG);
            return false;
        }

        return true;
    }
    public static boolean hasTextemt(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

    
        if (text.length() == 0) {
            editText.setError(emt);
            return false;
        }

        return true;
    }
    
    
    public static boolean hasTextConfirm(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

       
        if (text.length() == 0) {
            editText.setError(ERR_MSG);
            return false;
        }

        return true;
    }
    public static boolean hasTextNew(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

       
        if (text.length() == 0) {
            editText.setError(ERR_MSG);
            return false;
        }

        return true;
    }
    public static boolean hasTextold(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

       
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSGOLD);
            return false;
        }

        return true;
    }
   
    
}
