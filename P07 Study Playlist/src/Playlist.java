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

import java.util.NoSuchElementException;

/**
 * Implements the java.util.Iterator<Song> interface. Represents a playlist of songs.
 * 
 * @author aidentepper
 */
public class Playlist implements java.util.Iterator<Song> {

  DoublyLinkedNode<Song> linkedSong;
  
  /**
   *  Takes a DoublyLinkedNode<Song> as input. The node that is passed to the Playlist constructor 
   *  is expected to be the head node of a doubly linked list.
   * 
   * @param linkedSong - head node of a doubly linked list.
   */
  public Playlist(DoublyLinkedNode<Song> linkedSong) {
    this.linkedSong = linkedSong;
  }
  
  /**
   * Returns true when there are more songs left for it to return, and false otherwise.
   * 
   * @override
   * 
   * @return - true when more songs are left, false otherwise
   */
  public boolean hasNext() {
    if(linkedSong == null) {
      return false;
    }
    return true;
  }

  /**
   * Returns the next song in the playlist.
   * 
   * @throws NoSuchElementException - if there are no more songs to be returned
   */
  public Song next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more songs to be returned.");
    }
    Song data = linkedSong.getData(); 
    linkedSong = linkedSong.getNext(); 
    return data;
  }
  
}
