package base;
/**
 * @author samuelhete
 *
 */
public class InsufficientFundsException extends Exception {
	private double amount;
	   /**
	    * Create instance of InsufficientFundsException class,
	    * this is thrown to the caller
	    * @param amount
	    */
	   public InsufficientFundsException(double amount)
	   {
	      this.amount = amount;
	   } 
	   /**
	    * @return amount
	    */
	   public double getAmount()
	   {
	      return amount;
	   }
}

