package com.example.harri.thecampusrecruitmentsystem.AccountListFlow;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harri.thecampusrecruitmentsystem.R;

/**
 * Created by harri on 7/17/2017.
 */

public class StudentCompanyPagerFragment extends Fragment {

    private ViewPager studentCompanyViewPager;
    private StudentCompanyPagerAdapter studentCompanyPagerAdapter;
    private TabLayout studentCompanyTabLayout;
 boolean check =false;
    public StudentCompanyPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_student_company_pager, container, false);

        AccountListActivity.toolBarText.setText(getString(R.string.admin_dashboard));

        attachingWidgets(rootView);

            initializingWidgets();
        return rootView;
    }

    public void attachingWidgets(View view){

        studentCompanyViewPager = (ViewPager) view.findViewById(R.id.student_company_viewpager);
        studentCompanyTabLayout = (TabLayout) view.findViewById(R.id.tabs);
    }

    public void initializingWidgets(){

        studentCompanyPagerAdapter = new StudentCompanyPagerAdapter(getActivity(), getChildFragmentManager());
        studentCompanyViewPager.setAdapter(studentCompanyPagerAdapter);

        studentCompanyTabLayout.setupWithViewPager(studentCompanyViewPager);
    }
}
