package com.example.harri.thecampusrecruitmentsystem.AccountCreationFlow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.harri.thecampusrecruitmentsystem.AccountListFlow.AccountListActivity;
import com.example.harri.thecampusrecruitmentsystem.R;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by harri on 7/17/2017.
 */

public class AccountCreationActivity extends AppCompatActivity {

    public static boolean checkConnectivity(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private static Context context;

    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        context = this.getApplicationContext();

            sharedPreferences = this.getSharedPreferences(getResources().getString(R.string.prefKey),0);

        mAuth = FirebaseAuth.getInstance();
        String membershipType = sharedPreferences.getString(getResources().getString(R.string.prefType), "");

        if (mAuth.getCurrentUser() != null && !membershipType.equals("")){

            Intent intent = new Intent(this, AccountListActivity.class);
            intent.putExtra("memberType", membershipType);
            startActivity(intent);

            finish();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new SignInFragment())
                .commit();
    }

    public static Context getContext() {
        return context;
    }

}
