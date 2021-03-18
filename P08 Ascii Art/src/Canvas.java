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

/**
 * Represents an ASCII art image.
 * 
 * @author aidentepper
 */
public class Canvas {

  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char [][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor creates a new canvas which is initially blank.
   * 
   * @param width - the width of the canvas
   * @param height - the height of the canvas
   * 
   * @throws IllegalArgumentException - if width and height don't fit parameters
   */
  public Canvas(int width, int height) {
    if(width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height both have to be positive and non-zero");
    }
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }
  
  /**
   * Draws a character at the given position drawingArray[row][col].
   * 
   * @param row - row to be drawn
   * @param col - col to be drawn
   * @param c - character to be drawn
   * 
   * @throws IllegalArgumentException - if drawing is outside of canvas
   */
  public void draw(int row, int col, char c) {
    //Throws an IllegalArgumentException if the drawing position is outside the canvas
    if(row >= height || col >= width || row < 0 || col < 0) {
      throw new IllegalArgumentException("The drawing position is outside the canvas");
    }
    //If that position is already marked with a different character, overwrite it.
    char previous = drawingArray[row][col];
    drawingArray[row][col] = c;
    //After making a new change, add a matching DrawingChange to the undoStack
    //so that we can undo if needed.
    undoStack.push(new DrawingChange(row, col, previous, c));
    //After making a new change, the redoStack should be empty
    while(!redoStack.isEmpty()) {
      redoStack.pop();
    }
  }
  
  /**
   * Undo the most recent drawing change.
   * 
   * @return boolean - true if successful, false otherwise.
   */
  public boolean undo() {
    //If the undo stack is empty, return false
    if(undoStack.isEmpty()) {
      return false;
    }
    //An undone DrawingChange should be popped off the undoStack.
    DrawingChange undoneChange = undoStack.pop();
    //An undone DrawingChange should be added to the redoStack so that
    //we can redo if needed.
    redoStack.push(undoneChange);
    //The content of the drawingArray should be updated accordingly to this change.
    drawingArray[undoneChange.row][undoneChange.col] = undoneChange.prevChar;
    return true;
  }
  
  /**
   * Redo the most recent undone drawing change.
   * 
   * @return boolean - true if successful. False otherwise.
   */
  public boolean redo() {
    //Return false if the redo stack is empty
    if(redoStack.isEmpty()) {
      return false;
    }
    //A redone DrawingChange should be popped off the redoStack.  
    DrawingChange redo = redoStack.pop();
    //A redone DrawingChange should be added (back) to the undoStack so that
    //we can undo again if needed.
    undoStack.push(redo);
    //The content of the drawingArray should be updated accordingly to this change.
    drawingArray[redo.row][redo.col] = redo.newChar;
    return true;
    
  }
  
  /**
   * Return a printable string version of the Canvas.
   * 
   * @return String - Representation of canvas.
   */
  public String toString() {
    String str = "";
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        str += drawingArray[i][j];
      }
      //seperate each line
      str += System.lineSeparator();
    }
    return str;
  }

}
