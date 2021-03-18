
public class LinkedMegaBlock {
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock
  
  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as next reference.
   * 
   * @param block - data field to be set for this new LinkedMegaBlock.
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
  }
  
  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific reference to the next 
   * LinkedMegaBlock.
   * 
   * @param block - data field to be set for this newLinkedMegaBlock.
   * @param next - reference to the next LinkedMegaBlock of this LinkedMegaBlock.
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }
  
  /**
   * Returns the block data field of this LinkedMegaBlock.
   * 
   * @return - the block data field of this LinkedMegaBlock.
   */
  public MegaBlock getBlock() {
    return this.block;
  }
  
  /**
   * Sets the block instance field of this LinkedMegaBlock.
   * 
   * @param block - the block to set.
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }
  
  /**
   * Returns the reference to the next field of this LinkedMegaBlock.
   * 
   * @return - the next.
   */
  public LinkedMegaBlock getNext() {
    return next;
  }
  
  /**
   * Sets the reference to the next field of this LinkedMegaBlock.
   * 
   * @param next - the next to set.
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }
  
  /**
   * Returns a String representation of this Linked MegaBlock object. 
   * This String will be : block.toString() + " -> " // if next field is not null 
   * block.toString() + " -> END" // if next field is null For instance, 
   * LinkedMegaBlock block1 = new LinkedMegaBlock(new MegaBlock(Color.BLUE, '1')); 
   * LinkedMegaBlock block2 = new LinkedMegaBlock(new MegaBlock(Color.RED, 'A'), block1); 
   * block1.toString() returns "BLUE 1 -> END" block2.toString() returns "RED A -> "
   * 
   * @Override - toString in class java.lang.Object.
   * 
   * @return - a String representation of this Linked MegaBlock object.
   */
  public java.lang.String toString() {
    if (next == null) {
      return (block.toString() + " -> END");
    } else {
      return(block.toString() + " -> ");
    }
  }
}
