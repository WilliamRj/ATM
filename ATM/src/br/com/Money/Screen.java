package br.com.Money;

/**
 * Screen.java
 *Representa tela do ATM
 * @author Infnet
 * @version Infnet
 */

public class Screen
{
/**
 *  exibir uma mensagem com um retorno
 * @param message
 */
public void displayMessage( String message ) 
{
   System.out.print( message ); 
} // end method displayMessage

/**
 *  exibir uma mensagem com um retorno
 * @param message
 */
public void displayMessageLine( String message ) 
{
   System.out.println( message );   
} // end method displayMessageLine

/**
 * exibe a quantia em dollar
 * @param amount
 */
public void displayDollarAmount( double amount )
{
   System.out.printf( "$%,.2f", amount );   
} // end method displayDollarAmount 
} // end class Screen