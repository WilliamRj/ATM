package br.com.Money;

/**
 * Account.java
 * Representa a conta do banco
 * @author Infnet
 * @version Infnet
 */


public class Account 
{

private int accountNumber; // Número da conta
private int pin; // Senha para autenticação
private double availableBalance; // Saldo disponível para saque
private double totalBalance; // Saldo Total

/**
 * Inicialização de atributos do construtor Conta
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
 * Autenticação de senha
 * @param userPIN
 * @return true or false
 */
public boolean validatePIN( int userPIN )
{
   if ( userPIN == pin )
      return true;
   else
      return false;
} // Fim do método Autenticação de senha

/**
 *  retorna saldo disponível
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
 *  Crédito para conta
 * @param amount
 */
public void credit( double amount )
{
   totalBalance += amount; // add to total balance
} // end method credit

/**
 *  Débito para conta
 * @param amount
 */
public void debit( double amount )
{
   availableBalance -= amount; // subtract from available balance
   totalBalance -= amount; // subtract from total balance
} // end method debit

/**
 *  retorna número da conta
 * @return
 */
public int getAccountNumber()
{
   return accountNumber;  
} // end method getAccountNumber
} // end class Account