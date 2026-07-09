# Hướng dẫn chạy dự án Tic-Tac-Toe (Bản Java Web App)

Dự án này đã được hoàn thiện đúng chuẩn cấu trúc **Java Web Application** (Servlet 3.0 / Jakarta EE) và có giao diện đồ họa siêu đẹp. 

Để chạy thử (Test) hoặc chấm điểm dự án, bạn hãy làm theo các bước chuẩn sau đây:

### Bước 1: Đóng gói dự án ra file nộp bài (.war)
> **Lưu ý:** Bất cứ khi nào bạn có chỉnh sửa thêm code bên trong (cả file Java lẫn file HTML), bạn bắt buộc phải thực hiện lại bước này để cập nhật bản build mới.

1. Mở cửa sổ Terminal (hoặc Command Prompt).
2. Di chuyển vào thư mục `tttbasic` (nơi có chứa file `pom.xml`):
   ```bash
   cd C:\SS2026\PE\10423143week14\10423143week14\tttbasic
   ```
3. Chạy lệnh đóng gói Maven:
   ```bash
   mvn clean package
   ```
4. Đợi đến khi có thông báo **BUILD SUCCESS**, lúc này Maven đã tạo ra file **`10423143ttt.war`** nằm gọn trong thư mục `tttbasic/target`.

### Bước 2: Khởi động máy chủ Apache Tomcat 11
Vì đây là Web App, dự án sẽ không chạy trực tiếp bằng lệnh IDE hay Java bình thường mà bắt buộc phải chạy qua Tomcat 11.

1. Copy file **`10423143ttt.war`** mà bạn vừa build được ở Bước 1.
2. Dán (Paste) file đó vào bên trong thư mục **`webapps`** của phần mềm Apache Tomcat 11 (ví dụ đường dẫn của bạn là: `C:\SS2026\PE\apache-tomcat-11.0.23-windows-x64\apache-tomcat-11.0.23\webapps`).
3. Truy cập vào thư mục **`bin`** của Tomcat và click đúp vào file **`startup.bat`** (Windows Batch File) để khởi động máy chủ.
   *Lưu ý: Nếu một cửa sổ màu đen của Tomcat đang mở chạy sẵn từ trước, bạn không cần phải tắt đi bật lại, Tomcat sẽ tự động cập nhật bản code mới khi bạn ném file `.war` vào.*

### Bước 3: Mở trình duyệt và trải nghiệm
Khi máy chủ Tomcat đã chạy, bạn chỉ việc:
1. Mở Google Chrome, Edge hoặc Safari.
2. Gõ địa chỉ sau để vào game:
   👉 **http://localhost:8080/10423143ttt/**
3. Bạn ấn "New Game" và tận hưởng thành quả của mình. Chúc bạn có một con điểm thật cao!
