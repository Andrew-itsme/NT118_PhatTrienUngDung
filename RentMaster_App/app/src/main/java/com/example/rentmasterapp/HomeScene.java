package com.example.rentmasterapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
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

    RecyclerView rlvroom;
    ImageButton btnUser, btnHome, btnMenu;
    Button btnadd;
    List<Room> roomList = new ArrayList<>();
    //ArrayList<item_room> arrayList = new ArrayList<item_room>();
    RoomAdapter adapter = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rlvroom = (RecyclerView) findViewById(R.id.rlvRoom);
        btnUser = (ImageButton) findViewById(R.id.btn_user);
        btnHome = (ImageButton) findViewById(R.id.btn_home);
        btnMenu = (ImageButton) findViewById(R.id.btn_menu);
        btnadd = (Button) findViewById(R.id.btnAdd);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUser = new Intent(HomeScene.this, UserScene.class);
                startActivity(intentUser);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScene.this, MenuScene.class);
                startActivity(intent);
            }
        });
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
                builder.setView(viewInflated);
                AlertDialog dialog = builder.create();
                // Tạo các trường để điền thông tin
                final EditText edRoom = (EditText) viewInflated.findViewById(R.id.ed_room);
                final EditText edName = (EditText) viewInflated.findViewById(R.id.ed_name);
                final EditText edDayOfHare = (EditText) viewInflated.findViewById(R.id.ed_dayOfhare);
                final Button btnAdd = (Button) viewInflated.findViewById((R.id.btn_add_dialog));
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String room = edRoom.getText().toString();
                        String name = edName.getText().toString();
                        String dayOfHare = edDayOfHare.getText().toString();
                        importProcessing(room, name, dayOfHare);
                        dialog.dismiss();
                    }
                    @SuppressLint("NotifyDataSetChanged")
                    private void importProcessing(String room, String name, String dayOfHare)
                    {
                        Room roomlist = new Room();
                        roomlist.setRoomNumber(room);
                        roomlist.setRoomMaster(name);
                        roomlist.setDayofHare(dayOfHare);
                        roomList.add(roomlist);
                        adapter.notifyDataSetChanged();
                    }
                });

                dialog.show();
            }
        });


    }


}
