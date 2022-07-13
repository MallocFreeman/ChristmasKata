public class Tannenbaum {

  private final int height;
  private final int width;

  public Tannenbaum(int height) {
    this.height = height;
    this.width = calculateWidth(height);
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  private int calculateWidth(int height) {
    return (height == 0) ? 1 : 2 * height - 1;
  }
}
