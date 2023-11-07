package com.example.rentmasterapp;

public class Room {
    String RoomNumber;
    String RoomMaster;
    String DayofHare;
    int NumberOfPeople;
    public String getRoomNumber(){ return RoomNumber;}
    public String getRoomMaster(){ return RoomMaster;}
    public String getDayofHare(){ return DayofHare;}
    public int getNumberOfPeople(){ return NumberOfPeople;}
    public void setRoomMaster(String RoomMaster){ this.RoomMaster = RoomMaster;}
    public void setRoomNumber(String RoomNumber){ this.RoomNumber = RoomNumber;}
    public void setDayofHare(String DayOfHare){ this.DayofHare = DayOfHare;}
    public void setNumberOfPeople(int NumberOfPeople){ this.NumberOfPeople = NumberOfPeople;}
    @Override
    public String toString(){
    return this.RoomMaster;
}
}
