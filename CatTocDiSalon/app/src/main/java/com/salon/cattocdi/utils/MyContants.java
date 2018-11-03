package com.salon.cattocdi.utils;

import com.salon.cattocdi.R;
import com.salon.cattocdi.models.Appointment;
import com.salon.cattocdi.models.Category;
import com.salon.cattocdi.models.Comment;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.models.Service;
import com.salon.cattocdi.models.enums.AppointmentStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class MyContants {
    public static final String BASE_URL = "192.168.2.192/cattocdi.api";
    public static final String PHONE_TEST = "0123456789";
    public static final String PASSWORD_TEST = "123";
    public static final int RV_ITEM_VOUCHER = 1;
    public static final int RV_ITEM_NEW = 2;
    public static final int RV_ITEM_NORMAL = 3;
    public static final int SERVICE_ADD = 1;
    public static final int SERVICE_CHECKBOX = 2;
    public static final int[] SALON_IMAGE_IDS = {
            R.drawable.salon1,
            R.drawable.salon2,
            R.drawable.salon3,
            R.drawable.salon4,
            R.drawable.salon5,
            R.drawable.salon6,
            R.drawable.salon7,
            R.drawable.salon8,
            R.drawable.salon9,
            R.drawable.salon10,

    };
    public static final int[] SALON_MODELS_IDS = {
            R.drawable.salon_model_1,
            R.drawable.salon_model_2,
            R.drawable.salon_model_3,
            R.drawable.salon_model_4,
            R.drawable.salon_model_5,
            R.drawable.salon_model_6,
            R.drawable.salon_model_7,
    };


    public static final Service[] SERVICES_1 = {
            new Service(1, "Cắt tóc nam", 30000, 15),
            new Service(2, "Cắt tóc nữ", 100000, 30),
    };

    public static final Service[] SERVICES_2 = {
            new Service(3, "Nhuộm tóc nam", 150000, 60),
            new Service(4, "Nhuộm tóc nữ", 400000, 120),
            new Service(5, "Phủ bóng", 250000, 90),
            new Service(6, "Nhuộm Henna", 280000, 120),
            new Service(7, "Móc Light", 200000, 60),
    };

    public static final Service[] SERVICES_3 = {
            new Service(8, "Uốn tóc (Lạnh)", 300000, 120),
            new Service(9, "Uốn tóc (Nóng)", 300000, 120),
            new Service(10, "Duỗi tóc", 250000, 90),
            new Service(11, "Uốn 1 điểm trên tóc", 450000, 120),
            new Service(12, "Duỗi 1 điểm trên tóc", 450000, 120),
    };

    public static final Service[] SERVICES_4 = {
            new Service(13, "Rửa mặt", 20000, 15),
            new Service(14, "Tỉa chân mày", 50000, 35),
            new Service(15, "Cạo râu", 15000, 15),
            new Service(16, "Ráy tai", 15000, 15),
            new Service(17, "Gội đầu", 10000, 15),

    };

    public static final Category[] CATEGORIES = {
            new Category(1, "Cắt tóc", toList(SERVICES_1)),
            new Category(2, "Nhuộm màu", toList(SERVICES_2)),
            new Category(3, "Uốn và duỗi", toList(SERVICES_3)),
            new Category(4, "Dịch vụ khác", toList(SERVICES_4)),

    };

    public static final Salon[] SALONS = {
            new Salon("Beautiful Hair", 4.8f, false, 40, toList(CATEGORIES),10.858228, 106.629373, "12 Dương Thị Mười, Q.12", 60, "0123456789", "beautifulhair@gmail.com"),
            new Salon("Hair Style", 4.8f, false, 30, toList(CATEGORIES),10.855226, 106.624505, "246 Tô Kí, Q.12", 45,"0123456789","hairstyle@gmail.com"),
            new Salon("Nhung", 4.6f, false, 50, toList(CATEGORIES),10.850321, 106.623503, "54/2A Lê Thị Nho, Q.12", 48,"0123456789","nhungsalon@gmail.com"),
            new Salon("Phước An", 4.5f, true, 40, toList(CATEGORIES), 10.849307, 106.626485, "B477 Tổ 1 Kp3", 52,"0123456789","phuocan@gmail.com"),
            new Salon("Thảo Tây", 4.2f, false, 50, toList(CATEGORIES), 10.850826, 106.631089, "A119/3 Tổ 16 Kp2, Q.12", 38, "0123456789", "thaotay@gmail.com"),
            new Salon("Quốc An", 4.2f, false, 30, toList(CATEGORIES), 10.855239, 106.633389, "28/4 Tổ 1 KP1, Q.12",35,"0123456789","quocan@gmail.com"),
            new Salon("Tây Hòa", 4f, true, 30, toList(CATEGORIES), 10.851772, 106.634312, "Hẻm 230 Quốc lộ 1A, Q.12",20,"0123456789","tayhoa@gmail.com")
    };

    public static final Comment[] COMMENTS = {
            new Comment("Thảo Nhi", 5, new Date(2018, 10, 13), "Tuyệt vời!"),
            new Comment("Thành Phong", 4, new Date(2018, 10, 8), "Chất lượng khá tốt"),
            new Comment("Tiến Đạt", 5, new Date(2018, 9, 25), "Lần sau tui sẽ quay lại ^^"),
            new Comment("Thúy Ngọc", 5, new Date(2018, 9, 17), "Tốt!"),
    };

    public static final Service[] SERVICES_APPOINTMENT = {
            SERVICES_1[1],
            SERVICES_3[3],
            SERVICES_2[1],
            SERVICES_4[4]
    };

    public static final Appointment[] APPOINTMENTS = {
            new Appointment(SALONS[3], Timestamp.valueOf("2018-11-2 16:00:00"), Timestamp.valueOf("2018-11-2 17:00:00"), toList(SERVICES_APPOINTMENT), 40, AppointmentStatus.NOT_APPROVED),
            new Appointment(SALONS[0], Timestamp.valueOf("2018-12-5 16:00:00"), Timestamp.valueOf("2018-12-5 17:00:00"), toList(SERVICES_APPOINTMENT), 30, AppointmentStatus.NOT_APPROVED),
            new Appointment(SALONS[5], Timestamp.valueOf("2018-10-20 9:00:00"), Timestamp.valueOf("2018-10-20 10:30:00"), toList(SERVICES_APPOINTMENT), 25, AppointmentStatus.APPROVED),

    };



    public static <T> ArrayList<T> toList(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        for (T item :
                array) {
            list.add(item);
        }
        return list;
    }





}
