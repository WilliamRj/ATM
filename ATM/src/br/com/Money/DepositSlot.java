package br.com.Money;

/**
 * DepositSlot.java
 * Representa uma simulação de depósito
 */


public class DepositSlot 
{
   /**
	 * indicates whether envelope was received (always returns true, 
     * because this is only a software simulation of a real deposit slot)
	 * @return true
	 */
   public boolean isEnvelopeReceived()
   {
      return true; // deposit envelope was received
   } // end method isEnvelopeReceived
} // end class DepositSlot