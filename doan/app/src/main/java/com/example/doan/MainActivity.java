package com.example.doan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> danhSachThueNha = new ArrayList<>();
    private EditText editTextName, editTextPhone, editTextStartDate, editTextNumberOfPeople, editTextPaymentStatus, editTextRoomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Thay "your_layout" bằng tên layout của bạn

        // Ánh xạ các trường EditText
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextNumberOfPeople = findViewById(R.id.editTextNumberOfPeople);
        editTextPaymentStatus = findViewById(R.id.editTextPaymentStatus);
        editTextRoomNumber = findViewById(R.id.editTextRoomNumber);

        Button buttonAdd = findViewById(R.id.button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị từ các trường EditText
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String startDate = editTextStartDate.getText().toString();
                String numberOfPeople = editTextNumberOfPeople.getText().toString();
                String paymentStatus = editTextPaymentStatus.getText().toString();
                String roomNumber = editTextRoomNumber.getText().toString();

                // Kiểm tra xem có dữ liệu được nhập không trước khi thêm vào mảng
                if (!name.isEmpty() && !phone.isEmpty() && !startDate.isEmpty() && !numberOfPeople.isEmpty() && !paymentStatus.isEmpty() && !roomNumber.isEmpty()) {
                    // Thêm dữ liệu vào mảng
                    danhSachThueNha.add("Tên: " + name + ", Số điện thoại: " + phone + ", Ngày thuê: " + startDate + ", Số người: " + numberOfPeople + ", Tình trạng đóng tiền: " + paymentStatus + ", Số phòng: " + roomNumber);

                    // Sau khi thêm vào mảng, bạn có thể xử lý dữ liệu hoặc hiển thị thông báo thành công tùy theo nhu cầu của bạn
                }
            }
        });
        Button buttonXoa = findViewById(R.id.button2);
        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy tên từ trường EditText
                String tenCanXoa = editTextName.getText().toString();

                // Kiểm tra xem tên có được nhập không
                if (!tenCanXoa.isEmpty()) {
                    // Duyệt qua mảng và xóa phần tử nếu tên trùng khớp
                    for (int i = 0; i < danhSachThueNha.size(); i++) {
                        String thongTin = danhSachThueNha.get(i);
                        // Phân tách thông tin để lấy tên (giả sử tên được lưu ở vị trí đầu tiên trong chuỗi)
                        String[] thongTinArr = thongTin.split(",");
                        String tenTrongMang = thongTinArr[0].substring(thongTinArr[0].indexOf(":") + 2);

                        // So sánh tên và xóa phần tử nếu tên trùng khớp
                        if (tenTrongMang.trim().equals(tenCanXoa.trim())) {
                            danhSachThueNha.remove(i);
                            // Có thể hiển thị thông báo hoặc cập nhật giao diện người dùng ở đây (tùy theo nhu cầu của bạn)
                            break; // Kết thúc vòng lặp sau khi xóa phần tử
                        }
                    }
                }
            }
        });

    }
}