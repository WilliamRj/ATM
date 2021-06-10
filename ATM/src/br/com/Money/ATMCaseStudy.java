package br.com.Money;

import java.io.FileNotFoundException;

/**
 * ATMCaseStudy.java 
 * Estudo de Caso do ATM pelo DEITEL
 * @author Infnet
 * @version Infnet
 */

public class ATMCaseStudy
{
   /**
    * Método principal para criar e rodar o ATM
    * @param args
    * @throws Exception 
    * @throws FileNotFoundException 
    */
   public static void main( String[] args ) throws FileNotFoundException, Exception
   {
      ATM theATM = new ATM();    
      theATM.run();
   } // end main
} // end class ATMCaseStudy 