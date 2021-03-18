//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P10 SJF Process Scheduler
// Files:           WaitingProcessQueue.java, ProcessScheduler.java,
//                      ProcessSchedulerTester.java (tester class),
//                      CustomProcess.java
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
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/** 
 * Class that represents a process in a min-heap priority queue. Each process has
 * an assigned burst time and a unique process ID
 * 
 * @author ajtepper
 * 
 */
public class CustomProcess implements java.lang.Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /** 
   * Constructor sets the burst time and assigns a unique process ID
   * 
   * @throws IllegalArgumentException if given burst time is 0 or a negative number
   * @param burstTime
   * 
   */
  public CustomProcess(int burstTime) {
    if(burstTime <= 0) {
      throw new IllegalArgumentException("Burst time must be positive and non-zero");
    }
    this.burstTime = burstTime;
    PROCESS_ID = nextProcessId;
    nextProcessId++;
  }
  
  /**
  * Returns a String representation of this CustomProcess
  * 
  * @return a string representation of this CustomProcess
  * 
  */
  public String toString() {
  return "p" + this.PROCESS_ID + "(" + this.burstTime + ")";
  }
  
  /**
   * Compares this process to another given process. Returns the difference between their
   * burst times, or if they have the same burst time, the difference between their process
   * IDs
   * 
   * @return the comparison number
   * 
   */
  public int compareTo(CustomProcess other) {
    int comparison = this.burstTime - other.getBurstTime();
    if(comparison == 0) {
      return this.PROCESS_ID - other.getProcessId();
    }
    return comparison;
  }
  
  /**
   * Getter method for the unique process id
   * 
   * @return the process id
   * 
   */
  public int getProcessId() {
    return PROCESS_ID;
  }
  
  /** 
   * Getter method for the burst time
   * 
   * @return burst time
   * 
   */
  public int getBurstTime() {
    return burstTime;
  }
  
}
