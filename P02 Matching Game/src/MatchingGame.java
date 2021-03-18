//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P02 Matching Game/MatchingGame
// Files:           MatchingGame.java
// Course:          300, Fall, 2019
//
// Author:          Aiden Tepper
// Email:           ajtepper@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Alex Shwe
// Partner Email:   shwe@wisc.edu
// Partner Lecturer's Name: Mouna Ayari Ben Hadj Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X__ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   _X__ We have registered our team prior to the team registration deadline.
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

import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {  
  
  //Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  //Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
  //Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";
  //2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
  new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170},
  {170, 324}, {324, 324}, {478, 324}, {632, 324},
  {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  //Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png",
  "ball.png", "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};
  
  private static PApplet processing; // PApplet object that represents
  //the graphic display window
  private static Card[] cards; // one dimensional array of cards
  private static PImage[] images; // array of images of the different cards
  private static Random randGen; // generator of random numbers
  private static Card selectedCard1; // First selected card
  private static Card selectedCard2; // Second selected card
  private static boolean winner; // boolean evaluated true if the game is won,
  //and false otherwise
  private static int matchedCardsCount; // number of cards matched so far
  //in one session of the game
  private static String message; // Displayed message to the display window
  private static int numSelected;
  private static boolean reset;
  
  public static void main(String[] args) {
    Utility.runApplication(); // starts the application
  }
  
  /**
  * Defines the initial environment properties of this game as the program starts
  */
  public static void setup(PApplet processing) {
    MatchingGame.processing = processing;
    // create a static field images array such that it has exactly the same length as
    // CARD_IMAGES_NAMES array, and stores type PImage.
    images = new PImage[CARD_IMAGES_NAMES.length];
    // use for loop and loadImage() method to insert images into array
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }
    MatchingGame.initGame();
  }
  
  /**
  * Initializes the Game
  */
  public static void initGame() {
    randGen = new Random();
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";
    numSelected = 0;
    reset = false;

    cards = new Card[CARD_IMAGES_NAMES.length * 2];
    int[] numbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    int size = 12;
    int randIndex;
    int randNum;
    for (int i = 0; i < 6; i++) {
      randIndex = randGen.nextInt(size);
      randNum = numbers[randIndex];
      cards[randNum] =
          new Card(images[i], CARDS_COORDINATES[randNum][0], CARDS_COORDINATES[randNum][1]);
      for (int p = randIndex; p < size - 1; p++) {
        numbers[p] = numbers[p + 1];
      }
      size--;

      randIndex = randGen.nextInt(size);
      randNum = numbers[randIndex];
      cards[randNum] =
          new Card(images[i], CARDS_COORDINATES[randNum][0], CARDS_COORDINATES[randNum][1]);
      for (int p = randIndex; p < size - 1; p++) {
        numbers[p] = numbers[p + 1];
      }
      size--;
    }
  }

  /**
  * Callback method called each time the user presses a key
  */
  public static void keyPressed() {
    PApplet temp = processing;
    processing = temp;
    char value = processing.key;
    if (value == 'n' || value == 'N') {
      initGame();
    }
  }
  
  /**
  * Callback method draws continuously this application window display
  */
  public static void draw() {
    // Set the color used for the background of the Processing window
    processing.background(245, 255, 250); // Mint cream color
    for (int l = 0; l < 12; l++) {
      cards[l].draw();
    }
    displayMessage(message);
  }

  /**
  * Displays a given message to the display window
  * @param message to be displayed to the display window
  */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }
  
  /**
  * Checks whether the mouse is over a given Card
  * @return true if the mouse is over the storage list, false otherwise
  */
  public static boolean isMouseOver(Card card) {

    int mouseX = processing.mouseX;
    int mouseY = processing.mouseY;

    int height = card.getHeight();
    int width = card.getWidth();

    float xCoordinate = card.getX();
    float yCoordinate = card.getY();

    if (Math.abs(mouseX - xCoordinate) <= width / 2) {
      if (Math.abs(mouseY - yCoordinate) <= height / 2) {
        return true;
      }
    }

    return false;

  }

  /**
  * Callback method called each time the user presses the mouse
  */
  public static void mousePressed() {

    if (winner) {
      return;
    }
    
    if (reset == true) {
      selectedCard1.deselect();
      selectedCard1.setVisible(false);
      selectedCard2.deselect();
      selectedCard2.setVisible(false);
      reset = false;
    }

    if (numSelected == 0) {
      for (int i = 0; i < cards.length; i++) {
        if (isMouseOver(cards[i])) {
          if (cards[i].isVisible())
            break;
          cards[i].setVisible(true);
          cards[i].select();
          selectedCard1 = cards[i];
          numSelected++;
          break;
        }
      }
    } else if (numSelected == 1) {
      for (int i = 0; i < cards.length; i++) {
        if (isMouseOver(cards[i])) {
          if (cards[i].isVisible())
            break;
          cards[i].setVisible(true);
          cards[i].select();
          selectedCard2 = cards[i];
          numSelected++;
          break;
        }
      }
      if (matchingCards(selectedCard1, selectedCard2)
          && selectedCard1.getX() != selectedCard2.getY()) {
        message = MATCHED;
        matchedCardsCount += 2;
        if (matchedCardsCount == 12) {
          message = CONGRA_MSG;
          winner = true;
        }
      } else {
        message = NOT_MATCHED;
        reset = true;
      }
      numSelected = 0;
    }

  }

  /**
  * Checks whether two cards match or not
  * @param card1 reference to the first card
  * @param card2 reference to the second card
  * @return true if card1 and card2 image references are the same, false otherwise
  */
  public static boolean matchingCards(Card card1, Card card2) {
    if (card1.getImage() == card2.getImage()) {
      return true;
    }
    return false;
  }
  
}

