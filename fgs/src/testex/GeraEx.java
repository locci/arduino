package testex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author alexandre
 */
public class GeraEx {
    
    public static void geraEx(String str) throws Exception{
        
        if(str.equals("FileNotFoundException")){
            
            throw new FileNotFoundException();
            
        }else{
            
        if(str.equals("IOException")){
            
             throw new IOException(); 
             
        }else{
            
        if(str.equals("ArithmeticException")){
            
             throw new ArithmeticException();
             
        }else{
            
        if(str.equals("ArrayIndexOutOfBoundsException")){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }else{
            if(str.equals("ClassNotFoundException")){
            
            throw new ClassNotFoundException();
            
        }else{

        if(str.equals("NoSuchMethodException")){
            
            throw new NoSuchMethodException();
            
        }else{
            
        if(str.equals("IllegalAccessException")){
            
            throw new IllegalAccessException();
            
        }else{
           
        if(str.equals("InvocationTargetException")){
            
            throw new InvocationTargetException(null);
           
        }else{
        if(str.equals("Exception")){
                
                throw new Exception();
               
        }	
        }
        }
        }
        }    
        }          
        }  
        }
        }
        }
    
}
