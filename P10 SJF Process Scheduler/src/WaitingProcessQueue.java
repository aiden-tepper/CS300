//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P10 SJF Process Scheduler
// Files:           WaitingProcessQueue.java, ProcessScheduler.java,
//                      ProcessSchedulerTester.java (tester class),
//                      CustomProcess.java
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
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/**
 * Class that implements the WaitingQueueADT interface. Contains an array representation of a
 * min-heap priority queue as well as several methods relating to editing/accessing the queue
 * 
 * @author ajtepper
 * 
 */
public class WaitingProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // initial capacity of this waiting process queue
  private CustomProcess[] data; // min heap-array storing the CustomProcesses inserted in this
                                // WaitingProcessQueue. data is an oversize array
  private int size; // number of CustomProcesses stored in this WaitingProcessQueue

  /**
   * Constructor initializes the array with the given size and sets the current size to 0
   * 
   */
  public WaitingProcessQueue() {
    data = new CustomProcess[INITIAL_CAPACITY];
    size = 0;
  }
  
  /**
   * Inserts a newObject in this waiting queue.
   * 
   * @param newObject to insert in this waiting queue
   * 
   */
  public void insert(CustomProcess process) {
    if(size >= INITIAL_CAPACITY) {
      doubleSize();
    }
    data[size] = process;
    minHeapPercolateUp(size);
    size++;
  }

  /**
   * Removes and returns the element with the highest priority.
   * 
   * @return the removed element
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *                                          is empty
   */
  public CustomProcess removeBest() {
    CustomProcess best = data[0]; // store best node to be returned later
    data[0] = data[size-1]; // move farthest right node to root
    data[size-1] = null; // delete farthest right node
    size--;
    minHeapPercolateDown(0); // percolate root node down to correct the min heap
    return best;
  }


  /**
   * Returns without removing the element with the highest priority.
   * 
   * @return the element with the highest priority
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *                                          is empty
   */
  public CustomProcess peekBest() {
    return data[0];
  }

  /**
   * Returns size of priority queue
   * 
   * @return the size of priority queue
   * 
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether this waiting queue is empty or not.
   * 
   * @return true if this waiting queue is empty, false otherwise
   * 
   */
  public boolean isEmpty() {
    return(data[0] == null);
  }
  
  /**
   * Helper method to recursively percolate a process up the min-heap tree after inserting
   * it at the end
   * 
   * @param index at which to percolate up from
   * 
   */
  private void minHeapPercolateUp(int index) { 
    int parentIndex;
    while(index > 0) {
      parentIndex = (index - 1) / 2;
      if(data[index].compareTo(data[parentIndex]) > 0) {
        return;
      } else {
        swap(index, parentIndex);
        minHeapPercolateUp(parentIndex);
      }
    }
  }
  
  /**
   * Helper method to recursively percolate a process down the min-heap tree after the root was
   * deleted and filled in by the last process in the array
   * 
   * @param index at which to percolate down from
   * 
   */
  private void minHeapPercolateDown(int index) { 
    int leftChild = 2*index + 1;
    int rightChild = leftChild + 1;
    if(data[leftChild] == null) {
      return;
    } else if(data[rightChild] == null) {
      if(data[index].compareTo(data[leftChild]) > 0) {
        swap(index, leftChild);
      }
    } else if(data[index].compareTo(data[rightChild]) < 0
        && data[index].compareTo(data[leftChild]) < 0) {
      return;
    } else {
      int smallestChild = smallestChild(index);
      swap(index, smallestChild);
      minHeapPercolateDown(smallestChild);
    }
  }
  
  /**
   * Private method that doubles the size of the array when its capacity is reached
   *
   */
  private void doubleSize() {
    CustomProcess[] copiedData = new CustomProcess[data.length * 2];
    for(int i = 0; i < data.length; i++) {
      copiedData[i] = data[i];
    }
    data = copiedData;
  }
  
  /**
   * Helper method that swaps two given processes in the array
   * 
   * @param index of first process
   * @param parentIndex of second process
   * 
   */
  private void swap(int index, int parentIndex) {
    CustomProcess temp = data[parentIndex];
    data[parentIndex] = data[index];
    data[index] = temp;
    index = parentIndex;
  }
  
  /**
   * Helper method that determines and returns the index of the smallest child given a process
   * in the tree
   * 
   * @param index of the parent
   * @return index of the smallest child
   * 
   */
  private int smallestChild(int index) {
    int leftChild = 2*index + 1;
    int rightChild = leftChild + 1;
    if(data[rightChild].compareTo(data[leftChild]) < 0) {
      return rightChild;
    } else {
      return leftChild;
    }
  }
  
  /**
   * Overrides toString() method
   * 
   * @return the string to print
   * 
   */
  @Override
  public String toString() {
    if(size == 0) {
      return " ";
    }
    String returnedString = "";
    for(int i = 0; i < size; i++) {
      returnedString += data[i] + " ";
    }
    return returnedString;
  }
  
}
