# Đóng gói thư viện Java
Hai dự án Maven độc lập, Java 17:
- math-lib: com.codegym.Calculator, sum/sub/mul/divide nhận hai int và trả int. divide ném java.security.NoSuchAlgorithmException khi b=0 theo đúng đề.
- calculator-app: gọi Calculator từ file lib/math-lib.jar; dependency system theo yêu cầu bài, không chép Calculator.java sang ứng dụng.

## Build và chạy trên Windows PowerShell
```powershell
mvn -f math-lib/pom.xml clean package
Copy-Item math-lib/target/math-lib-1.0-SNAPSHOT.jar calculator-app/lib/math-lib.jar
mvn -f calculator-app/pom.xml clean package
Set-Location calculator-app
java -cp "target/classes;lib/math-lib.jar" com.codegym.Main
java -cp "target/classes;lib/math-lib.jar" com.codegym.Main --test-zero
```
Linux/macOS dùng dấu : thay cho ; trong classpath. File JAR đã được kèm ở calculator-app/lib/math-lib.jar để clone và build ứng dụng trực tiếp.

Kết quả: 14, -4, 45, 2. Chạy --test-zero hiển thị thông báo Không thể chia cho 0. Phép chia int nên 5/2 là 2. Maven có thể cảnh báo systemPath trong dự án; bài cố tình dùng cách nhúng JAR này theo đề. Trong dự án thực tế thường dùng repository Maven.