package br.com.Money;
/**
 *  CashDispenser.java
 *  Representa simula??o das Notas do Saque
 * @author Infnet
 * @version Infnet
 */
public class CashDispenser 
{
   /**
    * N?mero padr?o inicial de notas
    * 
    */
   private final static int INITIAL_COUNT = 500;
   private int count; // number of $20 bills remaining
   
   /**
    * no-argument CashDispenser constructor initializes count to default
    */
   public CashDispenser()
   {
      count = INITIAL_COUNT; // set count attribute to default
   } // end CashDispenser constructor

   /**
    * simulates dispensing of specified amount of cash
    * @param amount
    */
   public void dispenseCash( int amount )
   {
      int billsRequired = amount / 20; // number of $20 bills required
      count -= billsRequired; // update the count of bills
   } // end method dispenseCash

   /**
    * Indicar se o ATM pode realizar o saque da quantidade requisitada
    * @param amount
    * @return
    */
   public boolean isSufficientCashAvailable( int amount )
   {
      int billsRequired = amount / 20; // number of $20 bills required

      if ( count >= billsRequired  )
         return true; // enough bills available
      else 
         return false; // not enough bills available
   } // end method isSufficientCashAvailable
} // end class CashDispenser