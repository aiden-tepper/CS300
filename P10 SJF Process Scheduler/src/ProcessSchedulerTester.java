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
 * Tester class for both the WaitingProcessQueue and ProcessScheduler classes
 * 
 * @author ajtepper
 *
 */
public class ProcessSchedulerTester {

  /**
   * Main method, runs all the test methods
   * 
   * @param args
   * 
   */
  public static void main(String[] args) {
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
    System.out.println(testPeekBestWaitingProcessQueue());
    System.out.println(testProcessScheduler());
  }

  /**
   * Checks the correctness of the insert operation implemented in the WaitingProcessQueue class
   * 
   * @return true if correct
   * 
   */
  public static boolean testInsertWaitingProcessQueue(){
    WaitingProcessQueue queue = new WaitingProcessQueue();
    queue.insert(new CustomProcess(5));
    queue.insert(new CustomProcess(6));
    queue.insert(new CustomProcess(4));
    return(queue.toString().equals("p3(4) p2(6) p1(5) "));
  }
  
  /**
   * Checks the correctness of the removeBest operation implemented in the WaitingProcessQueue class
   * 
   * @return true if correct
   * 
   */
  public static boolean testRemoveBestWaitingProcessQueue(){
    WaitingProcessQueue queue = new WaitingProcessQueue();
    queue.insert(new CustomProcess(5));
    queue.insert(new CustomProcess(6));
    queue.insert(new CustomProcess(4));
    queue.insert(new CustomProcess(20));
    queue.insert(new CustomProcess(1));
    queue.insert(new CustomProcess(8));
    queue.removeBest();
    return(queue.toString().equals("p6(4) p5(6) p4(5) p7(20) p9(8) "));
  }

  /**
   * Checks the correctness of the peekBest operation implemented in the WaitingProcessQueue class
   * 
   * @return true if correct
   * 
   */
  public static boolean testPeekBestWaitingProcessQueue() {
    WaitingProcessQueue queue = new WaitingProcessQueue();
    queue.insert(new CustomProcess(5));
    queue.insert(new CustomProcess(6));
    queue.insert(new CustomProcess(4));
    queue.insert(new CustomProcess(20));
    queue.insert(new CustomProcess(1));
    queue.insert(new CustomProcess(8));
    return(queue.peekBest().toString().equals("p14(1)"));
  }
  
  /**
   * Checks the correctness of both the scheduleProcess and run operations implemented in the
   * ProcessScheduler class
   * 
   * @return true if correct
   * 
   */
  public static boolean testProcessScheduler() {
    ProcessScheduler scheduler = new ProcessScheduler();
    scheduler.scheduleProcess(new CustomProcess(5));
    scheduler.scheduleProcess(new CustomProcess(8));
    String expectedLog = "Starting 2 processes\n" + 
        "\n" + 
        "Time 0 : Process ID 16 Starting.\n" + 
        "Time 5: Process ID 16 Completed.\n" + 
        "Time 5 : Process ID 17 Starting.\n" + 
        "Time 13: Process ID 17 Completed.\n" + 
        "\n" + 
        "Time 13: All scheduled processes completed.";
    return(scheduler.run().equals(expectedLog));
  }

}
