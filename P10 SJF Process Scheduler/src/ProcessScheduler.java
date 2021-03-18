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

import java.util.Scanner;

/**
 * Class that takes input from the console and executes those actions on a WaitingProcessQueue
 * 
 * @author Aiden Tepper
 *
 */
public class ProcessScheduler {

  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit’s queue
  
  /**
   * Constructor initializes the queue and sets both currentTime and numProcessesRun to zero
   * 
   */
  public ProcessScheduler() {
    queue = new WaitingProcessQueue();
    currentTime = 0;
    numProcessesRun = 0;
  }
  
  /**
   * Main method runs the driver application and waits for user input
   * 
   * @param args
   * 
   */
  public static void main (String[] args) {
    Scanner scnr = new Scanner(System.in);
    ProcessScheduler scheduler = new ProcessScheduler();
    System.out.println("========== Welcome to the SJF Process Scheduler App ========\n");
    while(true) {
      scheduler.printInstructions();
      String input = scnr.nextLine();
      if(input.equals("q") || input.equals("quit")) {
        System.out.println(scheduler.numProcessesRun + " processes run in "
            + scheduler.currentTime + " units of time!");
        System.out.println("Thank you for using our scheduler!");
        System.out.println("Goodbye!");
        break;
      }
      scheduler.execute(input, scheduler);
      System.out.println("");
    }
  }

  /**
   * Inserts the given process in the WaitingProcessQueue queue
   * 
   * @param process to insert
   * 
   */
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
  }
  
  /**
   * Runs the ready processes already scheduled in this processScheduler’s queue
   * 
   * @return the log of the executions
   */
  public String run() {
    String log = "";
    if(queue.size() == 1) {
      log += "Starting 1 process\n\n";
    } else if(queue.size() > 1) {
      log += "Starting " + queue.size() + " processes\n\n";
    }
    int id;
    int burstTime;
    for(int i = 0; i <= queue.size(); i++) {
      id = queue.peekBest().getProcessId();
      burstTime = queue.peekBest().getBurstTime();
      log += "Time " + currentTime + " : Process ID " + id + " Starting.\n";
      queue.removeBest();
      currentTime += burstTime;
      log += "Time " + currentTime + ": Process ID " + id + " Completed.\n";
      numProcessesRun++;
    }
    log += "\nTime " + currentTime + ": All scheduled processes completed.";
    return log;
  }
  
  /**
   * Private helper method to print the instructions from the driver application. Called after each
   * command is executed
   * 
   */
  private static void printInstructions() {
    System.out.println("Enter command:");
    System.out.println("[schedule <burstTime>] or [s <burstTime>]");
    System.out.println("[run] or [r]");
    System.out.println("[quit] or [q]\n");
  }
  
  /**
   * Private method that takes a command in the form of a string and calls the appropriate methods
   * 
   * @param command to execute
   * @param scheduler object to use for executions
   */
  private static void execute(String command, ProcessScheduler scheduler) {
    try {
      if(command.equals("r") || command.equals("run")) {
        System.out.println(scheduler.run());
      } else if(command.substring(0, 1).equals("s") || command.substring(0, 8).equals("schedule")) {
        int burstTime = Integer.parseInt(command.split(" ")[1]);
        if(burstTime <= 0) {
          throw new java.lang.NumberFormatException();
        }
        CustomProcess process = new CustomProcess(burstTime);
        scheduler.scheduleProcess(process);
        System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
            + burstTime);
      } else {
        System.out.println("WARNING: Please enter a valid command!");
      }
    } catch(java.lang.StringIndexOutOfBoundsException e) {
      System.out.println("WARNING: Please enter a valid command!");
    } catch(java.lang.NumberFormatException e) {
      System.out.println("WARNING: burst time MUST be an integer!");
    } catch(IllegalArgumentException e) {
      System.out.println(e);
    }
  }
  
}
