package base;
/**
 * @author samuelhete
 *
 */
import java.util.*;
import base.InsufficientFundsException;
public class Account {
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated;
	
	/**
	 * no arg constructor for Account
	 */
	public Account() {
		super();
	}
	/**
	 * @param id
	 * @param balance
	 * @param annualInterestRate
	 * @param dateCreated
	 * not necessarily needed in this class but needed for instantiation in accountTest
	 */
	public Account(int id, double balance, double annualInterestRate, Date dateCreated){
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}
	
	/**
	 * @param id
	 * @param balance
	 * constructor for account that creates the account
	 * w/ specified params
	 */
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param annualInterestRate
	 * @return the monthly interest rate
	 */
	
	public double getMonthlyInterestRate(double annualInterestRate){
		return annualInterestRate / 12;
	}
	/**
	 * @param specAmount
	 * @return balance - specAmount (amount withdrawn)
	 * @throws InsufficientFundsException -- this occurs if withdraw is greater than account balance 
	 */
	public double withdraw(double specWithdraw) throws InsufficientFundsException{
		if (specWithdraw <= balance){
			balance = balance - specWithdraw;
		}
		else {
			double overdraft = specWithdraw - balance;
			throw new InsufficientFundsException(overdraft);
		}
		return balance;
	}
	/**
	 * @param specDeposit
	 * @return balance + specified deposit
	 */
	double deposit(double specDeposit){
		balance = balance + specDeposit;
		return balance;
	}
}
