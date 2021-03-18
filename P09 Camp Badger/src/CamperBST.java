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

import java.util.LinkedList;
import java.util.Iterator;

/** Class to represent a binary search whose nodes are CampTreeNodes.
 * @author ajtepper
 */
public class CamperBST {

  public CampTreeNode root;
  private int size;
  
  /** Constructor initializes empty root node
   */
  public CamperBST() {
    root = new CampTreeNode();
  }
  
  /** Getter for size of the BST
   * @return the current size of the CamperBST
   */
  public int size() {
    return size;
  }
  
  /** Method to determine whether or not the BST is empty
   * @return true if tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return root.getData() == null;
  }

  //starts tree insertion by calling insertHelp() on the root and
  //assigning root to be the subtree returned by that method
  /** Starts tree insertion by calling insertHelp() on the root node
   * and assigning root to be the subtree returned by that method
   * @param the Camper object to insert in the BST
   */
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
    size++;
  }

  /** Recursive helper method to insert.
   * @param current, The "root" of the subtree we are inserting into,
   * ie the node we are currently at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {
    if(current == null || current.getData() == null) {
      current = new CampTreeNode();
      current.setData(newCamper);
      return current;
    }
    int comparison = newCamper.compareTo(current.getData());
    if(comparison > 0) {
      current.setRightNode(insertHelp(current.getRightNode(), newCamper));
    } else if(comparison < 0) {
      current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
    }
    return current;
  }

  /** Deletes a Camper into the binary search tree if it exists.
  * @param key, the camper to be deleted from the tree
  * @throws NoSuchElementException if it is thrown by deleteHelp
  */
  public void delete (Camper key) throws java.util.NoSuchElementException {
    root = deleteHelp(root, key);
    size--;
  }
  
  /** Recursive helper method to delete.
  * @param current, The "root" of the subtree we are deleting from,
  * ie the node we are currently at.
  * @param key, the camper to be deleted from the tree
  * @return the root of the modified subtree we deleted from
  * @throws NoSuchElementException if the camper is not in the tree
  */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    if(current == null || current.getData() == null) {
      return current;
    }
    int comparison = key.compareTo(current.getData());
    if(comparison > 0) {
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    } else if(comparison < 0) {
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));
    } else if(comparison == 0) {
      if(current.getRightNode() == null) {
        System.out.println(current.getData());
        return current.getLeftNode();
      } else if(current.getLeftNode() == null) {
        System.out.println(current.getRightNode());
        return current.getRightNode();
      } else {
        
      }
      CampTreeNode successor = findSuccessor(current.getRightNode());
      current.setData(successor.getData());
      deleteHelp(current, successor.getData());
    }
    return current;
  }
  
  /** Helper method to determine the successor when deleting a node
   * with two children
   * @param the node to find the successor of
   * @return the successor to the given node
   */
  private CampTreeNode findSuccessor(CampTreeNode current) {
    while(current.getLeftNode() != null) {
      current = current.getLeftNode();
    }
    return current.getLeftNode();
  }

  /** Prints the contents of the BST in alphabetical order based
   * on the string "lastName, firstName"
   */
  public void print() {
    printHelp(root);
  }

  /** Recursive helper method to print the BST in alphabetical order
   * @param the current node to print
   */
  private void printHelp(CampTreeNode current){
    if(current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }
  
  //LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;

  /** Takes a designated traversal order and calls upon the helper method
   * to traverse accordingly and add the camper nodes to a linked list
   * @param the order in which to traverse (preorder, postorder, or inorder)
   * @return an iterator of Camper containing a traversed list in the correct order as designated
   */
  public Iterator<Camper> traverse(String order) {
    //first time traversing need to initialize LinkedList
    if(traversedLList==null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      //clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /** Recursive helper method to traverse. Will take the current CampTreeNode's data
   *and add it to traversedLList based on the given order. Then continue to recurse on
   *the correct subtree.
   * @param current, the root of the current subtree we are traversing
   * @param order, the type of traversal to perform
   */
  private void traverseHelp (CampTreeNode current, String order) {
    if(current == null || current.getData() == null) {
      return;
    }
    if(order.equals("PREORDER")) {
      traversedLList.add(current.getData());
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
    } else if(order.equals("POSTORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
      traversedLList.add(current.getData());
    } else if(order.equals("INORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traversedLList.add(current.getData());
      traverseHelp(current.getRightNode(), order);
    }
  }

}
