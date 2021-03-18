//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P09 Camp Badger
// Files:           Camper.java, CampTreeNode.java, CamperBST.java,
//                    CampManager.java, CampEnrollmentApp.java
// Course:          CS300, Fall Semester, 2019
//
// Author:          Aiden Tepper
// Email:           ajtepper@wisc.edu
// Lecturer's Name: Prof. Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Alexander Shwe
// Partner Email:   shwe@wisc.edu
// Partner Lecturer's Name: Prof. Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
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
// Online Sources:  https://en.wikipedia.org/wiki/Zeller%27s_congruence#Implementation_in_software
//                  Studied and used algorithm found on this site in the getFirstDayOfWeekInMonth
//                  method.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** Class that contains main method and performs enrolling/unenrolling/traversal operations 
 * @author ajtepper
 */
public class CampEnrollmentApp {
  
  /** Main method, reads list of commands from a given .txt file and performs those actions
   * @param args
   */
  public static void main(String[] args) {
    
    try {
      CampManager manager = new CampManager();
      List <String> fileLines = Files.readAllLines(Paths.get("C:\\Users\\Aiden Tepper\\OneDrive - "
          + "UW-Madison\\Documents\\eclipse-workspace\\P09 Camp Badger\\src\\sim.txt"));
      for(String line : fileLines) {
        String[] command = line.split(" ");
        if(command[0].equals("E")) {
          manager.enrollCamper(new Camper(command[2], command[1], Integer.parseInt(command[3])));
          System.out.println("Enrollment of " + command[2] + " " + command[1] + " successful!");
        } else if(command[0].equals("R")) {
          manager.unenrollCamper(new Camper(command[2], command[1], 12));
          System.out.println("Unenrollment of " + command[2] + " " + command[1] + " successful!");
        } else if(command[0].equals("T")) {
          System.out.println("--- " + command[1] + " Traversal ---");
          java.util.Iterator<Camper> traversed = manager.traverse(command[1]);
          while (traversed.hasNext()) {
            System.out.println(traversed.next());
          }
          System.out.println("---------------------------");
        } else if(command[0].equals("S")) {
          System.out.println("--- Camp Statistics ---");
          manager.printStatistics();
          System.out.println("-----------------------");
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }
    
  }

}
