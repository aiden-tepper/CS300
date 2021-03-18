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

import java.io.File;

public class MemeageTests {

  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }
  
  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(0);
    test.setBits(4, 10, 13);
    if(test.getBits(4, 10) != 13) {
      return false;
    }
    return true;
  }
  
  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0);
    test.setBits(3, 8, 13);
    if(test.getInt() != 1280) {
      return false;
    }
    return true;
  }
  
  public static boolean testColor() {
    Color test = new Color(140, 255, 255, 48);
    String binary = test.toString().split(" ")[2];
    if(!binary.equals("10001100111111111111111100110000")) {
      return false;
    }
    test.setAlpha(175);
    if(test.getGreen() != 255) {
      return false;
    }
    if(test.getAlpha() != 175) {
      return false;
    }
    return true;
  }
  
  public static boolean testImage() {
    try {
      File imageFile = new File("C:\\Users\\Aiden Tepper\\OneDrive - UW-Madison\\Documents\\"
          + "eclipse-workspace\\P05 Memeage 5000\\src\\testImage.png");
      Image image = new Image(imageFile);
      if(image.getWidth() != 3) {
        return false;
      }
      if(image.getHeight() != 3) {
        return false;
      }
      int r = image.getColor(1, 1).getRed();
      int g = image.getColor(1, 1).getGreen();
      int b = image.getColor(1, 1).getBlue();
      if(r != 0) {
        return false;
      }
      if(g != 255) {
        return false;
      }
      if(b != 255) {
        return false;
      }
    } catch(Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }
  
  public static boolean testColorPlusChar() {
    Color colorTest = new Color(0);
    ColorPlusChar test = new ColorPlusChar(colorTest, 'a');
    if(test.revealChar() != 'a') {
      return false;
    }
    test.hideChar('x');
    if(test.revealChar() != 'x') {
      return false;
    }
    return true;
  }
  
  public static boolean testMemeage() {
    File imageFile = new File("C:\\Users\\Aiden Tepper\\OneDrive - UW-Madison\\Documents\\"
        + "eclipse-workspace\\P05 Memeage 5000\\src\\image01.png");
    try {
      Memeage test = new Memeage(imageFile);
      if(!test.getMeme().equals("Clever code blinds, whereas clear code reveals.")) {
        return false;
      }
    } catch(Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }
  
}
