package com.salon.cattocdi.models.enums;

public enum AppointmentStatus {
    NOT_APPROVED(0),
    APPROVED(1),
    USER_CANCEL(2),
    SALON_CANCEL(3);

    private int status;

    AppointmentStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
