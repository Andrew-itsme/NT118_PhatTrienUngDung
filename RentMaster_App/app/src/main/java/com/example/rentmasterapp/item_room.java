package com.example.rentmasterapp;

public class item_room {
    private static String roomName;
    private static String roomMasterName;
    private static String dateOfHare;
    public static String getRoomName(){ return roomName;}
    public void setRoomName(String roomName){ this.roomName =roomName;}
    public static String getRoomMasterName(){ return roomMasterName;}
    public void setRoomMasterName(String roomMasterName){this.roomMasterName = roomMasterName;}
    public static String getDateOfHare(){ return dateOfHare;}
    public void setDateOfHare(String dateOfHare){ this.dateOfHare = dateOfHare;}
    @Override
    public String toString(){
        return this.roomName + "" + this.roomMasterName + "" + this.dateOfHare;
}


}