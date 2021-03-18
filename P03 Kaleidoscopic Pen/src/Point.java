
import processing.core.PApplet;
import java.lang.Math;

public class Point {
  
  private int xPosition;
  private int yPosition;
  private final int POINT_DIAMETER = 8;

  public Point(int xPosition, int yPosition) {
    
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    
  }
  
  public int getX() {
    return xPosition;
  }
  
  public int getY() {
    return yPosition;
  }
  
  public void setPosition(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }
  
  public void draw(PApplet drawTo) { // draw a white circle at this point’s position
    drawTo.circle(xPosition, yPosition, POINT_DIAMETER);
  }
  
  public boolean isOver(int x, int y) { // returns true when the position x, y
    // is within the circle drawn to visualize this point, otherwise returns false

    double distance = Math.sqrt(Math.pow(x-xPosition, 2) + Math.pow(y-yPosition, 2));
    int radius = POINT_DIAMETER/2;
    if(distance <= radius) {
      return true;
    } else {
      return false;
    }
    
  }
  
}
