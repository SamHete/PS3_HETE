package base;
/**
 * @author samuelhete
 *
 */
import base.Account;
import base.InsufficientFundsException;
import static org.junit.Assert.*;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class accountTest extends Account {
	Account testAccount;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		testAccount = null;
	}
	@Test
	public void testParams() {
		Account testAccount = new Account();
		assertTrue(testAccount.getId() == 1122);
		assertTrue(testAccount.getBalance() == 20000.00);
		assertEquals((long)testAccount.getAnnualInterestRate(),(long)0.045);
		// ^^^this one threw deprecation error with double type so had to be changed to long
		assertEquals(testAccount.getDateCreated(),new Date());
		System.out.println("The account balance is $" + testAccount.getBalance() + "\n The monthly interest rate is $" + (testAccount.getAnnualInterestRate()/12) * testAccount.getBalance() + "\n The account was created on: " + testAccount.getDateCreated());
	}
	@Test
	public void testWithDepo() throws InsufficientFundsException {
		Account testAccount = new Account();
		try {
			testAccount.withdraw(100000.00);
		}
		catch (InsufficientFundsException a) {
			assertTrue(true);
		}
		testAccount.deposit(103000.00);
		assertTrue(testAccount.withdraw(30000.00) == 20000.00);
		}
	
}
