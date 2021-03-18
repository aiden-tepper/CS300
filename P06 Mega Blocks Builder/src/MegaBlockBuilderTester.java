
public class MegaBlockBuilderTester {
  public static void main(String[] args) {
    System.out.println("equals() method works properly: " + testMegaBlockEquals());
    System.out.println("toString() method works properly: " + testMegaBlockToString());
    System.out.println("LinkedMegaBlock class works properly: " + testLinkedMegaBlock());
  }
  
  public static boolean testMegaBlockEquals() {
    MegaBlock testBlock1 = new MegaBlock(Color.RED, 'b');
    MegaBlock testBlock2 = new MegaBlock(Color.RED, 'b');
    MegaBlock testBlock3 = new MegaBlock(Color.BLUE, 'b');
    String testString = "Not a MegaBlock";
    if (testBlock1.equals(testString)) {
      return false;
    }
    if (testBlock1.equals(testBlock3)) {
      return false;
    }
    if (!testBlock1.equals(testBlock2)) {
      return false;
    }
    return true;
  }
  
  public static boolean testMegaBlockToString() {
    MegaBlock testBlock = new MegaBlock(Color.YELLOW, 'Y');
    if (!testBlock.toString().contentEquals("YELLOW Y")) {
      return false;
    }
    return true;
  }
  
  public static boolean testLinkedMegaBlock() {
    LinkedMegaBlock testLinked1 = new LinkedMegaBlock(new MegaBlock(Color.RED, 'R'));
    LinkedMegaBlock testLinked2 = new LinkedMegaBlock(new MegaBlock(Color.YELLOW, 'Y'), 
        new LinkedMegaBlock(new MegaBlock(Color.BLUE, 'B')));
    if (!testLinked1.getBlock().toString().equals("RED R")) {
      return false;
    }
    if (!testLinked2.getNext().getBlock().toString().equals("BLUE B")) {
      return false;
    }
    if (!testLinked1.toString().contentEquals("RED R -> END")) {
      return false;
    }
    if (!testLinked2.toString().contentEquals("YELLOW Y -> ")) {
      return false;
    }
    testLinked1.setNext(new LinkedMegaBlock(new MegaBlock(Color.BLUE, 'B')));
    if (!testLinked1.getNext().getBlock().toString().equals("BLUE B")) {
      return false;
    }
    return true;
  }
}
