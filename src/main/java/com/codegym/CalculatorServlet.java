package com.codegym;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="CalculatorServlet", urlPatterns="/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String content;
        try {
            double first = number(request.getParameter("firstOperand"));
            double second = number(request.getParameter("secondOperand"));
            String operator = request.getParameter("operator");
            if (operator == null) throw new IllegalArgumentException("Vui lòng chọn toán tử.");
            double result = Calculator.calculate(first, second, operator);
            content = "<h1>Kết quả</h1><p>" + first + " " + operator + " " + second + " = <strong>" + result + "</strong></p>";
        } catch (NumberFormatException ex) {
            response.setStatus(400);
            content = "<h1>Lỗi</h1><p>Vui lòng nhập hai số hợp lệ.</p>";
        } catch (ArithmeticException | IllegalArgumentException ex) {
            response.setStatus(400);
            content = "<h1>Lỗi</h1><p>" + ex.getMessage() + "</p>";
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='vi'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1'><title>Calculator Result</title></head><body>");
            out.println(content);
            out.println("<a href='index.jsp'>Quay lại máy tính</a></body></html>");
        }
    }
    private static double number(String value) {
        if (value == null || value.isBlank() || value.length() > 100) throw new NumberFormatException();
        double number = Double.parseDouble(value.trim());
        if (!Double.isFinite(number)) throw new NumberFormatException();
        return number;
    }
}
