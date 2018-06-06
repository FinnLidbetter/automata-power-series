import java.io.*;
public class Driver {
  public static void main(String[] args) {
    try {
      DfaReader dfar = new DfaReader(System.in);
      Dfa test = dfar.buildDfaFromGrail();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (String line:args) {
        if (test.accepts(line)) {
          System.out.println(line+" is accepted");
        } else {
          System.out.println(line+" is rejected");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
