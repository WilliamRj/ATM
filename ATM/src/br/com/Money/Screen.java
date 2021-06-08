package br.com.Money;

/**
 * Screen.java
 *Representa tela do ATM
 */

public class Screen
{
/**
 *  displays a message without a carriage return
 * @param message
 */
public void displayMessage( String message ) 
{
   System.out.print( message ); 
} // end method displayMessage

/**
 *  display a message with a carriage return
 * @param message
 */
public void displayMessageLine( String message ) 
{
   System.out.println( message );   
} // end method displayMessageLine

/**
 * display a dollar amount
 * @param amount
 */
public void displayDollarAmount( double amount )
{
   System.out.printf( "$%,.2f", amount );   
} // end method displayDollarAmount 
} // end class Screen