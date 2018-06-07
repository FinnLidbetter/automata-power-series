public class Polynomial {
  public final int fieldOrder;
  public final int degree;
  public int[] terms;
  public Polynomial(int fieldOrder, int degree, int ... coefficients) {
    this.fieldOrder = fieldOrder;
    this.degree = degree;
    int index = 0;
    terms = new int[degree+1];
    for (int c:coefficients) {
      if (index>=terms.length) {
        System.err.println("Error: too many coefficients provided in polynomial construction");
      }
      terms[index] = c%fieldOrder;
      index++;
    }
  }
}
