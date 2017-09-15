package com.example.admin.w3d4fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class RecyclerViewFamouseAdapter extends RecyclerView.Adapter<RecyclerViewFamouseAdapter.ViewHolder> {

    private RecyclerViewFamouseAdapter.OnViewHolderInteractionListener mListener;

    public void setListener(RecyclerViewFamouseAdapter.OnViewHolderInteractionListener listener) {
        this.mListener = listener;
    }

    List<Famous> famouses;
    Context context;

    public RecyclerViewFamouseAdapter(List<Famous> famouses) {
        this.famouses = famouses;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_left_pane_activity, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Famous famous = famouses.get(position);
        holder.textViewName.setText(famous.getName());


        holder.textViewName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(mListener != null) {
                    mListener.onViewHolderInteraction(String.valueOf(position));
                    ListArtistFragment l= (ListArtistFragment)mListener;
                }
            }

        });


    }

    @Override
    public int getItemCount() {
        return famouses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        public ViewHolder(final View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.text_view_left_pane_name);
        }
    }

    public interface OnViewHolderInteractionListener {
        void onViewHolderInteraction(String data);
    }

}
