package scans;
/**  
 * The phurpose of this class
 * is to check all the inputs
 * made in 16/10/2016
 * 
 * Info:
 *   Input.string("String ");   check if input is only letters
 * 
 *   TODO: Input.float("String ")     check if input is only float
 * 
 *   Input.integer("String ")   check if input is only int
 * 
 */
import java.util.Scanner;
import java.lang.String;
/**
 * owner oples
 */

public class Inputs{
    
	private static boolean check_alpha(String str) {
        
        boolean check = true;
        
        if (!str.isEmpty())
        {
            for(int i = 0; i<str.length(); i++)
            {
                // Letter check
                if(!Character.isLetter(str.charAt(i)))
                {
                    // else check if the char is a whitespace
                    if (str.charAt(i)!=(char)32)
                    {
                        System.out.println((char)27+"[031m"+(char)27+"[4mInsert an alpha word please"+(char)27+"[0m");
                        // break and return false for the while
                        check = false;
                        break;
                    }
                }
            }
        }
        else
        {
            //System.out.println((char)27+"[031mInsert a word!"+(char)27+"[0m");
            check = false;
        }
        return check;
	}
    public static String string(String msg){
        
        // initialize
        Scanner in_str = new Scanner(System.in);
        String ok="";
        
        // looop until input is true (letters + whitespace)
        do{
            // prints message that wellcomes to input plus input
            
            System.out.print((char)27+"[36m"+msg+(char)27+"[0m");
            ok = in_str.nextLine();
            
        }while(!check_alpha(ok));   // big boss check input
        
        return ok; // return final checked string
    }
    
    private static boolean number(String ok){
        
        int num =0;
        boolean check= true;
        
        try{
            // initialize
            Scanner in_int = new Scanner(System.in);
            
            if (Double.parseDouble(ok) <=2147483647 && Double.parseDouble(ok) >=-2147483648)
            {
                num = Integer.parseInt(ok);
                return check; // return final checked string
            }
            else
            {
                System.out.println((char)27+"[031m"+(char)27+"[4mInt number Must be between +2147483647  and  -2147483648"+(char)27+"[0m");
                check = false;
            }
            return check; // return forced
        }
        catch (NumberFormatException e)
        {
            System.out.println((char)27+"[031m"+(char)27+"[4mInsert Numbers!"+(char)27+"[0m");
            check = false;
        }
        catch(Exception e)
        {
            System.out.println("ERROR: "+e);
        }
        return check; // return final checked string
    }
    
    public static int integer(String msg){
        
        // initialize
        Scanner in_int = new Scanner(System.in);
        String ok="";
        
        // looop until input is true int
        do{
            // prints message that wellcomes to input plus input
            
            System.out.print((char)27+"[36m"+msg+(char)27+"[0m");
            ok = in_int.nextLine();
            
        }while(!number(ok));   // big boss check input
        
        int kek = Integer.parseInt(ok);
        
        return kek; // return final checked string
    }
    
}
