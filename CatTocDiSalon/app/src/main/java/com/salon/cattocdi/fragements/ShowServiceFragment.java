package com.salon.cattocdi.fragements;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.SuggestServiceCardAdapter;
import com.salon.cattocdi.utils.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 */
public class ShowServiceFragment extends Fragment {

private RecyclerView rcService;
private Button btnChoose;


    public ShowServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_service, container, false);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcService = view.findViewById(R.id.recyclerview);
        SuggestServiceCardAdapter adapter = new SuggestServiceCardAdapter();
        testRecycleViewAdapter(rcService);
        btnChoose = (Button) view.findViewById(R.id.btn_get_service);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Toast.makeText(getActivity(),"Bạn đã chọn dịch vụ",Toast.LENGTH_SHORT).show();
                ShowServiceFragment showServiceFragment = new ShowServiceFragment();
                bundle.putString("name","Cắt tóc");
                showServiceFragment.setArguments(bundle);
                SearchFragment searchFragment = new SearchFragment();
                getFragmentManager().beginTransaction().replace(R.id.activity_main_container_fl, searchFragment, null)
                        .addToBackStack(null).commit();
            }
        });


        return view;
    }

    private void testRecycleViewAdapter(RecyclerView rv){
        //Show RECYCLEVIEW
        List<Model> items = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(mLayoutManager);
        SuggestServiceCardAdapter adapter = new SuggestServiceCardAdapter();
        rv.setAdapter(adapter);
        fillItems(items);
        adapter.loadItems(items);

    }
    private void fillItems(List<Model> items) {
        /*HashMap<String, List<String>> services = new HashMap<>();
        List<String> categories = new ArrayList<String>();
        categories.add("Cắt tóc");
        categories.add("Nhuộm");
        categories.add("Uốn");
        categories.add("Duỗi");*/

        List<String> listServices = new ArrayList<String>();
        listServices.add("Nam");
        listServices.add("Nữ");
        listServices.add("Ngang");
        listServices.add("Xéo");
        listServices.add("Tạo kiểu");

        /*services.put(categories.get(0), listServices);
        services.put(categories.get(1), listServices);
        services.put(categories.get(2), listServices);
        services.put(categories.get(3), listServices);*/
       /* List<String> listService = new ArrayList<>();
        listService.add("Cat toc");
        listService.add("Nhuom");
        listService.add("Uon");
        listService.add("Duoi");*/

       for (int i = 0; i < listServices.size(); i++) {
           Model model = new Model();
          // model.setPosition(i + 1);
            model.setItem(listServices.get(i));
           items.add(model);
        }



    }


}
