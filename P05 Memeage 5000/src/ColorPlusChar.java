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

public class ColorPlusChar extends Color {
  
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }
  
  public ColorPlusChar(Color color) {
    super(color);
  }
  
  // stores 8-bit character within the least significant bits of color components
  public void hideChar(char character) {
    String s = Integer.toBinaryString(character);
    s = String.format("%8s", s).replace(' ', '0');
    setBits(2, 24, Integer.parseInt(s.substring(0, 2), 2));
    setBits(2, 16, Integer.parseInt(s.substring(2, 4), 2));
    setBits(2, 8, Integer.parseInt(s.substring(4, 6), 2));
    setBits(2, 0, Integer.parseInt(s.substring(6, 8), 2));
  }
  
  // retrieves 8-bit character from the least significant bits of color components
  public char revealChar() {
    String a = Integer.toBinaryString(getBits(2, 24));
    a = String.format("%2s", a).replace(' ', '0');
    String b = Integer.toBinaryString(getBits(2, 16));
    b = String.format("%2s", b).replace(' ', '0');
    String c = Integer.toBinaryString(getBits(2, 8));
    c = String.format("%2s", c).replace(' ', '0');
    String d = Integer.toBinaryString(getBits(2, 0));
    d = String.format("%2s", d).replace(' ', '0');
    int parseInt = Integer.parseInt(a + b + c + d, 2);
    return (char)parseInt;
  }
  
}
