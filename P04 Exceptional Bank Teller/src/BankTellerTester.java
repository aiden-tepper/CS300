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

import java.io.File;

public class BankTellerTester {

  /**
   * Calls the test methods defined in this BankTellerTester class.
   * @param args - input arguments
   */
  public static void main(String[] args) {
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println(testBankTellerConstructor());
    System.out.println(testBankTellerLoadTransactionsFileNotFound());
  }
  
  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    try {
      BankTeller test = new BankTeller();
      BankAccount testAccount = new BankAccount("aa", 10);
      BankAccount testAccount2 = new BankAccount("aa", 100);
      test.addBankAccount(testAccount);
      test.addBankAccount(testAccount2);
    } catch(IllegalStateException e) {
      return true;
    }
    return false;
  }
  
  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerConstructor() {
    BankTeller test = new BankTeller();
    if(test.getAccountsCount() != 0) {
      return false;
    }
    return true;
  }
  
  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File
   * parameter throws a FileNotFoundException, when it is passed a File object that does not
   * correspond to an actual file within the file system, and a non null reference of type
   * BankAccount.
   * @returns true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    try {
      BankTeller test = new BankTeller();
      BankAccount testAccount = new BankAccount("bb", 50);
      File file = new File("\file.txt");
      test.loadTransactions(file, testAccount);
    } catch(java.io.FileNotFoundException e) {
      return true;
    }
    return false;
  }
  
}
