import processing.core.PApplet;

public class Triangle {

  private Point a;
  private Point b;
  private Point c;
  private int colorIndex;
  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
      // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  public Triangle(Point a, Point b, Point c, int colorIndex) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.colorIndex = colorIndex;
  }
  
  public void setColor(int colorIndex) {
    this.colorIndex = colorIndex;
  }
  
  public void draw(PApplet drawTo) { // draw a white circle at this point’s position
    drawTo.triangle(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
  }
  
  public boolean isOver(int x, int y) { // returns true when the position x, y
    // is within the circle drawn to visualize this point, otherwise returns false

    return isPointInTriangle(x, y, a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
    
  }
  
  private static boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y,
      int t3x, int t3y) {
    px -= t1x; // don't worry about this arithmetic
    py -= t1y;
    t2x -= t1x;
    t2y -= t1y;
    t3x -= t1x;
    t3y -= t1y;
    double dotp2 = px * t2x + py * t2y;
    double dotp3 = px * t3x + py * t3y;
    double dot22 = t2x * t2x + t2y * t2y;
    double dot23 = t2x * t3x + t2y * t3y;
    double dot33 = t3x * t3x + t3y * t3y;
    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
    return (a >= 0) && (b >= 0) && (a + b < 1);
  }

}
