package testex;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class ChamaMain {
    
    public static boolean sorteio(String val){
        
        if(ListaDeExDisparada.exDisparada.contains(val)) return false;
        else{
            ListaDeExDisparada.exDisparada.add(val);
            return true;
        }
        
//        int sorteio = (int)(Math.random()*10);
//        
//        
//        
//        if (sorteio > 5) return true;
//        else return false;
        
        
    }
    
}

