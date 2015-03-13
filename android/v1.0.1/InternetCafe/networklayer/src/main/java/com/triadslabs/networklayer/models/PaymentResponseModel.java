package com.triadslabs.networklayer.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
    public class PaymentResponseModel extends BaseModel implements Parcelable {

        @SerializedName("Message")
        private String message;

        @SerializedName("transactionNo")
        private String transactionNo;

        @SerializedName("Status")
        private double status;


        public PaymentResponseModel () {

        }

        public PaymentResponseModel (JSONObject json) {

            this.message = json.optString("Message");
            this.transactionNo = json.optString("transactionNo");
            this.status = json.optDouble("Status");

        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTransactionNo() {
            return this.transactionNo;
        }

        public void setTransactionNo(String transactionNo) {
            this.transactionNo = transactionNo;
        }

        public double getStatus() {
            return this.status;
        }

        public void setStatus(double status) {
            this.status = status;
        }

        protected PaymentResponseModel(Parcel in) {
            super(in);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
        }

        public static final Parcelable.Creator<PaymentResponseModel> CREATOR = new Parcelable.Creator<PaymentResponseModel>() {
            @Override
            public PaymentResponseModel createFromParcel(Parcel in) {
                return new PaymentResponseModel(in);
            }

            @Override
            public PaymentResponseModel[] newArray(int size) {
                return new PaymentResponseModel[size];
            }
        };
}
