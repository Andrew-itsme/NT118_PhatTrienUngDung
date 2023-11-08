package com.example.rentmasterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {
    private List<Room> roomList;
    private Context context;
    RoomAdapter(Context context, List<Room> roomList){
        this.roomList = roomList;
        this.context = context;
    }
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, int position) {
        Room room = roomList.get(position);
        TextView tv_Room = holder.itemView.findViewById(R.id.txt_nameRoom);
        TextView tv_RoomMaster = holder.itemView.findViewById(R.id.txt_roomMaster);
        TextView tv_DayOfHare = holder.itemView.findViewById(R.id.txt_dateOfHire);
        holder.bind(room);

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoom, tvRoomMaster, tvDayOfHare;
        public ViewHolder(View itemView){
            super(itemView);
            tvRoom = itemView.findViewById(R.id.txt_nameRoom);
            tvRoomMaster = itemView.findViewById(R.id.txt_roomMaster);
            tvDayOfHare = itemView.findViewById(R.id.txt_dateOfHire);
        }
        public void bind (Room room){
            if(room.getRoomNumber() != null){
                tvRoom.setText("Số phòng: " +room.getRoomNumber());
            }
            if(room.getRoomMaster() != null){
                tvRoomMaster.setText("Người thuê: "+ room.getRoomMaster());
            }
            if(room.getDayofHare() != null){
                tvDayOfHare.setText("Thời gian thuê: " + room.getDayofHare());
            }
        }

    }
}