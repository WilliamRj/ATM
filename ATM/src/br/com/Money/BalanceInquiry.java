package br.com.Money;

/**
 * 
 * BalanceInquiry.java
 * Representa a consulta de saldo
 * @author Tomas
 *
 */
public class BalanceInquiry extends Transaction
{
/**
 * Construtor
 * @param userAccountNumber
 * @param atmScreen
 * @param atmBankDatabase
 */
public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
   BankDatabase atmBankDatabase )
{
   super( userAccountNumber, atmScreen, atmBankDatabase );
} // end BalanceInquiry constructor

/**
 * Transação
 */
@Override
public void execute()
{
   // get references to bank database and screen
   BankDatabase bankDatabase = getBankDatabase();
   Screen screen = getScreen();

   // get the available balance for the account involved
   double availableBalance = 
      bankDatabase.getAvailableBalance( getAccountNumber() );

   // get the total balance for the account involved
   double totalBalance = 
      bankDatabase.getTotalBalance( getAccountNumber() );
   
   // display the balance information on the screen
   screen.displayMessageLine( "\nInformações da conta:" );
   screen.displayMessage( " - Saldo disponível: " ); 
   screen.displayDollarAmount( availableBalance );
   screen.displayMessage( "\n - Saldo Total:     " );
   screen.displayDollarAmount( totalBalance );
   screen.displayMessageLine( "" );
} // end method execute
} // end class BalanceInquiry