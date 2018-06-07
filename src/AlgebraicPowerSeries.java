public class AlgebraicPowerSeries {
  public final int fieldOrder;
  public final int degree;
  private Polynomial[] polyCoefficients;
  public AlgebraicPowerSeries(int fieldOrder, int degree, Polynomial ... coefficients) {
    this.fieldOrder = fieldOrder;
    this.degree = degree;
    polyCoefficients = new Polynomial[degree+1];
    int index = 0;
    for (Polynomial p:coefficients) {
      if (index>=polyCoefficients.length) {
        System.err.println("Error: too many polynomials given in initializing Power Series");
      }
      polyCoefficients[index] = p;
      index++;
    }
  }
}
