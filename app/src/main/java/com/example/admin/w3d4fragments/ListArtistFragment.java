package com.example.admin.w3d4fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class ListArtistFragment extends Fragment {
    private static final String ARG_PARAM1 = "famousData";
    private ArrayList<Famous> famousData;
    private RecyclerView famousRecyclerView;

    private OnFragmentInteractionListener mListener;

    public ListArtistFragment() {
        // Required empty public constructor
    }

    public static ListArtistFragment newInstance(ArrayList<Famous> famousData) {
        ListArtistFragment fragment = new ListArtistFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, famousData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            famousData = getArguments().getParcelableArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_artist, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        famousRecyclerView = view.findViewById(R.id.recycler_view_fragment_left);
        //I need to receive by paremeter the layout manager then a switch to select the correct one
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        famousRecyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemAnimator itemAnimator;
        itemAnimator = new DefaultItemAnimator();
        famousRecyclerView.setItemAnimator(itemAnimator);
        RecyclerViewFamouseAdapter recyclerViewFamouseAdapter = new RecyclerViewFamouseAdapter(famousData);
        famousRecyclerView.setAdapter(recyclerViewFamouseAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //when I clicked the name in the list not for now
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}