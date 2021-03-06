package com.example.harri.thecampusrecruitmentsystem.AccountListFlow;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harri.thecampusrecruitmentsystem.AccountInfoFlow.CompanyInfo;
import com.example.harri.thecampusrecruitmentsystem.R;

import java.util.ArrayList;
/**
 * Created by harri on 7/17/2017.
 */

public class CompanyListRecyclerAdapter  extends RecyclerView.Adapter<CompanyListRecyclerAdapter.CompanyListHolder> {

    private ArrayList<CompanyInfo> companyListArrayList;
    private LayoutInflater inflater;

    private itemClickCallback itemClickCallback;

    public interface itemClickCallback {

        void onItemClick(int position);
    }

    public void setOnItemClickCallback(final itemClickCallback itemClickCallback){

        this.itemClickCallback = itemClickCallback;
    }

    public CompanyListRecyclerAdapter(ArrayList<CompanyInfo> companyListData, Context context) {

        companyListArrayList = companyListData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CompanyListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.user_card_items, parent, false);

        return new CompanyListHolder(view);
    }

    @Override
    public void onBindViewHolder(CompanyListHolder holder, int position) {

        CompanyInfo companyList = companyListArrayList.get(position);
//
//        Glide.with(inflater.getContext()).load(companyList.getCompanyURL()).asBitmap()
//                .error(R.drawable.default_company_image).centerCrop().into(holder.companyImage);

        holder.companyName.setText(companyList.getCompanyName());
        holder.companyWebPage.setText(companyList.getCompanyWebPage());
        holder.companyEmail.setText(companyList.getCompanyEmail());

    }

    @Override
    public int getItemCount() {

        return companyListArrayList.size();
    }

    class CompanyListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView companyImage;
        private TextView companyName;
        private TextView companyWebPage;
        private TextView companyEmail;

        private View itemContainer;

        public CompanyListHolder(View itemView) {
            super(itemView);

            companyImage = (ImageView) itemView.findViewById(R.id.user_image);
            companyName = (TextView) itemView.findViewById(R.id.user_list_name);
            companyWebPage = (TextView) itemView.findViewById(R.id.user_list_id);
            companyEmail = (TextView) itemView.findViewById(R.id.user_list_email);
            itemContainer = itemView.findViewById(R.id.card_view);

            itemContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            itemClickCallback.onItemClick(getAdapterPosition());
        }
    }
}