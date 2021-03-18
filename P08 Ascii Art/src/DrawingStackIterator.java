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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implements the iterator interface for a drawing stack.
 * 
 * @author aidentepper
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  
  private LinkedNode<DrawingChange> nextElement;
  
  /**
   * Constructs a drawing stack iterator object.
   * 
   * @param top - represents the top of the stack
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> top) {
    this.nextElement = top;
  }

  /**
   * Tests if another element is next in the stack.
   * 
   * @return boolean - true if another element is next, false otherwise
   * 
   * @override 
   */
  public boolean hasNext() {
    if (nextElement == null) {
      return false;
    }
    return true;
  }

  /**
   * Gets the next item to be returned by the iterator.
   * 
   * @return DrawingChange data - the next drawing change to be returned by the iterator
   * 
   * @Override
   */
  public DrawingChange next() {
    if (!hasNext()) {
      throw new NoSuchElementException("the iteration has no more elements");
    }
    DrawingChange data = nextElement.getData();
    nextElement = nextElement.getNext();
    return data;
  }
  
}
