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

public class BankAccount {
  
  private String accountID;
  private int balance;
  private ArrayList<String> transactions;
  
  /**
   * Creates a new bank account with a given account identifier and an initial balance. A deposit
   * transaction /"1 " + initialBalance/ must be added to this account's list of transactions
   * @param accountID - this account's unique identifier
   * @param initialBalance - this account's initial balance
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if initBalance
   * is less than 10
   */
  public BankAccount(String accountID, int initialBalance) {
    if(initialBalance < 10) {
      throw new IllegalArgumentException("Initial balance cannot be less than 10.");
    }
    this.accountID = accountID;
    this.balance = initialBalance;
    transactions = new ArrayList<String>();
    transactions.add("1 " + initialBalance);
  }
  
  /**
   * This method deposits an amount to this bank account. It also adds the transaction 
   * /"1 " + depositAmount/ to this account list of transactions and updates this bank account's 
   * balance.
   * @param depositAmount - the amount of money to deposit to this bank account
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if depositAmount
   * is negative
   */
  void deposit(int depositAmount) {
    if(depositAmount < 0) {
      throw new IllegalArgumentException("Deposit amount cannot be negative.");
    }
    balance += depositAmount;
    transactions.add("1 " + depositAmount);
  }
  
  /**
   * Checks if an other bank account is equal to this one.
   * @param other - another BankAccount object
   * @returns true if this bankAccount's identifier equals the other bankAccount's identifier.
   * The comparison is case sensitive 
   */
  boolean equals(BankAccount other) {
    if(other.getID().equals(accountID)) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Gets the current balance of this bank account.
   * @return the current balance of this bank account
   */
  int getBalance() {
    return balance;
  }
  
  /**
   * Gets the unique identifier of this account.
   * @return the unique identifier of this account
   */
  String getID() {
    return accountID;
  }
  
  /**
   * Gets the most recent FIVE transactions in an array of length 5. This array may contain null
   * references if the total number of transactions is less than 5. If getTransactionsCount() is
   * less than 5, these transactions should be stored at the range of indices 0 ..
   * getTransactionsCount()-1. For instance, if the total number of transactions is 0, this array
   * will contain five null references. If the total number of transactions is 1, it will contain
   * the transaction at index 0, followed by 4 null references, and so on.
   * @return the most recent transactions in an array that may contain up to 5 string references
   */
  String[] getMostRecentTransactions() {
    int size = getTransactionsCount();
    String[] recentTransactions = new String[5];
    if(size < 5) {
      for(int i = 0; i < size; i++) {
        recentTransactions[size-1-i] = transactions.get(i);
      }
    } else {
      for (int i = 0; i < 5; i++) {
        recentTransactions[4-i] = transactions.get(i+(size-5));
      }
    }
    return recentTransactions;
  }
  
  /**
   * Gets the total number of transactions performed on this bank account, meaning the size of the
   * ArrayList of transactions of this bank account
   * @return the total number of transactions performed on this account
   */
  int getTransactionsCount() {
    return transactions.size();
  }
  
  /**
   * This method withdraws a specific amount of money. It also adds the transaction
   * /"0 " + withdrawalAmount/ to this accunt's list of transactions and updates this bank
   * account's balance.
   * @param withdrawAmount - the amount of money to withdraw from this bank account
   * @throws java.util.zip.DataFormatException - with a descriptive error message if
   * withdrawalAmount is negative or is not a multiple of 10
   * @throws java.lang.IllegalStateException - if the withdrawalAmount is larger than this bank
   * account's balance
   */
  void withdraw(int withdrawAmount) throws java.util.zip.DataFormatException {
    if(withdrawAmount < 0) {
      throw new java.util.zip.DataFormatException("Withdraw amount cannot be negative.");
    }
    if(withdrawAmount % 10 != 0) {
      throw new java.util.zip.DataFormatException("Withdraw amount must be a multiple of 10.");
    }
    if(withdrawAmount > balance) {
      throw new IllegalStateException("Withdraw amount cannot be greater than current balance");
    }
    balance -= withdrawAmount;
    transactions.add("0 " + withdrawAmount);
  }

}
