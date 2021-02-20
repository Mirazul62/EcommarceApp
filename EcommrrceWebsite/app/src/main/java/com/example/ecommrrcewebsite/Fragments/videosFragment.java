package com.example.ecommrrcewebsite.Fragments;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommrrcewebsite.R;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link videosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class videosFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public videosFragment() {
        // Required empty public constructor
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    private View view;
    private TextView One,Two;
    private RelativeLayout loginsignup,bookmarks,chatgapremium;
    private TextView your_orders,favourite_orders,address,helpline,send_feedback,report_safety_issues,rate_Us_on_playstore;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment videosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static videosFragment newInstance(String param1, String param2) {
        videosFragment fragment = new videosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_videos, container, false);

        onSetNavigationDrawerEvents();
        return  view;
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