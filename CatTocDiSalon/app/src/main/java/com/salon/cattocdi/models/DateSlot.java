package com.salon.cattocdi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateSlot implements Serializable{
    @SerializedName("date")
    private String dateStr;
    @SerializedName("slots")
    private List<Slot> slots;
    private Date slotDate;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Date getSlotDate() {
        String value = dateStr.replace("T"," ");
        try {
            slotDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    public class Slot implements Serializable{
        @SerializedName("Id")
        private int id;
        @SerializedName("SalonId")
        private int salonId;
        @SerializedName("SlotDate")
        private String slotDate;
        @SerializedName("Time")
        private String time;
        @SerializedName("Capacity")
        private int capacity;
        @SerializedName("Index")
        private int index;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSalonId() {
            return salonId;
        }

        public void setSalonId(int salonId) {
            this.salonId = salonId;
        }

        public String getSlotDate() {
            return slotDate;
        }

        public void setSlotDate(String slotDate) {
            this.slotDate = slotDate;
        }

        public String getTime() {
            return time;
        }

        public String getTimeSlotStr(){
            try {
                Timestamp timestamp =  new Timestamp(new SimpleDateFormat("hh:mm:ss").parse(time).getTime());
                return new SimpleDateFormat("hh:mm").format(timestamp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return "";
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
