import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TannenbaumStringifier {

  private final Tannenbaum tree;
  private final boolean withStar;

  public TannenbaumStringifier(Tannenbaum tree, boolean withStar) {
    this.tree = tree;
    this.withStar = withStar;
  }

  public TannenbaumStringifier(Tannenbaum tree) {
    this(tree, false);
  }

  public String stringify() {
    return centerStrings(build());
  }

  private List<String> build() {
    List<String> elements = new ArrayList<>();
    decorate(elements);
    elements.addAll(getNeedles());
    elements.addAll(getStamm());
    return elements;
  }

  private void decorate(List<String> elements) {
    if (withStar) {
      elements.add("*");
    }
  }

  private List<String> getNeedles() {
    return IntStream.range(0, tree.getHeight()).mapToObj(this::createTannenbaumNeedles)
        .collect(Collectors.toList());
  }

  private String createTannenbaumNeedles(int i) {
    return "X".repeat(2 * i + 1);
  }

  private String centerStrings(List<String> elements) {
    return elements.stream().map(this::center).collect(Collectors.joining("\n"));
  }

  private String center(String s) {
    String filler = getFiller(s.length());
    return filler + s + filler;
  }

  private String getFiller(int stringLength) {
    int fillSize = (tree.getWidth() - stringLength) / 2;
    return " ".repeat(fillSize);
  }

  private List<String> getStamm() {
    return IntStream.range(0, getStammHeight())
        .mapToObj(e -> "I".repeat(getStammWidth())).collect(Collectors.toList());
  }

  private int getStammWidth() {
    return getMaxWithOne(tree.getWidth() / 6);
  }

  private int getStammHeight() {
    return getMaxWithOne(tree.getHeight() / 10);
  }

  private int getMaxWithOne(int value) {
    return Math.max(1, value);
  }
}
