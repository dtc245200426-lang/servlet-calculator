package com.codegym;
public final class Calculator {
    private Calculator() {}
    public static double calculate(double first, double second, String operator) {
        double result = switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> {
                if (second == 0) throw new ArithmeticException("Không thể chia cho 0.");
                yield first / second;
            }
            default -> throw new IllegalArgumentException("Toán tử không hợp lệ.");
        };
        if (!Double.isFinite(result)) throw new ArithmeticException("Kết quả vượt phạm vi tính toán.");
        return result;
    }
}
