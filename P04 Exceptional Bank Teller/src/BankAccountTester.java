//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exceptional Bank Teller Project
// Files:           BankAccount.java, BankTeller.java,
//                  BankAccountTester.java (tester class),
//                  BankTellerTester.java (tester class)
// Course:          CS300, Fall Semester, 2019
//
// Author:          Aiden Tepper
// Email:           ajtepper@wisc.edu
// Lecturer's Name: Prof. Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         none
// Online Sources:  none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class BankAccountTester {

  /**
   * The main method calls the different test methods.
   * @param args - input arguments
   */
  public static void main(String[] args) {
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountDepositNegativeAmount());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println(testBankAccountWithdrawValidAmount());
  }
  
  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException
   * when it is passed a balance smaller than 10.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount test = new BankAccount("123", 5);
    } catch(IllegalArgumentException e) {
      return true;
    }
    return false;
  }
  
  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (greater of equal to 10). Checks whether the new account is
   * created with the provided account id and balance. It checks also that the list of transactions
   * of the created account contains only one transaction /"1 " + the initial balance/
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    BankAccount test = new BankAccount("234", 100);
    if(!test.getID().contentEquals("234")) {
      return false;
    }
    if(test.getBalance() != 100) {
      return false;
    }
    if(!test.getMostRecentTransactions()[0].equals("1 100")) {
      return false;
    }
    if(test.getMostRecentTransactions()[1] != null) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the
   * method call returns.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount test = new BankAccount("id", 100);
    try {
      test.deposit(-10);
    } catch(IllegalArgumentException e) {
      if(test.getBalance() == 100) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier (case sensitive comparison); and it returns
   * false otherwise.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountEquals() {
    BankAccount test1 = new BankAccount("id", 50);
    BankAccount test2 = new BankAccount("id", 100);
    if(!test1.equals(test2)) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after
   * the withdraw() method returns.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount test = new BankAccount("bankID", 500);
    int exceptionCounter = 0;
    try {
      test.withdraw(-10);
    } catch(java.util.zip.DataFormatException e) {
      exceptionCounter++;
    }
    try {
      test.withdraw(55);
    } catch(java.util.zip.DataFormatException e) {
      exceptionCounter++;
    }
    if(exceptionCounter != 2 || test.getBalance() != 500) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    BankAccount test = new BankAccount("asdf", 100);
    try {
      test.withdraw(500);
    } catch(IllegalStateException e) {
      if(test.getBalance() == 100) {
        return true;
      }
    } catch(Exception e) {
    }
    return false;
  }
  
  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed
   * a positive number smaller than the account's balance. The withdrawal amount should be
   * subtracted from the balance after the withdraw() method call returns.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawValidAmount() {
    try {
      BankAccount test = new BankAccount("1111", 100);
      test.withdraw(50);
      if(test.getBalance() == 50) {
        return true;
      }
    } catch(Exception e) {
      return false;
    }
    return false;
  }
}
