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
 * Represents a stack of changes/drawings.
 * 
 * @author aidentepper
 */
public class DrawingStack implements StackADT<DrawingChange>, java.lang.Iterable<DrawingChange> {
  
  private LinkedNode<DrawingChange> top = null;
  private int size = 0;
  
  /**
   * Returns an iterator of drawing changes.
   * 
   * @return - an iterator of drawings with top as the start element
   * 
   * @override
   */
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(top);
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws java.util.IllegalArgumentException with a descriptive error message if the input
   *         element is null
   */
  public void push(DrawingChange element) {
    if (element == null) {
      throw new IllegalArgumentException("argument is null");
    }
    LinkedNode<DrawingChange> move = top;
    top = new LinkedNode<DrawingChange>(element, move);
    size++;
  }

  /**
   * Remove the element on the top of this stack and return it
   * 
   * @return the element removed from the top of the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange pop() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }
    size--;
    LinkedNode<DrawingChange> pop = top;
    top = top.getNext();
    return pop.getData();
  }

  /**
   * Get the element on the top of this stack
   * 
   * @return the element on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange peek() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getData();
  }

  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  public boolean isEmpty() {
    return (top == null);
  }

  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  public int size() {
    return size;
  }
  
}
