package com.listapp.Fragment;

/**
 * Created by Nivesh on 6/22/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.listapp.Activity.MedicineSearchActivity;
import com.listapp.R;

public class MedicineHomeFragment extends Fragment{

    private static FrameLayout fragmentView;
    private static RelativeLayout parentView;
    private LinearLayout search;
//    private LinearLayout adContainerView;
//    private AdView adView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MedicineSearchActivity.heading.setText("HOME");
        Context context = getContext();
        fragmentView = view.findViewById(R.id.fragmentView);
        parentView = view.findViewById(R.id.parentView);
        search = view.findViewById(R.id.search);
//        MedicineSearchActivity.searchView.setVisibility(View.GONE);
//        MedicineSearchActivity.heading.setVisibility(View.VISIBLE);
//        view.findViewById(R.id.mlogo).setVisibility(View.VISIBLE);
//        view.findViewById(R.id.textview1).setVisibility(View.VISIBLE);
//        view.findViewById(R.id.textView2).setVisibility(View.VISIBLE);
//        search.setVisibility(View.VISIBLE);
//        fragmentView.setVisibility(View.GONE);
        hideFragmentView();
//        MedicineSearchActivity.heading.setVisibility(View.VISIBLE);
//        MedicineSearchActivity.searchView.setVisibility(View.GONE);
//        MedicineSearchActivity.backButton.setVisibility(View.GONE);
        MedicineSearchActivity.whichScreen = 1;
//        MedicineSearchActivity.search.setText("");
//        adContainerView = view.findViewById(R.id.ad_view_container);
//        // Step 1 - Create an AdView and set the ad unit ID on it.
//        adView = new AdView(this.getContext());
//        adView.setAdUnitId("ca-app-pub-7457423848084246/7709905183");
//        adContainerView.addView(adView);
//        loadBanner();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.search) {
                    MedicineSearchActivity.searchiconView.setVisibility(View.VISIBLE);
                    MedicineSearchActivity.backButton.setVisibility(View.VISIBLE);
                    MedicineSearchActivity.toolbarCloseIconView.setVisibility(View.GONE);
                    MedicineSearchActivity.heading.setVisibility(View.GONE);
                    MedicineSearchActivity.searchView.setVisibility(View.VISIBLE);
                    showFragmentView();
                    getFragmentManager().beginTransaction().replace(R.id.fragmentView,new OrderSearchFragment(),"OrderSearchFragment").addToBackStack("OrderSearchFragment").commit();
                }
            } });


    }
    private void showFragmentView() {
        fragmentView.setVisibility(View.VISIBLE);
        parentView.setVisibility(View.GONE);
    }

    public static void hideFragmentView()
    {
        parentView.setVisibility(View.VISIBLE);
        fragmentView.setVisibility(View.GONE);
    }



   public static void showKeyboard(Context context) {
        ((InputMethodManager) (context).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


}

