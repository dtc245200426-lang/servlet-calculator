# Calculator - Servlet và JSP

Java 17, Maven WAR, Jakarta Servlet 6.0 và Tomcat 10.1.

- index.jsp nhập hai toán hạng và chọn cộng, trừ, nhân, chia; gửi POST tới /calculate.
- Calculator.calculate() thực hiện phép toán; chia cho 0 tung ArithmeticException.
- CalculatorServlet dùng try/catch hiển thị kết quả hoặc thông báo lỗi.
- Chặn dữ liệu trống, NaN, Infinity và toán tử không hợp lệ.

## Chạy

1. `mvn clean package`
2. Copy target/servlet-calculator.war vào webapps của Tomcat 10.1, khởi động server.
3. Mở http://localhost:8080/servlet-calculator/.

Ví dụ: 6 + 3 = 9; 6 − 3 = 3; 6 × 3 = 18; 6 ÷ 3 = 2; 6 ÷ 0 báo lỗi.
