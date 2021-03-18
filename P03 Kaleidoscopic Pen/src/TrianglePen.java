
import processing.core.PApplet;
import java.util.ArrayList;

public class TrianglePen {
  
  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private PApplet processing;
  private boolean showPoints;
  private ArrayList<Point> pointArray;
  private ArrayList<Triangle> triangleArray;
  private int pointCounter;
  
  public TrianglePen(PApplet processing, boolean showPoints){
    
    this.processing = processing;
    this.showPoints = showPoints;
    mouseWasPressed = false;
    keyWasPressed = '\0';
    pointArray = new ArrayList<Point>();
    triangleArray = new ArrayList<Triangle>();
    pointCounter = 0;
    
  }
  
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {

    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();

  }
  
  private void handleMousePress(int mouseX, int mouseY) {
    
    Point point = new Point(mouseX, mouseY);
    pointArray.add(point);
    pointCounter ++;
    
    if(pointCounter == 3) {
      Point a = pointArray.get(pointArray.size()-3);
      Point b = pointArray.get(pointArray.size()-2);
      Point c = pointArray.get(pointArray.size()-1);
      Triangle triangle = new Triangle(a, b, c, -1);
      triangleArray.add(triangle);
      pointCounter = 0;
    }

  }

  private void handleMouseRelease(int mouseX, int mouseY) {

  }

  private void handleMouseDrag(int mouseX, int mouseY) {

  }

  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    //check to see if key pressed is a real key
    boolean realKey = false;
    char[] realKeys = new char[] {0, 1, 2, 3, 4, 5, 6, 7};
    for (int i = 0; i < realKeys.length; i++) {
      if (realKeys[i] == keyPressed);
        realKey = true;
        System.out.println(realKey);
    }
    //check to see if mouse is over triangle
    boolean overTriangle = false;
    int triangleIndex = 0;
    for (int i = 0; i < triangleArray.size(); i++) {
      if (triangleArray.get(i).isOver(mouseX, mouseY)) {
        overTriangle = true;
        triangleIndex = i;
      }
    }
    if (realKey && overTriangle) {
      triangleArray.get(triangleIndex).setColor(keyPressed - '0');
    }
  }

  private void draw() {
    
    if (showPoints) {
      for (int i = 0; i < pointArray.size(); i++) {
        pointArray.get(i).draw(processing);
      }
    }
    
    for(int i = 0; i < triangleArray.size(); i++) {
      triangleArray.get(i).draw(processing);
    }

  }
  
}
