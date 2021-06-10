package br.com.Money;

/**
 * Account.java
 * Representa a conta do banco
 * @author Infnet
 * @version Infnet
 */


public class Account 
{

private int accountNumber; // N�mero da conta
private int pin; // Senha para autentica��o
private double availableBalance; // Saldo dispon�vel para saque
private double totalBalance; // Saldo Total

/**
 * Inicializa��o de atributos do construtor Conta
 * @param theAccountNumber
 * @param thePIN
 * @param theAvailableBalance
 * @param theTotalBalance
 */
public Account( int theAccountNumber, int thePIN, 
   double theAvailableBalance, double theTotalBalance )
{
   accountNumber = theAccountNumber;
   pin = thePIN;
   availableBalance = theAvailableBalance;
   totalBalance = theTotalBalance;
} // fim do Construtor Conta

/**
 * Autentica��o de senha
 * @param userPIN
 * @return true or false
 */
public boolean validatePIN( int userPIN )
{
   if ( userPIN == pin )
      return true;
   else
      return false;
} // Fim do m�todo Autentica��o de senha

/**
 *  retorna saldo dispon�vel
 * @return
 */
public double getAvailableBalance()
{
   return availableBalance;
} // end getAvailableBalance

/**
 *  retorna saldo total
 * @return
 */
public double getTotalBalance()
{
   return totalBalance;
} // end method getTotalBalance

/**
 *  Cr�dito para conta
 * @param amount
 */
public void credit( double amount )
{
   totalBalance += amount; // add to total balance
} // end method credit

/**
 *  D�bito para conta
 * @param amount
 */
public void debit( double amount )
{
   availableBalance -= amount; // subtract from available balance
   totalBalance -= amount; // subtract from total balance
} // end method debit

/**
 *  retorna n�mero da conta
 * @return
 */
public int getAccountNumber()
{
   return accountNumber;  
} // end method getAccountNumber
} // end class Account