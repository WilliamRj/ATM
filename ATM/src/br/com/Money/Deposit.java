package br.com.Money;

/**
 * Deposit.java 
 * 
 * Representa o depósito
 * 
 * @author Deitel
 * 
 */
public class Deposit extends Transaction {

	private double amount; // amount to deposit
	private Keypad keypad; // reference to keypad
	private DepositSlot depositSlot; // reference to deposit slot
	private final static int CANCELED = 0; // constant for cancel option

	/**
	 * Depósito constructor
	 * 
	 * @param userAccountNumber
	 * @param atmScreen
	 * @param atmBankDatabase
	 * @param atmKeypad
	 * @param atmDepositSlot
	 */
	public Deposit(int userAccountNumber, Screen atmScreen,
			BankDatabase atmBankDatabase, Keypad atmKeypad,
			DepositSlot atmDepositSlot) {
		// initialize superclass variables
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// initialize references to keypad and deposit slot
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	} // end Deposit constructor

	/**
	 * Transação
	 */
	@Override
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase(); // get reference
		Screen screen = getScreen(); // get reference

		amount = promptForDepositAmount(); // get deposit amount from user

		// check whether user entered a deposit amount or canceled
		if (amount != CANCELED) {
			// request deposit envelope containing specified amount
			screen.displayMessage("\nInsira o valor contido no envelope ");
			screen.displayDollarAmount(amount);
			screen.displayMessageLine(".");

			// receive deposit envelope
			boolean envelopeReceived = depositSlot.isEnvelopeReceived();

			// check whether deposit envelope was received
			if (envelopeReceived) {
				screen.displayMessageLine("\nSeu envelope foi "
						+ "entregue.\nNOTA: O dinheiro depositado não "
						+ "estará disponível antes de verificarmos o valor do depósito "
						+ "contido no envelope.");

				// credit account to reflect the deposit
				bankDatabase.credit(getAccountNumber(), amount);
			} // end if
			else // deposit envelope not received
			{
				screen.displayMessageLine("\nVocê nao inseriu nenhum "
						+ "envelope, então o ATM cancelou sua transação.");
			} // end else
		} // end if
		else // user canceled instead of entering amount
		{
			screen.displayMessageLine("\nCancelando transação...");
		} // end else
	} // end method execute

	/**
	 * Tela para mostrar o valor a ser depositado em centavos
	 * 
	 * @return
	 */
	private double promptForDepositAmount() {
		Screen screen = getScreen(); // get reference to screen

		// display the prompt
		screen.displayMessage("\nInsira o valor a ser depositado em "
				+ "centavos (ou 0 para cancelar): ");
		int input = keypad.getInput(); // receive input of deposit amount

		// check whether the user canceled or entered a valid amount
		if (input == CANCELED)
			return CANCELED;
		else {
			return (double) input / 100; // return dollar amount
		} // end else
	} // end method promptForDepositAmount
} // end class Deposit