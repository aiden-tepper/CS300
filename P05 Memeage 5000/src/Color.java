//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Memage 5000 Project
// Files:           Color.java, ColorPluChar.java, Memage.java,
//                  MemageTest.java (tester class),
//                  
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
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class is a subclass of FourBytes. It stores argb (alpha, red, green, blue) data for
 * a pixel in an image, and contains accessor and mutator methods to change/retrieve these values.
 * 
 * @author Aiden Tepper
 */
public class Color extends FourBytes {
  
  public Color(int argb) {
    super(argb);
  }
  
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    setBits(8, 24, alpha);
    setBits(8, 16, red);
    setBits(8, 8, green);
    setBits(8, 0, blue);
  }
  
  public Color(Color other) {
    super(other.getInt());
  }
  
  public int getARGB() {
    return getInt();
  }
  
  public int getAlpha() {
    return getBits(8, 24);
  }
  
  public int getRed() {
    return getBits(8, 16);
  }
  
  public int getGreen() {
    return getBits(8, 8);
  }
  
  public int getBlue() {
    return getBits(8, 0);
  }
  
  public void setARGB(int argb) {
    setBits(32, 0, argb);
  }
  
  public void setAlpha(int alpha) {
    setBits(8, 24, alpha);
  }
  
  public void setRed(int red) {
    setBits(8, 16, red);
  }
  
  public void setGreen(int green) {
    setBits(8, 8, green);
  }
  
  public void setBlue(int blue) {
    setBits(8, 0, blue);
  }

}
