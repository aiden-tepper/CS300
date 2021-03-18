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

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class BankTeller {
  
  private ArrayList<BankAccount> accounts;
  
  /**
   * Creates a new BankTeller object with an empty list of accounts.
   */
  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }
  
  /**
   * Adds newAccount to the list of accounts of this BankTeller.
   * @param newAccount - a new account to add
   * @throws java.lang.IllegalStateException - with a descriptive error message if the accountID
   * of newAccount is used by another account already added to the list of accounts
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if newAccount
   * is null
   */
  void addBankAccount(BankAccount newAccount) {
    if(newAccount == null) {
      throw new IllegalArgumentException("The new account is null.");
    }
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).equals(newAccount)) {
        throw new IllegalStateException("The new account's ID is in use by a preexisting account.");
      }
    }
    accounts.add(newAccount);   
  }
  
  /**
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance.
   * @param transaction - to add
   * @param account - bank account
   * @throws java.util.zip.DataFormatException - if the format of the transaction is not correct
   * @throws java.lang.NullPointerException - if account is null
   */
  void addTransaction(String transaction, BankAccount account)
      throws java.util.zip.DataFormatException {
    if(account == null) {
      throw new NullPointerException("The account is null");
    }
    if(transaction.substring(0, 1).equals("1")) {
      int amount = Integer.parseInt(transaction.substring(2, transaction.length()));
      account.deposit(amount);
    } else if(transaction.substring(0, 1).equals("0")) {
      int amount = Integer.parseInt(transaction.substring(2, transaction.length()));
      account.withdraw(amount);
    } else {
      throw new java.util.zip.DataFormatException("Invalid transaction format.");
    }
  }
  
  /**
   * Returns the bank account that has exactly the provided identifier. Case sensitive comparison
   * must be considered.
   * @param id - a string that represents an identifier of a bank account
   * @return a reference to the bank account whose account identifier has an exact match with
   * the provided string
   * @throws java.util.NoSuchElementException - with a descriptive error message if no account in
   * this bankTeller's accounts list has the provided id
   */
  BankAccount findAccount(String id) throws java.util.NoSuchElementException {
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).getID().equals(id)) {
        return accounts.get(i);
      }
    }
    throw new java.util.NoSuchElementException("No matching account was found.");
  }
  
  /**
   * Returns the total number of accounts created so far (i.e., the size of the Arraylist of
   * accounts.
   * @return the total number of accounts added to this BankTeller
   */
  int getAccountsCount() {
    return accounts.size();
  }
  
  /**
   * Loads a set of transactions from a provided file object. Each transaction is in a separate
   * line. Each transaction line should contain two items: the transaction code "0" or "1"
   * followed by the transaction amount, separated by spaces. Extra spaces at the beginning and
   * at the end of a transaction line should be ignored. Not correctly formatted lines must be
   * skipped. Valid transactions must change the balance of the bank account. If java.util.Scanner
   * object is used to read from the file object, make sure to close the scanner object whenever
   * a FileNotFoundException was thrown or not.
   * @param account - a reference to a BankAccount object
   * @param file - a java.io.File object referring to a file that contains a set of transactions,
   * each in one line
   * @throws java.lang.NullPointerException - if account is null
   * @throws java.io.FileNotFoundException - if the file object does not correspond to an actual
   * file within the file system.
   */
  void loadTransactions(File file, BankAccount account) throws java.io.FileNotFoundException {
    if(account == null) {
      throw new NullPointerException("The account is null.");
    }
    if(!file.exists()) {
      throw new java.io.FileNotFoundException("The file object does not exist.");
    }
    Scanner scnr = new Scanner(file);
    String[] splitString = new String[2];
    while(scnr.hasNextLine()) {
      splitString = scnr.nextLine().trim().split(" ");
      if(splitString[0].equals("1")) {
        account.deposit(Integer.parseInt(splitString[1]));
      } else if(splitString[0].equals("0")) {
        try {
          account.withdraw(Integer.parseInt(splitString[1]));
        } catch(Exception e) {
          System.out.println(e);
        }
      }
    }
  }

}
