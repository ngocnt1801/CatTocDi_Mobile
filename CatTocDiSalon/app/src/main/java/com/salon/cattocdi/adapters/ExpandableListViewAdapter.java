package com.salon.cattocdi.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.salon.cattocdi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> categories;
    private HashMap<String, List<String>> services;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
        services = new HashMap<>();
        categories = new ArrayList<String>();
        categories.add("Cắt tóc");
        categories.add("Nhuộm");
        categories.add("Uốn");
        categories.add("Duỗi");

        List<String> listServices = new ArrayList<String>();
        listServices.add("Nam");
        listServices.add("Nữ");
        listServices.add("Ngang");
        listServices.add("Xéo");
        listServices.add("Tạo kiểu");

        services.put(categories.get(0), listServices);
        services.put(categories.get(1), listServices);
        services.put(categories.get(2), listServices);
        services.put(categories.get(3), listServices);

    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return services.get(categories.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return categories.get(i);
    }

    @Override
    public Object getChild(int goupPos, int childPos) {
        return services.get(categories.get(goupPos)).get(childPos);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int goupPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean b, View view, ViewGroup viewGroup) {
        String category = (String) getGroup(groupPos);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_list_view_group, null);

        }
        TextView categoryView = view.findViewById(R.id.fg_search_dialog_category_tv);
        categoryView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 19);
        categoryView.setText(category);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        String child = (String) getChild(groupPosition, childPosition);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, null);
        }
        TextView childView = view.findViewById(android.R.id.text1);
        childView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,17);

        childView.setText(child);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
