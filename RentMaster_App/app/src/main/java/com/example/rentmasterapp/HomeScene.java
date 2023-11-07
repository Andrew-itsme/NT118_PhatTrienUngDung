package com.example.rentmasterapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeScene extends AppCompatActivity {
    Button tvLogout;
    RecyclerView rlvroom;
    ImageButton user, rise, setting;
    Button btnadd;
    List<Room> roomList = new ArrayList<>();
    ArrayList<item_room> arrayList = new ArrayList<item_room>();
    RoomAdapter adapter = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvLogout = ( Button) findViewById(R.id.tvLogout);
        rlvroom = (RecyclerView) findViewById(R.id.rlvRoom);
        user = (ImageButton) findViewById(R.id.userInfor);
        rise = (ImageButton) findViewById(R.id.riseInfor);
        setting = (ImageButton) findViewById(R.id.settingInfor);
        btnadd = (Button) findViewById(R.id.btnAdd);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rlvroom.setLayoutManager(layoutManager);
        adapter = new RoomAdapter(this,roomList);
        rlvroom.setAdapter(adapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeScene.this);
                builder.setTitle("Thêm phòng mới");
                // Thiết lập giao diện của hộp thoại cảnh báo
                View viewInflated = LayoutInflater.from(HomeScene.this).inflate(R.layout.add_room_dialog, (ViewGroup) view.getParent(), false);
                // Tạo các trường để điền thông tin
                final EditText edRoom = (EditText) viewInflated.findViewById(R.id.ed_room);
                final EditText edName = (EditText) viewInflated.findViewById(R.id.ed_name);
                final EditText edDayOfHare = (EditText) viewInflated.findViewById(R.id.ed_dayOfhare);
                builder.setView(viewInflated);

                // Thiết lập nút "Thêm" trong hộp thoại cảnh báo
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Lấy thông tin từ trường nhập và thực hiện hành động cần thiết
                        String room = edName.getText().toString();
                        String name = edName.getText().toString();
                        String dayOfHare = edDayOfHare.getText().toString();
                        // Thực hiện hành động thêm thông tin vào danh sách hoặc cơ sở dữ liệu
                    }
                });

                // Thiết lập nút "Hủy" trong hộp thoại cảnh báo
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); // Đóng hộp thoại cảnh báo
                    }
                });

                builder.show(); // Hiển thị hộp thoại cảnh báo
            }
        });
    }

    private void importProcessing()
    {

    }
}
