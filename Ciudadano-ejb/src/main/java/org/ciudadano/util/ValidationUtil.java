
package org.ciudadano.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static boolean isEmpty(String value){
        return (value.equals("") || value.isEmpty());
    }
    
    public static boolean isEmpty(int value){
        return value == 0;
    }
    
    public static boolean isEmpty(char value){
        return value <= 0; 
    }
    
    public static boolean isEmpty(Date value){
        return value == null; 
    }
    
    
    
    
    public static boolean isValidEmail(String value){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher((CharSequence)value);
        
       return matcher.matches();
    }
    
    public static boolean isValidSexo(char value){
        return Character.toString(value).equals("F") || Character.toString(value).equals("M"); 
    }
}
