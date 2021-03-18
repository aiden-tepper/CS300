//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Calendar Printer Project
// Files:           CalendarPrinter.java, CalendarTester.java (tester class)
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

public class CalendarTester {
  
  /**
   * The main method calls every tester method, each of which corresponds to a method in
   * the CalendarPrinter.java file. The result of each test (true or false) is printed
   * to the console.
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testGetCentury());
    System.out.println(testGetYearWithinCentury());
    System.out.println(testGetIsLeapYear());
    System.out.println(testGetMonthIndex());
    System.out.println(testGetNumberOfDaysInMonth());
    System.out.println(testGetFirstDayOfWeekInMonth());
    System.out.println(testGenerateCalendar());
  }

  /**
   * Runs the getCentury method with three different years to test if the method is
   * working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Runs the getYearWithinCentury method with three different years to test if the method
   * is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("1999") != 99)
      return false;
    if (CalendarPrinter.getYearWithinCentury("72") != 72)
      return false;
    if (CalendarPrinter.getYearWithinCentury("527") != 27)
      return false;
    return true;
  }

  /**
   * Runs the getIsLeapYear method with four different years to test if the method
   * is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2000") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("2100") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("79") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("1912") != true)
      return false;
    return true;
  }

  /**
   * Runs the getMonthIndex method with four different months to test if the method
   * is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("Februarafsy") != 1)
      return false;
    if (CalendarPrinter.getMonthIndex("mar") != 2)
      return false;
    if (CalendarPrinter.getMonthIndex("DECEMBER") != 11)
      return false;
    if (CalendarPrinter.getMonthIndex("test") != -1)
      return false;
    return true;
  }

  /**
   * Runs the getNumberOfDaysInMonth method with four different months/years to test
   * if the method is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("January", "2019") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("February", "2019") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("FEB", "2000") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("SEPTSAHUfdDFS", "534") != 30)
      return false;
    return true;
  }

  /**
   * Runs the getFirstDayOfWeekInMonth method with four different months/years to
   * test if the method is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("September", "2019") != 6)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("jan", "1999") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("fEB", "1800") != 5)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("JuNly", "2998") != 4)
      return false;
    return true;
  }

  /**
   * Runs the generateCalendar method with three different months/years to
   * test if the method is working properly.
   * @return the result of the test -- true (successful) or false (unsuccessful)
   */
  public static boolean testGenerateCalendar() {
    if (!CalendarPrinter.generateCalendar("September", "2019")[1][0].equals("."))
      return false;
    if (!CalendarPrinter.generateCalendar("oct", "1997")[3][3].equals("16"))
      return false;
    if (!CalendarPrinter.generateCalendar("FEBBB", "2100")[4][6].equals("28"))
      return false;
    return true;
  }
}
