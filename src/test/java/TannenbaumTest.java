import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TannenbaumTest {

  @Test
  public void height_zero_is_empty_tree() {
    String tree = createSUT(0).stringify();
    Assertions.assertEquals("I", tree);
  }

  @Test
  public void height_one_is_printed_correct() {
    String tree = createSUT(1).stringify();
    Assertions.assertEquals("X\nI", tree);
  }

  @Test
  public void height_two_is_printed_correct() {
    String tree = createSUT(2).stringify();

    Assertions.assertEquals(" X \nXXX\n I ", tree);
  }

  @Test
  public void height_three_and_more_is_printed_correct() {
    String tree = createSUT(3).stringify();

    Assertions.assertEquals("  X  \n XXX \nXXXXX\n  I  ", tree);

    tree = createSUT(4).stringify();

    Assertions.assertEquals("   X   \n  XXX  \n XXXXX \nXXXXXXX\n   I   ", tree);
  }

  @Test
  public void tree_could_be_decorated() {
    String SUT = new TannenbaumStringifier(new Tannenbaum(3), true).stringify();

    Assertions.assertEquals("  *  \n  X  \n XXX \nXXXXX\n  I  ", SUT);
  }

  private TannenbaumStringifier createSUT(int height) {
    return new TannenbaumStringifier(new Tannenbaum(height));
  }
}
