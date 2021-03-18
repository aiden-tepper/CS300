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

import java.util.Scanner;

public class CalendarPrinter {
  
  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
  private final static int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  /**
   * The main method uses a scanner object to ask the user for a month and year,
   * then generates a calendar for the given month/year and prints it to the console.
   * @param args
   */
  public static void main(String[] args) {
    
    Scanner scnr = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    System.out.print("Enter the month to print: ");
    String month = scnr.nextLine();
    System.out.print("Enter the year to print: ");
    String year = scnr.nextLine();
    String calendar[][] = generateCalendar(month, year);
    printCalendar(calendar);
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");

  }
  
  /**
  * Calculates the number of centuries (rounded down) that is represented by
  * the specified year (ie. the integer part of year/100).
  * @param year to compute the century of (based on the Gregorian Calendar AD)
  * String must contain the digits of a single non-negative int for year.
  * @return number of centuries in the specified year
  */
  public static int getCentury(String year) {
    int century = (int)Math.floor(Integer.parseInt(year)/100);
    return century;
  }

  /**
  * Calculates the number of years between the specified year, and the first
  * year in the specified year's century. This number is always between 0 - 99.
  * @param year to compute the year within century of (Gregorian Calendar AD)
  * String must contain the digits of a single non-negative int for year.
  * @return number of years since first year in the current century
  */
  public static int getYearWithinCentury(String year) {
    int yearWithinCentury;
    if(Integer.parseInt(year) >= 100) {
      yearWithinCentury = Integer.parseInt(year.substring(year.length()-2, year.length()));
      return yearWithinCentury;
    } else {
      yearWithinCentury = Integer.parseInt(year);
      return yearWithinCentury;
    }
  }

  /**
  * This method computes whether the specified year is a leap year or not.
  * @param yearString is the year that is being checked for leap-year-ness
  * String must contain the digits of a single non-negative int for year.
  * @return true when the specified year is a leap year, and false otherwise
  */
  public static boolean getIsLeapYear(String yearString) {
    int year = Integer.parseInt(yearString);
    if(year % 4 != 0) {
      return false;
    } else if (year % 100 != 0) {
      return true;
    } else if (year % 400 != 0) {
      return false;
    }
    return true;
  }
  
  /**
  * Converts the name or abbreviation for any month into the index of that
  * month's abbreviation within MONTHS_OF_YEAR. Matches the specified month
  * based only on the first three characters, and is case in-sensitive.
  * @param month which may or may not be abbreviated to 3 or more characters
  * @return the index within MONTHS_OF_YEAR that a match is found at
  * and returns -1, when no match is found
  */
  public static int getMonthIndex(String month) {
    String firstThree = month.substring(0, 3).toUpperCase();
    for(int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if(firstThree.equals(MONTHS_OF_YEAR[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
  * Calculates the number of days in the specified month, while taking into
  * consideration whether or not the specified year is a leap year.
  * @param month which may or may not be abbreviated to 3 or more characters
  * @param year of month that days are being counted for (Gregorian Calendar AD)
  * String must contain the digits of a single non-negative int for year.
  * @return the number of days in the specified month (between 28-31)
  */
  public static int getNumberOfDaysInMonth(String month, String year) {
    String firstThree = month.substring(0, 3).toUpperCase();
    if(firstThree.equals("FEB") && getIsLeapYear(year) == true) {
      return 29;
    }
    int monthIndex = getMonthIndex(firstThree);
    return DAYS_IN_MONTH[monthIndex];
  }
  
  /**
  * Calculates the index of the first day of the week in a specified month.
  * The index returned corresponds to position of this first day of the week
  * within the DAYS_OF_WEEK class field.
  * @param month which may or may not be abbreviated to 3 or more characters
  * @param year of month to determine the first day from (Gregorian Calendar AD)
  * String must contain the digits of a single non-negative int for year.
  * @return index within DAYS_OF_WEEK of specified month's first day
  */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int m = getMonthIndex(month) + 1;
    int k = getYearWithinCentury(year);
    int j = getCentury(year);
    int answer;
    if(m <= 2) {
      k = getYearWithinCentury(Integer.toString(Integer.parseInt(year)-1));
      j = getCentury(Integer.toString(Integer.parseInt(year)-1));
      answer = (1 + (int)13*(m+13)/5 + k + (int)k/4 + (int)j/4 + 5*j) % 7;
    } else {
      answer = (1 + (int)13*(m+1)/5 + k + (int)k/4 + (int)j/4 + 5*j) % 7;
    }
    return(answer + 5) % 7;
  }
  
  /**
  * Creates and initializes a 2D String array to reflect the specified month.
  * The first row of this array [0] should contain labels representing the days
  * of the week, starting with Monday, as abbreviated in DAYS_OF_WEEK. Every
  * later row should contain dates under the corresponding days of week.
  * Entries with no corresponding date in the current month should be filled
  * with a single period. There should not be any extra rows that are either
  * blank, unused, or completely filled with periods.
  * For example, the contents for September of 2019 should look as follows,
  * where each horizontal row is stored in different array within the 2d result:
  *
  * MON TUE WED THU FRI SAT SUN
  * . . . . . . 1
  * 2 3 4 5 6 7 8
  * 9 10 11 12 13 14 15
  * 16 17 18 19 20 21 22
  * 23 24 25 26 27 28 29
  * 30 . . . . . .
  *
  * @param month which may or may not be abbreviated to 3 or more characters
  * @param year of month generate calendar for (Gregorian Calendar AD)
  * String must contain the digits of a single non-negative int for year.
  * @return 2d array of strings depicting the contents of a calendar
  */
  public static String[][] generateCalendar(String month, String year) {
    //declare and initialize necessary variables
    int monthIndex = getMonthIndex(month);
    boolean isLeapYear = getIsLeapYear(year);
    int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);
    if(monthIndex == 1 && isLeapYear == true) {
      numberOfDaysInMonth = 29;
    }
    int firstDayOfWeekInMonth = getFirstDayOfWeekInMonth(month, year);
    String[][] calendar;
    
    //determine number of rows in array
    if(firstDayOfWeekInMonth == 6 && monthIndex != 1) {
      calendar = new String[7][7];
    } else if(firstDayOfWeekInMonth == 0 && monthIndex == 1) {
      calendar = new String[5][7];
    } else {
      calendar = new String[6][7];
    }
    
    //add day of the week labels
    for(int i = 0; i < 7; i++) {
      calendar[0][i] = DAYS_OF_WEEK[i];
    }
    
    //fill calendar with dots/numbers
    int currentDay = 1;
    boolean startDots = true;
    boolean endDots = false;
    if(firstDayOfWeekInMonth == 0) {
      startDots = false;
    }
    for(int j = 1; j < calendar.length; j++) {
      for(int k = 0; k < calendar[1].length; k++) {
        if(j == 1 && firstDayOfWeekInMonth != k && startDots == true) {
          calendar[j][k] = ".";
        } else if(endDots == true) {
          calendar[j][k] = ".";
        } else {
          calendar[j][k] = String.valueOf(currentDay);
          startDots = false;
          currentDay++;
        }
        if(currentDay == numberOfDaysInMonth + 1) {
          endDots = true;
        }
      }
    }
    return calendar;
  }
  
  /**
   * Prints generated calendar to the console.
   * @param two-dimensional string array containing the generated calendar
   */
  public static void printCalendar(String[][] calendar) {
    for(int j = 0; j < calendar.length; j++) {
      for(int k = 0; k < calendar[1].length; k++) {
        System.out.print(calendar[j][k] + " ");
        if(calendar[j][k].length() == 2) System.out.print(" ");
        if(calendar[j][k].length() == 1) System.out.print("  ");
      }
      System.out.println();
    }
  }
  
}
