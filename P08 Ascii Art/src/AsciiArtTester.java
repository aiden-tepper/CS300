//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           AsciiArtDriver.java, AsciiArtTester.java, Canvas.java, 
//                  DrawingChange.java, DrawingStack.java, 
//                  DrawingStackIterator.java, LinkedNode.java, StackADT.java
// Course:          300 Fall 2019
//
// Author:          Aiden Tepper
// Email:           ajtepper@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
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
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Tests all classes in this project.
 * 
 * @author aidentepper
 */
public class AsciiArtTester {
  
  /**
   * Main method runs the main tester method.
   * 
   * @param args
   */
  public static void main(String [] args) {
    System.out.println(runAsciiArtTestSuite());
  }
  
  /**
   * Tests the stack push and peek methods.
   * 
   * @return boolean - true if methods work as intended, false otherwise
   */
  public static boolean testStackPushPeek(){ 
    //creates a new drawing stack object
    DrawingStack test = new DrawingStack();
    //trys the peek method and returns false if exception not caught
    try {
      test.peek();
      return false;
    } catch(EmptyStackException e) {}
    //creates a drawing change object
    DrawingChange testChange = new DrawingChange(1, 1, 'T', 'T');
    //pushs the test drawing change into the test stack
    test.push(testChange);
    //tests if the push correctly worked
    if (!(test.peek().row == 1) || !(test.peek().col == 1) || !(test.peek().prevChar == 'T')) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of Canvas.Draw()
   * 
   * @return boolean - true if the method works as intended, false otherwise
   */
  public static boolean testCanvasDraw(){
    //creates a new canvas
    Canvas test = new Canvas(6, 6);
    //trys out the draw method, returns false if an exception not caught
    try {
      test.draw(7, 1, 'T');
      return false;
    } catch(IllegalArgumentException e) {}
    return true;
  }
  
  /**
   * Checks for the correctness of DrawingStack.pop(). It calls DrawingStack.push() 
   * and DrawingStack.peek() methods.
   * 
   * @return boolean - true if the method works as intended, false otherwise.
   */
  public static boolean testStackPop(){
    //creates a new drawing stack
    DrawingStack test = new DrawingStack();
    //tests out the pop method, returns false if the exception not caught
    try {
      test.pop();
      return false;
    } catch(EmptyStackException e) {}
    //creates a new drawing change object
    DrawingChange hi = new DrawingChange(1, 1, 'T', 'T');
    //pushes the change into the stack
    test.push(hi);
    DrawingChange popped = test.pop();
    //tests the pop method with a comparison
    if (!(popped.row == 1)) {
      return false;
    }
    return true;
  }
 
  /**
   * Checks for the correctness of DrawingStackIterator.hasNext() and DrawingStackIterator.next() 
   * methods.
   * 
   * @return boolean - if the drawing stack iterator class worked as intended, false otherwise
   */
  public static boolean testDrawingStackIterator(){
    //creates a new stack
    DrawingStack stack = new DrawingStack();
    //creates three new changes
    DrawingChange firstChange = new DrawingChange(0, 2, 'f', 's');
    DrawingChange secondChange = new DrawingChange(0, 1, 't', 'c');
    DrawingChange thirdChange = new DrawingChange(0, 0, 'a', 'b');
    //pushes all changes into the stack
    stack.push(firstChange);
    stack.push(secondChange);
    stack.push(thirdChange);
    //Iterates through all changes
    Iterator<DrawingChange> iterator = stack.iterator();
    //tests the order of the iterator
    if(!iterator.next().equals(thirdChange)) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of the Canvas.undo() method.
   * 
   * @return boolean - true if the canvas undo method works as intended, false otherwise
   */
  public static boolean testCanvasUndo(){
    //creates a new canvas
    Canvas test = new Canvas(6, 6);
    //draws a T on the canvas
    test.draw(1, 1, 'T');
    //tests the undo method
    if (!test.undo()) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of the Canvas.redo() method.
   * 
   * @return boolean - true if the redo method works properly, false otherwise
   */
  public static boolean testCanvasRedo(){
    //creates a new canvas
    Canvas test = new Canvas(6, 6);
    //draws a T
    test.draw(1, 1, 'T');
    //undoes the action
    test.undo();
    //tests the redo method
    if (!test.redo()) {
      return false;
    }
    return true;
  }
  
  /**
   * Super method that runs all tester methods.
   * 
   * @return boolean - true if all other testers return true, false otherwise
   */
  public static boolean runAsciiArtTestSuite() { 
    return testStackPushPeek() && testStackPop() && testDrawingStackIterator() 
        && testCanvasDraw() && testCanvasUndo() && testCanvasRedo();
  }
  
}
