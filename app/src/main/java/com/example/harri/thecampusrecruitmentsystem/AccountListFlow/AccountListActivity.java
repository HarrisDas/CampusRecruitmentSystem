package com.example.harri.thecampusrecruitmentsystem.AccountListFlow;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.harri.thecampusrecruitmentsystem.AccountCreationFlow.AccountCreationActivity;
import com.example.harri.thecampusrecruitmentsystem.NotificationService;
import com.example.harri.thecampusrecruitmentsystem.R;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by harri on 7/17/2017.
 */

public class AccountListActivity  extends AppCompatActivity {

    public static String membershipType;
    public static int menuItemView;

    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    public static TextView toolBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list_detail);

        Intent intent = new Intent(this, NotificationService.class);
        this.startService(intent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.showOverflowMenu();
        setSupportActionBar(toolbar);

        attachingWidgets();

        Intent intents = getIntent();
        membershipType = intents.getExtras().getString("memberType");

        mAuth = FirebaseAuth.getInstance();

        saveUserPref();

        if (membershipType.equals(getString(R.string.admin_type))){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_list_detail_container, new StudentCompanyPagerFragment())
                    .commit();


        } else if (membershipType.equals(getString(R.string.student_type))){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_list_detail_container, new CompanyListFragment())
                    .commit();

        } else if (membershipType.equals(getString(R.string.company_type))){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_list_detail_container, new StudentListFragment())
                    .commit();
        }
    }

    public void attachingWidgets(){

        toolBarText = (TextView) findViewById(R.id.title_page);
    }

    public void saveUserPref(){

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.prefKey),0);
        sharedPreferences.edit().putString(getResources().getString(R.string.prefType),membershipType).apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (membershipType.equals(getString(R.string.student_type))){

            MenuItem registerOne = menu.findItem(R.id.list_of_companies_with_vacancies_available);
            MenuItem registerTwo = menu.findItem(R.id.list_of_companies);
            registerOne.setVisible(true);
            registerTwo.setVisible(true);
        }

        if (membershipType.equals(getString(R.string.company_type))) {

            MenuItem registerOne = menu.findItem(R.id.list_of_applied_students);
            MenuItem registerTwo = menu.findItem(R.id.list_of_students);
            MenuItem registerThree= menu.findItem(R.id.post_a_job);
            registerThree.setVisible(true);
            registerOne.setVisible(true);
            registerTwo.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        menuItemView = item.getItemId();

        switch (item.getItemId()) {

            case R.id.post_a_job:



                break;
            case R.id.list_of_companies:

                CompanyListFragment.listOfCompanies();
                break;

            case R.id.list_of_companies_with_vacancies_available:

                CompanyListFragment.companiesWithVacancies();
                break;

            case R.id.list_of_students:

                StudentListFragment.listOfStudents();
                break;

            case R.id.list_of_applied_students:

                StudentListFragment.appliedStudentList();
                break;

            case R.id.action_sign_out:

                mAuth.signOut();
                sharedPreferences.edit().remove(getResources().getString(R.string.prefType)).apply();

                Intent intent = new Intent(this, AccountCreationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                finish();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();

        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);
     //ye destroy krna h
          finish();
    }
}
