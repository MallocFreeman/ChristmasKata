public class Main {

  public static void main(String[] args) {
    Tannenbaum ohhTannenbaum = new Tannenbaum(101);
    TannenbaumStringifier stringifier = new TannenbaumStringifier(ohhTannenbaum, true);
    System.out.println(stringifier.stringify());
  }
}
