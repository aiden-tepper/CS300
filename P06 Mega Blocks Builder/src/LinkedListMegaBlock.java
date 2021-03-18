
public class LinkedListMegaBlock {
  
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list
  
  /**
   * Creates an empty linked list of mega blocks.
   */
  public LinkedListMegaBlock() {
    head = null;
    tail = null;
    this.size = 0;
    this.redCount = 0;
    this.yellowCount = 0;
    this.blueCount = 0;
  }
  
  /**
   * Returns true if this list contains no elements.
   * 
   * @return - true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns the size of this list.
   * 
   * @return - the number of megablocks stored in this list.
   */
  public int size() {
    return size;
  }
  
  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head = null;
    tail = null;
    this.size = 0;
    this.redCount = 0;
    this.yellowCount = 0;
    this.blueCount = 0;
  }
  
  /**
   * Adds a blueBlock at the end of this list.
   * 
   * @param blueBlock - new element to be added to this list.
   * 
   * @throws java.lang.IllegalArgumentException - if blueBlock is null or if the color of the 
   * specific blueBlock is not equal to Color.BLUE.
   */
  public void addBlue(MegaBlock blueBlock) {
    try {
      if (blueBlock == null || blueBlock.getColor() != Color.BLUE) {
        throw new IllegalArgumentException("blueBlock is null or the color of the \n" + 
            "   * specific blueBlock is not equal to Color.BLUE");
      }
      if(size == 0) {
        tail = new LinkedMegaBlock(blueBlock);
      } else {
        tail.setNext(new LinkedMegaBlock(blueBlock));
        tail = new LinkedMegaBlock(blueBlock);
      }
      size++;
      blueCount++;
    }
    catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Adds a new object at the head of this list.
   * 
   * @param redBlock - new element to be added to this list.
   * 
   * @throws java.lang.IllegalArgumentException - if redBlock is null or if its color does not 
   * equal to Color.RED.
   */
  public void addRed(MegaBlock redBlock) {
    try {
      if (redBlock == null || redBlock.getColor() != Color.RED) {
        throw new IllegalArgumentException("redBlock is null or the color of the \n" + 
            "   * specific redBlock is not equal to Color.RED");
      }
      if(size == 0) {
        head = new LinkedMegaBlock(redBlock);
      } else {
        head = new LinkedMegaBlock(redBlock, head);
      }
      size++;
      redCount++;
    }
    catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Adds the provided yellowBlock at the position index in this list.
   * 
   * @param index - index at which the specified yellow block is to be inserted.
   * @param yellowBlock - new element to be added to this list.
   * 
   * @throws java.lang.IllegalArgumentException - if yellowBlock is null or if it does not have a 
   * Color.YELLOW color.
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of the range reserved for 
   * yellow blocks (index < redCount || index > size - blueCount).
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    try {
      if(yellowBlock == null || yellowBlock.getColor() != Color.YELLOW) {
        throw new IllegalArgumentException("yellowBlock is null or the color of the \n" + 
            "   * specific yellowBlock is not equal to Color.YELLOW");
      }
      if(index < redCount || index > size-blueCount) {
        throw new IndexOutOfBoundsException("index is out of the range reserved for yellow blocks");
      }
      LinkedMegaBlock current = head;
      for(int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      LinkedMegaBlock temp = new LinkedMegaBlock(yellowBlock);
      temp.setNext(current.getNext());
      current.setNext(temp);
      size++;
      yellowCount++;
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list.
   * 
   * @return - the megablock object stored at position index of this list.
   * 
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || 
   * index >= size()).
   */
  public MegaBlock get(int index) {
    try {
      if(index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException("index is out of range");
      }
      LinkedMegaBlock current = head;
      for(int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      return current.getBlock();
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  
  /**
   * Replaces the megablock at the specified position in this list with the specified element if 
   * they have the same Color.
   * 
   * @param index - index of the block to replace.
   * @param block - element to be stored at the specified position.
   * 
   * @return - the element previously at the specified position.
   * 
   * @throws java.lang.IllegalArgumentException - if object is null or is not equal to the 
   * megablock already at at index position.
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range 
   * (index < 0 || index >= size()).
   */
  public MegaBlock set(int index, MegaBlock block) {
    try {
      if(block == null) {
        throw new IllegalArgumentException("MegaBlock is null");
      }
      if(index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException("Index is out of range");
      }
      LinkedMegaBlock current = head;
      for(int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      if(!current.getBlock().equals(block)) {
        throw new IllegalArgumentException("MegaBlock is not equal to the block it is to replace");
      }
      MegaBlock previous = current.getBlock();
      current.setBlock(block);
      return previous;
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  
  /**
   * Removes and returns the megablock at the head of this list if its color is red.
   * 
   * @return - a reference to the removed element.
   * 
   * @throws java.util.NoSuchElementException - if this list does not contain any red mega block.
   */
  public MegaBlock removeRed() {
    try {
      if(redCount == 0) {
        throw new java.util.NoSuchElementException("List does not contain any red blocks");
      }
      MegaBlock previous = head.getBlock();
      head = head.getNext();
      redCount--;
      size--;
      return previous;
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  
  /**
   * Removes and returns the element at the tail of this list if it has a blue color.
   * 
   * @return - a reference to the removed element.
   * 
   * @throws java.util.NoSuchElementException - if this list does not contain any blue block.
   */
  public MegaBlock removeBlue() {
    try {
      if(blueCount == 0) {
        throw new java.util.NoSuchElementException("List does not contain any blue blocks");
      }
      MegaBlock previous = tail.getBlock();
      LinkedMegaBlock beforeTail = head;
      for(int i = 0; i < size - 2; i++) {
        beforeTail = beforeTail.getNext();
      }
      tail = beforeTail;
      blueCount--;
      size--;
      return previous;
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  
  /**
   * Removes and returns the element stored at index position in this list.
   * 
   * @param index - position of the element to remove in this list.
   * 
   * @return - a reference to the removed element.
   * 
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < redCount 
   * or index >= size - blueCount).
   */
  public MegaBlock removeYellow(int index) {
    try {
      if(index < redCount || index >= size - blueCount) {
        throw new IndexOutOfBoundsException("Index is out of range");
      }
      LinkedMegaBlock current = head;
      for(int i = 0; i < index - 2; i++) {
        current = current.getNext();
      }
      MegaBlock previous = current.getBlock();
      current.setNext(current.getNext().getNext());
      yellowCount--;
      size--;
      return previous;
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  
  /**
   * Returns the number of red mega bloks stored in this list.
   * 
   * @return the redCount.
   */
  public int getRedCount() {
    return redCount;
  }
  
  /**
   * Returns the number of yellow mega bloks stored in this list.
   * 
   * @return the yellowCount.
   */
  public int getYellowCount() {
    return yellowCount;
  }
  
  /**
   * Returns the number of blue mega bloks stored in this list.
   * 
   * @return the blueCount.
   */
  public int getBlueCount() {
    return blueCount;
  }
  
  /**
   * Returns a String representation of the contents of this list.
   * 
   * @Overrides - toString in class java.lang.Object.
   * 
   * @return - return a String representation of the content of this list. 
   * If this list is empty, an empty String ("") will be returned.
   */
  public java.lang.String toString() {
    
  }
}
