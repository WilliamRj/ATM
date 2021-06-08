package br.com.Money;

import java.io.FileNotFoundException;

/**
 * ATMCaseStudy.java 
 * Driver program for the ATM case study
 * @author Deitel
 *
 */

public class ATMCaseStudy
{
   /**
    * main method creates and runs the ATM
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