//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P07 Study Playlist
// Files:           Song.java, SongCollection.java, DoublyLinkedNode.java, 
//                  Playlist.java, ReversePlaylist.java
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
 * Each instance of this class represents a collection of songs.
 * 
 * @author aidentepper
 */
public class SongCollection implements java.lang.Iterable<Song> {
  
  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;
  
  /**
   * Constructs a blank collection of songs.
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }
  
  /**
   * Adds song to the end/tail of this doubly linked list.
   * 
   * @param song - song to be added
   * 
   * @throws NullPointerException - when song is null
   */
  public void add(Song song) {
    if (song == null) {
      throw new NullPointerException("Song is null.");
    }
    if (head == null) {
      head = new DoublyLinkedNode<Song>(song);
      tail = head;
    } else {
      tail.setNext(new DoublyLinkedNode<Song>(tail, song, null));
      tail = tail.getNext();
    }
  }

  /**
   * Removes and returns song from the front/head of this list.
   * 
   * @return - song to be removed
   * 
   * @throws NoSuchElementException - when list is empty
   */
 public Song remove() {
   if (this.head == null) {
     throw new NoSuchElementException("List is empty.");
   }
   Song removedSong;
   if (head.getNext() == null) {
     removedSong = head.getData();
     head = null;
     tail = null;
   } else {
     removedSong = head.getData();
     head = head.getNext();
     head.setPrevious(null);
   }
   return removedSong;
 }

  /**
   * Returns an iterator over elements of type T.
   * 
   * @Override
   * 
   * @return - an Iterator
   */
  public Iterator<Song> iterator() {
    if (playDirectionForward) {
      return new Playlist(head);
    } 
    return new ReversePlaylist(tail);
  }
 
  /**
   * When playDirectionForward is true, a SongCollection’s iterator() method should return a 
   * Playlist object, otherwise it should return a ReversePlaylist object.
   * 
   * @param isForward - determines direction of the iterator
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }
  
}
  
  ///////////////////////////////////////////////////////////////////////////////////
  //For each of the following big-O time complexity analyses, consider the problem
  //size to be the number of Songs that are stored within the argument songs, when
  //the method is first called.
  //
  //For analysisMethodA, the big-O time complexity is O(1).
  //
  //For analysisMethodB, the big-O time complexity is O(n).
  //
  //For analysisMethodC, the big-O time complexity is O(1).
  //
  ///////////////////////////////////////////////////////////////////////////////////
