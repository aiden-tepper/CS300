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

/** Camp manager class that contains an instance of the campers BST and has the 
 * ability to enroll/unenroll campers, traverse the campers list, and print the
 * number of campers enrolled
 * @author ajtepper
 */
public class CampManager {

  private CamperBST campers;
  private final static String [] CABIN_NAMES = new String[]{
  "Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};
  
  /** Constructor initializes empty campers binary search tree
   */
  public CampManager() {
    campers = new CamperBST();
  }
  
  /** Prints the number of campers currently enrolled
   */
  public void printStatistics() {
    System.out.println("Number of campers: " + campers.size());
  }
  
  /** Assigns a given camper to their cabin based on their age and enrolls them
   * in the camp
   * @param camper to enroll
   */
  public void enrollCamper(Camper newCamper) {
    int age = newCamper.getAge();
    if(age == 8 || age == 9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    } else if(age >= 10 && age <= 12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    } else if(age == 13 || age == 14) {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }
    campers.insert(newCamper);
  }
  
  /** Unenrolls a given camper from the camp
   * @param camper to unenroll
   * @throws NoSuchElementException if the given camper is not enrolled to begin with
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {
    campers.delete(delCamper);
  }
  
  /** Calls upon the traverse method to traverse through the campers BST in the given order
   * @param order of traversal (preorder, postorder, or inorder)
   * @return an iterator of type camper that contains a linked list of the campers
   * ordered accordingly
   */
  public java.util.Iterator<Camper> traverse(java.lang.String order) {
    return campers.traverse(order);
  }
  
}
