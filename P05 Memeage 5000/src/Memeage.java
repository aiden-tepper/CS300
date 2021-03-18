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
import java.io.IOException;

public class Memeage extends Image {
  
  public Memeage(File file) throws IOException {
    super(file);
  }
  
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }
  
  public void setMeme(String meme) throws IllegalArgumentException {
    if(meme.length() >= getHeight()*getWidth()) {
      throw new IllegalArgumentException("Length of meme exceeds pixels in image.");
    }
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        Color oldColor = getColor(x, y);
        ColorPlusChar newColor = new ColorPlusChar(oldColor, ' ');
        setColor(x, y, newColor);
      }
    }
    char[] temp = meme.toCharArray();
    char[] memeChars = new char[temp.length + 1];
    for(int i = 0; i < memeChars.length - 1; i++) {
      memeChars[i] = temp[i];
    }
    memeChars[memeChars.length-1] = '\0';
    int charCount = 0;
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        if(memeChars[charCount] > 127) {
          throw new IllegalArgumentException("Non-ASCII characters are not allowed.");
        }
        if(memeChars[charCount] == '\0') {
          return;
        }
        Color oldColor = getColor(x, y);
        ColorPlusChar newColor = new ColorPlusChar(oldColor, memeChars[charCount]);
        setColor(x, y, newColor);
        charCount++;
      }
    }
  }
  
  public String getMeme() throws IllegalStateException {
    String meme = "";
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        Color currentColor = getColor(x, y);
        ColorPlusChar currentColorPlusChar = new ColorPlusChar(currentColor);
        if(currentColorPlusChar.revealChar() == '\0') {
          return meme;
        }
        meme += currentColorPlusChar.revealChar();
      }
    }
    return meme;
  }
  
}
