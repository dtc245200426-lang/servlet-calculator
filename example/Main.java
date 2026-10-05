import com.codegym.QuadraticEquation;
import java.util.Arrays;
public class Main {
 public static void main(String[] args) {
  var result=QuadraticEquation.solve(1,-3,2);
  System.out.println(result.type()+": "+Arrays.toString(result.roots()));
 }
}