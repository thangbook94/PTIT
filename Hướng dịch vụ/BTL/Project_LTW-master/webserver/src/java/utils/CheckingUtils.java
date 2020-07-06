/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author SA Nice
 */
public class CheckingUtils {
    public static boolean checkUsername(String user_name){
        byte[] user_name_custom = user_name.getBytes();
        for(int i = 0; i < user_name_custom.length; i++){
            if((user_name_custom[i] >= 48 && 
               user_name_custom[i] <= 57) || 
               (user_name_custom[i] >= 65 &&
               user_name_custom[i] <= 90) ||
               (user_name_custom[i] >= 97 &&
               user_name_custom[i] <= 122)){
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean checkPassword(String password)
    {
        String regularExpression="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if(password.matches(regularExpression))
        {
            return false;
        }
        else
        {
            return true;
        } 
    }
    
    public static boolean checkName(String name)
    {
        byte[] name_custom = name.getBytes();
        for(int i = 0; i < name_custom.length; i++){
            if((name_custom[i] >= 65 &&
               name_custom[i] <= 90) ||
               (name_custom[i] >= 97 &&
               name_custom[i] <= 122) ||
               name_custom[i] == 32){
            }
            else{
                return false;
            }
        }
        return true; 
    }   
    
}