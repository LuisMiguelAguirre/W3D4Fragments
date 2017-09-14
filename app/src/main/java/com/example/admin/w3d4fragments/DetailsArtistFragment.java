package com.example.admin.w3d4fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailsArtistFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailsArtistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsArtistFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private Famous famous;

    private TextView textViewArtistName;
    private TextView textViewDetailArtist;
    private ImageView imageViewPicture;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public DetailsArtistFragment() {
        // Required empty public constructor
    }

    public static DetailsArtistFragment newInstance(Famous famous) {
        DetailsArtistFragment fragment = new DetailsArtistFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, famous);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            famous = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_artist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewArtistName= view.findViewById(R.id.text_view_details_name_id);
        textViewDetailArtist = view.findViewById(R.id.text_view_details_description_id);
        imageViewPicture= view.findViewById(R.id.image_view_details_id);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textViewArtistName.setText(famous.getName());
        textViewDetailArtist.setText(famous.getDescription());
        imageViewPicture.setImageResource(famous.getImage_id());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String data);
    }
}
