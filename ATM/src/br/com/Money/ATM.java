package br.com.Money;

import java.io.FileNotFoundException;
import java.io.IOException;

 /**
  * ATM.java 
  * Representa o ATM
  * @author Deitel
  *
  */

public class ATM 
{
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot; // ATM's deposit slot
   private BankDatabase bankDatabase; // account information database

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   /**
   *  no-argument ATM constructor initializes instance variables
 * @throws Exception 
 * @throws FileNotFoundException 
   */
  public ATM() throws FileNotFoundException, Exception 
  {
     userAuthenticated = false; // user is not authenticated to start
     currentAccountNumber = 0; // no current account number to start
     screen = new Screen(); // create screen
     keypad = new Keypad(); // create keypad 
     cashDispenser = new CashDispenser(); // create cash dispenser
     depositSlot = new DepositSlot(); // create deposit slot
     try{
         bankDatabase = new BankDatabase(); // create acct info database
     }catch (FileNotFoundException x) {
           System.err.format("FileNotFoundException: %s%n", x);
     } catch (IOException ex) {
           System.err.format("IOException: %s%n", ex);
     }   

  } // end no-argument ATM constructor

   /**
    *  Inicialização do ATM 
    */
   public void run()
   {
      // welcome and authenticate user; perform transactions
      while ( true )
      {
         // loop while user is not yet authenticated
         while ( !userAuthenticated ) 
         {
            screen.displayMessageLine( "\nBem vindo ao ATM Infnet!" );       
            authenticateUser(); // authenticate user
         } // end while
         
         performTransactions(); // user is now authenticated 
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session 
         screen.displayMessageLine( "\nObrigado! Volte sempre!" );
      } // end while   
   } // end method run

   /**
    *  Autenticação do Usuário pelo banco de dados
    */
   private void authenticateUser() 
   {
      screen.displayMessage( "\nDigite seu número de conta: " );
      int accountNumber = keypad.getInput(); // input account number
      screen.displayMessage( "\nDigite sua senha: " ); // prompt for PIN
      int pin = keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser( accountNumber, pin );
      
      // check whether authentication succeeded
      if ( userAuthenticated )
      {
         currentAccountNumber = accountNumber; // save user's account #
      } // end if
      else
         screen.displayMessageLine( 
             "Conta ou senha inválida. Tente de novo." );
   } // end method authenticateUser

   /**
    * Mostra o menu principal e executa transações
    */
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY: 
            case WITHDRAWAL: 
            case DEPOSIT:

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction( mainMenuSelection );

               currentTransaction.execute(); // execute transaction
               break; 
            case EXIT: // user chose to terminate session
               screen.displayMessageLine( "\nSaindo do sistema..." );
               userExited = true; // this ATM session should end
               break;
            default: // user did not enter an integer from 1-4
               screen.displayMessageLine( 
                  "\nVocê não selecionou uma opção correta. Tente de novo." );
               break;
         } // end switch
      } // end while
   } // end method performTransactions
   
   /**
    *  Mostra o menu principal
    * @return
    */
   private int displayMainMenu()
   {
      screen.displayMessageLine( "\nMenu:" );
      screen.displayMessageLine( "1 - Saldo da Conta" );
      screen.displayMessageLine( "2 - Saque" );
      screen.displayMessageLine( "3 - Depósito" );
      screen.displayMessageLine( "4 - Sair\n" );
      screen.displayMessage( "Escolha sua opção: " );
      return keypad.getInput(); // return user's selection
   } // end method displayMainMenu
         
   /**
    *  retorna objeto da respectiva transação
    * @param type
    * @return
    */
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry( 
               currentAccountNumber, screen, bankDatabase );
            break;
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( currentAccountNumber, screen, 
               bankDatabase, keypad, cashDispenser );
            break; 
         case DEPOSIT: // create new Deposit transaction
            temp = new Deposit( currentAccountNumber, screen, 
               bankDatabase, keypad, depositSlot );
            break;
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction
} // end class ATM