# Thư viện giải phương trình bậc 2
Thư viện Java 17: com.codegym.QuadraticEquation.solve(a,b,c), giải ax² + bx + c = 0 trong tập số thực.

Result có type và roots(): TWO_ROOTS (hai nghiệm tăng dần), ONE_ROOT (nghiệm kép hoặc phương trình bậc nhất), NO_REAL_ROOTS, INFINITE_ROOTS. Khi a=0 chuyển sang phương trình bậc nhất; hệ số NaN/Infinity bị từ chối. Chuẩn hóa hệ số và công thức q giảm tràn số/mất chính xác; kết quả là xấp xỉ double, không phải phép tính ký hiệu. Miền hệ số vượt khả năng chuẩn hóa double bị từ chối.

## Đóng gói
```powershell
mvn clean package
Copy-Item target/quadratic-equation-1.0-SNAPSHOT.jar dist/quadratic-equation.jar
```
File JAR có sẵn trong dist/. Mã kiểm thử không được đóng gói vào JAR.

## Nhúng và chạy ví dụ riêng (Windows)
```powershell
javac -cp dist/quadratic-equation.jar example/Main.java
java -cp "example;dist/quadratic-equation.jar" Main
```
Linux/macOS đổi dấu ; thành :. Kết quả TWO_ROOTS với nghiệm xấp xỉ 1 và 2 (có sai số double). Có thể thêm JAR vào classpath của dự án khác và import com.codegym.QuadraticEquation.

mvn test kiểm tra hai nghiệm, nghiệm kép, vô nghiệm thực, bậc nhất, vô số nghiệm, phương trình hằng vô nghiệm, c=0, a âm, hệ số lớn, NaN và bảo vệ mảng kết quả.