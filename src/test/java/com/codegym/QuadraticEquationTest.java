package com.codegym;
import org.junit.Test;
import static org.junit.Assert.*;
public class QuadraticEquationTest {
 @Test public void twoRoots(){assertArrayEquals(new double[]{1,2},QuadraticEquation.solve(1,-3,2).roots(),1e-12);}
 @Test public void repeatedRoot(){var r=QuadraticEquation.solve(1,2,1);assertEquals(QuadraticEquation.Type.ONE_ROOT,r.type());assertArrayEquals(new double[]{-1},r.roots(),1e-12);}
 @Test public void noRealRoots(){assertEquals(QuadraticEquation.Type.NO_REAL_ROOTS,QuadraticEquation.solve(1,0,1).type());}
 @Test public void linear(){assertArrayEquals(new double[]{2},QuadraticEquation.solve(0,2,-4).roots(),1e-12);}
 @Test public void infinite(){assertEquals(QuadraticEquation.Type.INFINITE_ROOTS,QuadraticEquation.solve(0,0,0).type());}
 @Test public void impossibleConstant(){assertEquals(QuadraticEquation.Type.NO_REAL_ROOTS,QuadraticEquation.solve(0,0,1).type());}
 @Test public void zeroConstant(){assertArrayEquals(new double[]{0,2},QuadraticEquation.solve(1,-2,0).roots(),1e-12);}
 @Test public void negativeA(){assertArrayEquals(new double[]{1,2},QuadraticEquation.solve(-1,3,-2).roots(),1e-12);}
 @Test public void largeCoefficients(){assertArrayEquals(new double[]{1,2},QuadraticEquation.solve(1e200,-3e200,2e200).roots(),1e-12);}
 @Test(expected=IllegalArgumentException.class) public void rejectsNaN(){QuadraticEquation.solve(Double.NaN,1,1);}
 @Test public void resultIsDefensive(){var r=QuadraticEquation.solve(1,-3,2);r.roots()[0]=42;assertEquals(1,r.roots()[0],1e-12);}
}