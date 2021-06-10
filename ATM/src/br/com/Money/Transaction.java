package br.com.Money;

/**
 *Transaction.java
 *SuperClasse abstrata Transação que representa uma transação do ATM
 * @author Infnet
 * @version Infnet
 */
public abstract class Transaction
{
private int accountNumber; // indicates account involved
private Screen screen; // ATM's screen
private BankDatabase bankDatabase; // account info database
/**
 * Transação constructor invocado pela subclasse usando super()
 * @param userAccountNumber
 * @param atmScreen
 * @param atmBankDatabase
 */

public Transaction( int userAccountNumber, Screen atmScreen, 
   BankDatabase atmBankDatabase )
{
   accountNumber = userAccountNumber;
   screen = atmScreen;
   bankDatabase = atmBankDatabase;
} // end Transaction constructor
/**
 * return account number
 * @return
 */
 
public int getAccountNumber()
{
   return accountNumber; 
} // end method getAccountNumber

/**
 * return reference to screen
 * @return
 */

public Screen getScreen()
{
   return screen;
} // end method getScreen

/**
 * return reference to bank database
 * @return
 */
public BankDatabase getBankDatabase()
{
   return bankDatabase;
} // end method getBankDatabase

/**
 * // perform the transaction (overridden by each subclass)
 */
abstract public void execute();
} // end class Transaction