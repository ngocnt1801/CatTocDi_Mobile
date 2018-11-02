package com.salon.cattocdi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.models.Category;
import com.salon.cattocdi.models.Service;
import com.salon.cattocdi.utils.MyContants;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private int type;
    private List<SuggestServiceCardAdapter> adapterList;
    private List<Service> checkedList;


    public CategoryAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public CategoryAdapter(Context context, int type, List<Service> checkedList) {
        this.context = context;
        this.type = type;
        this.checkedList = checkedList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.salon_service_recycle_view, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, int i) {
        Category category = MyContants.CATEGORIES[i];
        holder.tvCategory.setText(category.getName());
        holder.icExpand.setImageResource(R.drawable.ic_collapse);
        holder.rvService.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        if (type == MyContants.SERVICE_ADD) {
            holder.rvService.setAdapter(new ServiceRecycleViewAdapter(context, category.getServices()));

        }else{
            SuggestServiceCardAdapter adapter = new SuggestServiceCardAdapter(category.getServices(), checkedList);
            holder.rvService.setAdapter(adapter);
            if(adapterList == null){
                adapterList = new ArrayList<>();
            }
            if(!adapterList.contains(adapter)){
                adapterList.add(adapter);
            }
        }

        holder.lnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.elService.isExpanded()) {
                    holder.elService.collapse();
                    holder.icExpand.setImageResource(R.drawable.ic_expand);
                } else {
                    holder.elService.expand();
                    holder.icExpand.setImageResource(R.drawable.ic_collapse);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return MyContants.CATEGORIES.length;
    }

    public List<Service> getCheckedList() {
        List<Service> services = new ArrayList<>();
        if(adapterList != null){
            for (SuggestServiceCardAdapter adapter :
                    adapterList) {
                if(adapter !=  null){
                    services.addAll(adapter.getCheckedList());
                }
            }
        }
        return services;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout item, lnCategory;
        public TextView tvCategory;
        public ImageView icExpand;
        public RecyclerView rvService;
        public ExpandableLayout elService;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = (LinearLayout) itemView;
            this.tvCategory = itemView.findViewById(R.id.salon_service_recycle_view_category_tv);
            this.icExpand = itemView.findViewById(R.id.salon_service_expand_icon);
            this.rvService = itemView.findViewById(R.id.salon_servce_expand_list_rv);
            this.elService = itemView.findViewById(R.id.salon_service_expand_list);
            this.lnCategory = itemView.findViewById(R.id.salon_service_category_ln);
        }
    }
}
