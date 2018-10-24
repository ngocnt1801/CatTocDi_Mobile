package com.salon.cattocdi.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.salon.cattocdi.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class FragementAppointmentTestAdapter extends RecyclerView.Adapter<FragementAppointmentTestAdapter.AppointmentCardViewHolder> {
    Context context;
    Location curLocation;
    private int count = 5;

    public FragementAppointmentTestAdapter(Context context, Location curLocation) {
        this.context = context;
        this.curLocation = curLocation;
    }

    public FragementAppointmentTestAdapter() {
    }


    @NonNull
    @Override
    public AppointmentCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_my_appointment, viewGroup, false);

        return new AppointmentCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppointmentCardViewHolder viewHolder, final int i) {


        //        viewHolder.tvName.setText("Salon " + i);
//        viewHolder.tvAddress.setText("abc " + i + i + i);
//        viewHolder.tvServices.setText("Cắt, uống, nhuộm");
//        viewHolder.tvTime.setText("Thứ 2 1/10/2018, 3:00PM");
//        viewHolder.tvStylist.setText("Tran Van A");

//        viewHolder.btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        viewHolder.img.setImageResource(MyContants.SALON_IMAGE_IDS[i]);

        if (i >= 2) {
            viewHolder.tvDate.setText("25/10/2018");
        }
        if (i == 0) {
            viewHolder.appointmentDetail.expand();
            activeAppointment(viewHolder);
        }
        if (i == 4) {
            viewHolder.tvDate.setText("10/10/2018");
            viewHolder.tvAppoinmentType.setText("Cuộc hẹn đã qua");
            viewHolder.appointmentRl.setBackgroundColor(Color.parseColor("#eeeeee"));
        }


        viewHolder.appointmentRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.appointmentDetail.toggle();
                if (viewHolder.appointmentDetail.isExpanded()) {
                    activeAppointment(viewHolder);
                } else {
                    inactiveAppointment(viewHolder);
                }
            }
        });
        viewHolder.directionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curLocation != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr="
                                    + Double.toString(curLocation.getLatitude())
                                    + "," + Double.toString(curLocation.getLongitude()) + "&daddr=10.7483033,106.6090311"));
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Hãy bật vị trí để chúng tôi có thể chỉ đường cho bạn!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        viewHolder.icDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context); // Context, this, etc.
                if (i == 2 || i == 3) {
                    TextView btnOk;
                    dialog.setContentView(R.layout.dialog_appointment_late);
                    dialog.setTitle(R.string.dialog_title);
                    btnOk = dialog.findViewById(R.id.dialog_ok);
                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

//                    AlertDialog alertDialog = new AlertDialog.Builder(context).create();
//                    alertDialog.setTitle("Không thể hủy");
//                    alertDialog.setMessage(context.getResources().getString(R.string.dialog_text_late));
//                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialog.dismiss();
//                        }
//                    });
//                    dialog.show();
                }
                if (i == 4) {
                    TextView tvText;
                    dialog.setContentView(R.layout.dialog_appointment);
                    tvText = dialog.findViewById(R.id.dialog_info);
                    tvText.setText(R.string.dialog_text_expired);

                    Button btnCancel = dialog.findViewById(R.id.dialog_cancel);
                    Button btnOk = dialog.findViewById(R.id.dialog_ok);

                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                }
                if (i == 0 || i == 1) {
                    dialog.setContentView(R.layout.dialog_appointment);
                    dialog.setTitle(R.string.dialog_title);

                    Button btnCancel = dialog.findViewById(R.id.dialog_cancel);
                    Button btnOk = dialog.findViewById(R.id.dialog_ok);

                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class AppointmentCardViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvAddress, tvServices, tvStylist, tvTime;
        public ImageView img, icExpand;
        public Button btnCancel;
        public View item;
        public CardView icMap;
        public RelativeLayout appointmentRl;
        public ExpandableLayout appointmentDetail;
        public Button directionBtn;
        public ImageView icDelete;

        public TextView tvAppoinmentType, tvDate, tvSalonName, tvStartTime, tvDot, tvEndTime;

        public AppointmentCardViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvName = itemView.findViewById(R.id.fg_appointment_name_tv);
//            tvAddress = itemView.findViewById(R.id.fg_appointment_address_tv);
//            tvServices = itemView.findViewById(R.id.fg_appointment_services_tv);
//            tvStylist = itemView.findViewById(R.id.fg_appointment_stylist_tv);
//            tvTime = itemView.findViewById(R.id.fg_appointment_time_tv);
//            img = itemView.findViewById(R.id.appointment_item_excpand_image_cirle);
//            btnCancel = itemView.findViewById(R.id.fg_appointment_cancel_btn);
            appointmentRl = itemView.findViewById(R.id.fg_appointment_rv_item_rl);
            appointmentDetail = itemView.findViewById(R.id.expandable_layout);
            icExpand = itemView.findViewById(R.id.fg_appointment_expand_ic);

            tvAppoinmentType = itemView.findViewById(R.id.fg_appointment_upcomming_tv);
            tvDate = itemView.findViewById(R.id.fg_appointment_date_tv);
            tvSalonName = itemView.findViewById(R.id.fg_appointment_salon_name);
            tvStartTime = itemView.findViewById(R.id.fg_appointment_start_time);
            tvDot = itemView.findViewById(R.id.fg_appointment_dot_tv);
            tvEndTime = itemView.findViewById(R.id.fg_appointment_end_time);
            directionBtn = itemView.findViewById(R.id.btnDirection);
            icDelete = itemView.findViewById(R.id.rc_appointment_ic_delete);
            item = itemView;

        }

    }

    public void activeAppointment(AppointmentCardViewHolder itemView) {
//        itemView.appointmentRl.setBackgroundResource(R.color.icLogin);
//        itemView.tvAppoinmentType.setTextColor(Color.parseColor("#ffffff"));
//        itemView.tvAppoinmentType.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_calendar_white, 0,0,0);
//        itemView.tvSalonName.setTextColor(Color.parseColor("#ffffff"));
//        itemView.tvDate.setTextColor(Color.parseColor("#ffffff"));
//        itemView.tvStartTime.setTextColor(Color.parseColor("#ffffff"));
//        itemView.tvDot.setTextColor(Color.parseColor("#ffffff"));
//        itemView.tvEndTime.setTextColor(Color.parseColor("#ffffff"));
        itemView.icExpand.setImageResource(R.drawable.ic_collapse);
    }

    public void inactiveAppointment(AppointmentCardViewHolder itemView) {
//        itemView.appointmentRl.setBackgroundResource(0);
//        itemView.tvAppoinmentType.setTextColor(Color.parseColor("#6b5b95"));
//        itemView.tvAppoinmentType.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_calendar_active, 0,0,0);
//        itemView.tvSalonName.setTextColor(Color.parseColor("#000000"));
//        itemView.tvDate.setTextColor(Color.parseColor("#000000"));
//        itemView.tvStartTime.setTextColor(Color.parseColor("#000000"));
//        itemView.tvDot.setTextColor(Color.parseColor("#000000"));
//        itemView.tvEndTime.setTextColor(Color.parseColor("#000000"));
        itemView.icExpand.setImageResource(R.drawable.ic_expand);
    }

}
