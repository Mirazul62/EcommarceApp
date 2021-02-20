package com.example.ecommrrcewebsite.Fragments;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommrrcewebsite.Adapters.BannerAdapter;
import com.example.ecommrrcewebsite.Adapters.CatAdapter;
import com.example.ecommrrcewebsite.Adapters.SimpleVerticalAdapter;
import com.example.ecommrrcewebsite.Models.BannerModel;
import com.example.ecommrrcewebsite.Models.CategoryModel;
import com.example.ecommrrcewebsite.Models.SimpleVerticalModel;
import com.example.ecommrrcewebsite.OperationRetrofitApi.ApiClient;
import com.example.ecommrrcewebsite.OperationRetrofitApi.ApiInterface;
import com.example.ecommrrcewebsite.OperationRetrofitApi.Users;
import com.example.ecommrrcewebsite.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment implements View.OnClickListener {

    public OrderFragment() {
        // Required empty public constructor
    }

    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    private View view;
    private TextView One,Two;
    private RelativeLayout loginsignup,bookmarks,chatgapremium;
    private TextView your_orders,favourite_orders,address,helpline,send_feedback,report_safety_issues,rate_Us_on_playstore;

    /////////category slider start////////
    private RecyclerView recyclerViewCategory;
    private CatAdapter catAdapter;
    private List<CategoryModel> categoryModelList;
    
    ///////category slider end///////

    /////////Banner slider start ////////
    private RecyclerView recyclerViewBanner;
    private BannerAdapter bannerAdapter;
    private List<BannerModel> bannerModelList;

    //////Banner slider end/////////

    ////////simple vertical slider start///////////
    private RecyclerView recyclerViewSimple;
    private SimpleVerticalAdapter simpleVerticalAdapter;
    private List<SimpleVerticalModel> simpleVerticalModelList ;

    ////////simple vertical slider end////////////

    ////////great offers vertical slider start///////////
    private RecyclerView greatOffersRecyclerViewVertical;

    //////// great offers vertical slider end////////////

    ////////new arrival vertical slider start///////////
    private RecyclerView newArrivalVerticalRecyclerView;

    //////// new arrival vertical slider end////////////

    ////////exclusive items vertical slider start///////////
    private RecyclerView exclusiveVerticalRecyclerView;

    //////// exclusive vertical slider end////////////

    ///////////api's calling/////////
    public static ApiInterface apiInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order, container, false);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        onSetNavigationDrawerEvents();
        init();
        return  view;
    }

    private void init() {
        /////////////////catagory model list start////////
        recyclerViewCategory =(RecyclerView) view.findViewById(R.id.recyclerViewCategory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(recyclerViewCategory.HORIZONTAL);
        recyclerViewCategory.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<>();
        Call<Users> categoryCall = apiInterface.getCategories();
        categoryCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                categoryModelList = response.body().getCategory();
                catAdapter = new CatAdapter(categoryModelList,getContext());
                recyclerViewCategory.setAdapter(catAdapter);
                catAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        } );

        /////catagory model list end /////////

        /////////banner model list start///////
        recyclerViewBanner =(RecyclerView) view.findViewById(R.id.recyclerViewBanner);
        LinearLayoutManager layoutManagerBanner = new LinearLayoutManager(getContext());
        layoutManagerBanner.setOrientation(recyclerViewCategory.HORIZONTAL);
        recyclerViewBanner.setLayoutManager(layoutManagerBanner);

        bannerModelList = new ArrayList<>();
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));
        bannerModelList.add(new BannerModel(R.drawable.sentiment));

        bannerAdapter = new BannerAdapter(bannerModelList,getContext());
        recyclerViewBanner.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();

        ////////banner model list end////////

        /////////simple vertical model list start///////
        recyclerViewSimple =(RecyclerView) view.findViewById(R.id.recyclerViewSimple);
        LinearLayoutManager layoutManagerSimpleVerticalSlider = new LinearLayoutManager(getContext());
        layoutManagerSimpleVerticalSlider.setOrientation(RecyclerView.VERTICAL);
        recyclerViewSimple.setLayoutManager(layoutManagerSimpleVerticalSlider);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));


        simpleVerticalAdapter = new SimpleVerticalAdapter(simpleVerticalModelList,getContext());
        recyclerViewSimple.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        ////////simple vertical model list end////////

        /////////new great offers vertical model list start///////
        greatOffersRecyclerViewVertical =(RecyclerView) view.findViewById(R.id.greatOffersRecyclerViewVertical);
        LinearLayoutManager layoutManagerVerticalGreatOffers = new LinearLayoutManager(getContext());
        layoutManagerVerticalGreatOffers.setOrientation(RecyclerView.VERTICAL);
        greatOffersRecyclerViewVertical.setLayoutManager(layoutManagerVerticalGreatOffers);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));

        simpleVerticalAdapter = new SimpleVerticalAdapter(simpleVerticalModelList,getContext());
        greatOffersRecyclerViewVertical.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        ////////new great offers vertical model list end////////



        /////////new arrival vertical model list start///////
        newArrivalVerticalRecyclerView =(RecyclerView) view.findViewById(R.id.newArrivalVerticalRecyclerView);
        LinearLayoutManager layoutManagerVerticalNewArrival = new LinearLayoutManager(getContext());
        layoutManagerVerticalNewArrival.setOrientation(RecyclerView.VERTICAL);
        newArrivalVerticalRecyclerView.setLayoutManager(layoutManagerVerticalNewArrival);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));

        simpleVerticalAdapter = new SimpleVerticalAdapter(simpleVerticalModelList,getContext());
        newArrivalVerticalRecyclerView.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        ////////new arrival vertical model list end////////

        /////////exclusive items vertical model list start///////
        exclusiveVerticalRecyclerView =(RecyclerView) view.findViewById(R.id.exclusiveVerticalRecyclerView);
        LinearLayoutManager layoutManagerExclusiveVertical = new LinearLayoutManager(getContext());
        layoutManagerExclusiveVertical.setOrientation(RecyclerView.VERTICAL);
        exclusiveVerticalRecyclerView.setLayoutManager(layoutManagerExclusiveVertical);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.sentiment,"Onion", "local bla bla bla", "20% off", "1kg", "65tk" ));

        simpleVerticalAdapter = new SimpleVerticalAdapter(simpleVerticalModelList,getContext());
        exclusiveVerticalRecyclerView.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        ////////exclusive items vertical model list end////////


    }

    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);
        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);

        loginsignup=(RelativeLayout)view.findViewById(R.id.relativeLayout3) ;
        bookmarks=(RelativeLayout)view.findViewById(R.id.relativeLayout4) ;
        chatgapremium=(RelativeLayout)view.findViewById(R.id.relativeLayout5);

        your_orders=(TextView)view.findViewById(R.id.your_orders);
        favourite_orders=(TextView)view.findViewById(R.id.favourite_orders);
        address=(TextView)view.findViewById(R.id.address);
        helpline=(TextView)view.findViewById(R.id.helpline);
        send_feedback=(TextView)view.findViewById(R.id.send_feedback);
        report_safety_issues=(TextView)view.findViewById(R.id.report_safety_issues);
        rate_Us_on_playstore=(TextView)view.findViewById(R.id.rate_Us_on_playstore);

       // navigationView.setOnClickListener(this);
        navigationBar.setOnClickListener(this);

        loginsignup.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        chatgapremium.setOnClickListener(this);

        your_orders.setOnClickListener(this);
        favourite_orders.setOnClickListener(this);
        address.setOnClickListener(this);
        helpline.setOnClickListener(this);
        send_feedback.setOnClickListener(this);
        report_safety_issues.setOnClickListener(this);
        rate_Us_on_playstore.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.relativeLayout3:
                Toast.makeText(getContext(),"Login SignUp",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout4:
                Toast.makeText(getContext(),"Bookmarks",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout5:
                Toast.makeText(getContext(),"Chatga Premium ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.your_orders:
                Toast.makeText(getContext(),"your_orders",Toast.LENGTH_SHORT).show();
                break;
            case R.id.favourite_orders:
                Toast.makeText(getContext(),"favourite_orders",Toast.LENGTH_SHORT).show();
                break;
            case R.id.address:
                Toast.makeText(getContext(),"address",Toast.LENGTH_SHORT).show();
                break;
            case R.id.helpline:
                Toast.makeText(getContext(),"helpline",Toast.LENGTH_SHORT).show();
                break;
            case R.id. send_feedback:
                Toast.makeText(getContext()," send_feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.report_safety_issues:
                Toast.makeText(getContext(),"report_safety_issues",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rate_Us_on_playstore:
                Toast.makeText(getContext(),"rate_Us_on_playstore",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();



    }
}