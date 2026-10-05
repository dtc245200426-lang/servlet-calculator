package com.codegym;
/** Solves a*x*x + b*x + c = 0 over the real numbers. */
public final class QuadraticEquation {
 private QuadraticEquation() {}
 public enum Type { TWO_ROOTS, ONE_ROOT, NO_REAL_ROOTS, INFINITE_ROOTS }
 public record Result(Type type, double[] roots) {
  public Result { roots=roots.clone(); }
  @Override public double[] roots(){return roots.clone();}
 }
 public static Result solve(double a,double b,double c) {
  if(!Double.isFinite(a)||!Double.isFinite(b)||!Double.isFinite(c))
   throw new IllegalArgumentException("Coefficients must be finite");
  if(a==0) {
   if(b==0)return new Result(c==0?Type.INFINITE_ROOTS:Type.NO_REAL_ROOTS,new double[0]);
   return new Result(Type.ONE_ROOT,new double[]{-c/b});
  }
  // Scale coefficients to reduce overflow in b*b and 4*a*c.
  double scale=Math.max(Math.abs(a),Math.max(Math.abs(b),Math.abs(c)));
  double aa=a/scale,bb=b/scale,cc=c/scale;
  if(aa==0)throw new IllegalArgumentException("Coefficient range exceeds double precision");
  double discriminant=bb*bb-4*aa*cc;
  if(discriminant<0)return new Result(Type.NO_REAL_ROOTS,new double[0]);
  if(discriminant==0)return new Result(Type.ONE_ROOT,new double[]{-bb/(2*aa)});
  // Stable formula avoids cancellation when b is large compared with a and c.
  double q=-0.5*(bb+Math.copySign(Math.sqrt(discriminant),bb));
  double first=q/aa,second=cc/q;
  return new Result(Type.TWO_ROOTS,new double[]{Math.min(first,second),Math.max(first,second)});
 }
}