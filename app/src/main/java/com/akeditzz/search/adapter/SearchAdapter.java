package com.akeditzz.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akeditzz.search.R;
import com.akeditzz.search.model.SearchModel;

import java.util.ArrayList;

/**
 * Created by Akshay on 04-04-2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<SearchModel> originalList;
    private ArrayList<SearchModel> filteredList;
    private Context context;

    public SearchAdapter(ArrayList<SearchModel> originalList, Context context) {
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, int position) {

        holder.tv_name.setText(filteredList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
        }
    }

    public void Filter(String s){

        try {
            if (originalList.size()>0){


                filteredList = new ArrayList<>();

                for (SearchModel sm :originalList){

                    if (sm.getName().toLowerCase().contains(s.toLowerCase())){
                        filteredList.add(sm);
                    }

                }
                if (TextUtils.isEmpty(s)){
                    filteredList = new ArrayList<>();
                }

                notifyDataSetChanged();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
