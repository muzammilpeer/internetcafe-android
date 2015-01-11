package com.triadslabs.internetcafe.model;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardItem extends BaseItem {

    private String roomNo,clientName,accessories,checkIn,amount,checkOut;

    public DashboardItem(String roomNo, String clientName, String accessories, String checkIn, String amount, String checkOut) {
        this.roomNo = roomNo;
        this.clientName = clientName;
        this.accessories = accessories;
        this.checkIn = checkIn;
        this.amount = amount;
        this.checkOut = checkOut;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
