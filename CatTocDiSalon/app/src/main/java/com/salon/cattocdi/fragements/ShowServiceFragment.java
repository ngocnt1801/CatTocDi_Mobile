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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.CategoryAdapter;
import com.salon.cattocdi.adapters.SuggestServiceCardAdapter;
import com.salon.cattocdi.models.Category;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.models.Service;
import com.salon.cattocdi.requests.ApiClient;
import com.salon.cattocdi.requests.CategoryApi;
import com.salon.cattocdi.requests.SalonApi;
import com.salon.cattocdi.utils.Model;
import com.salon.cattocdi.utils.MyContants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p>
 * to handle interaction events.
 */
public class ShowServiceFragment extends Fragment {

    private RecyclerView rcService;
    private TextView btnChoose;
    private List<Category> categories;
    CategoryAdapter adapter;

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



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rcService.setLayoutManager(mLayoutManager);
        adapter = new CategoryAdapter(getActivity(), MyContants.SERVICE_CHECKBOX, new ArrayList<Service>(), categories);

        rcService.setAdapter(adapter);

        ApiClient.getInstance().create(CategoryApi.class)
                .getAllCategory("Bearer " + MyContants.TOKEN)
                .enqueue(new Callback<List<Category>>() {
                    @Override
                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                        adapter = new CategoryAdapter(getActivity(), MyContants.SERVICE_CHECKBOX, new ArrayList<Service>(), response.body());
                        rcService.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Category>> call, Throwable t) {

                    }
                });

        loadData(rcService);
        btnChoose = view.findViewById(R.id.btn_get_service);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                List<Service> services = adapter.getCheckedList();
                String serviceName = "";
                for (Service service :
                        services) {
                    serviceName += service;
                }

                bundle.putString("service_name", serviceName);
                SearchFragment searchFragment = new SearchFragment();
                searchFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.activity_main_container_fl, searchFragment, null)
                        .addToBackStack(null).commit();
            }
        });


        return view;
    }

    private void loadData(RecyclerView rv) {
        //Show RECYCLEVIEW
        List<Model> items = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(new CategoryAdapter(getActivity(), MyContants.SERVICE_CHECKBOX, new ArrayList<Service>(), categories));

    }

    private void fillItems(List<Model> items) {
        /*HashMap<String, List<String>> services = new HashMap<>();
        List<String> categories = new ArrayList<String>();
        categories.add("Cắt tóc");
        categories.add("Nhuộm");
        categories.add("Uốn");
        categories.add("Duỗi");*/

        List<String> listServices = new ArrayList<String>();
        listServices.add("Cắt tóc");
        listServices.add("Nhuộm");
        listServices.add("Hấp dầu");
        listServices.add("Bấm tóc");
        listServices.add("Uốn");
        listServices.add("Duỗi");
        listServices.add("Tạo kiểu");
        listServices.add("Gội đầu");
        listServices.add("Cắt móng");
        listServices.add("Đắp mặt nạ");
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

    private void loadListCategory() {

        ApiClient.getInstance().create(CategoryApi.class)
                .getAllCategory("Bearer " + MyContants.TOKEN)
                .enqueue(new Callback<List<Category>>() {
                    @Override
                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {


                    }

                    @Override
                    public void onFailure(Call<List<Category>> call, Throwable t) {

                    }
                });

    }

}
