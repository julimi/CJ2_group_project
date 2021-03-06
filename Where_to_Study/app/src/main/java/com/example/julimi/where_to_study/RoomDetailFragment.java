package com.example.julimi.where_to_study;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.julimi.where_to_study.dummy.Model;

import java.util.Map;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link RoomListView}
 * in two-pane mode (on tablets) or a {@link RoomDetailView}
 * on handsets.
 */
public class RoomDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Model.DummyItem mItem;

    private int[] idForBlank = {
            R.id.textView0,
            R.id.textView2,
            R.id.textView4,
            R.id.textView6,
            R.id.textView8,
            R.id.textView10,
            R.id.textView12,
            R.id.textView14,
            R.id.textView16,
            R.id.textView18,
            R.id.textView20,
            R.id.textView22,
            R.id.textView24,
            R.id.textView26,
            R.id.textView28,
            R.id.textView30,
            R.id.textView32,
            R.id.textView34,
            R.id.textView36,
            R.id.textView38,
            R.id.textView40,
            R.id.textView42,
            R.id.textView44,
            R.id.textView46,
            R.id.textView48,
            R.id.textView50,
            R.id.textView52,
            R.id.textView54,
            R.id.textView56,
            R.id.textView58,
            R.id.textView60,
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RoomDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            System.out.println("ARG_ITEM_ID: " + ARG_ITEM_ID + " " + getArguments().getString(ARG_ITEM_ID));
            Map<String, Model.DummyItem> temp = Model.ITEM_MAP;
            mItem = temp.get(getArguments().getString(ARG_ITEM_ID));
            System.out.println("ARG_ITEM: " + " " + Model.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID)).id);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                String nTitle = mItem.content.substring(0,9);
                appBarLayout.setTitle(nTitle);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        //if (mItem != null) {
           // ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
        //}

        //mItem = Model.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        if (mItem != null) {
            String[] det = mItem.details;
            boolean versionOfBackground = true;
            for (int i = 0; i < 31; i++) {
                if (det[i] != "") {
                    if (versionOfBackground)
                        ((TextView) rootView.findViewById(idForBlank[i])).setBackgroundResource(R.drawable.cell_shape1);
                    else
                        ((TextView) rootView.findViewById(idForBlank[i])).setBackgroundResource(R.drawable.cell_shape2);
                }
                if (det[i] != "" && det[i] != "paint") {
                    ((TextView) rootView.findViewById(idForBlank[i])).setText(det[i]);
                    if (det[i].length() >= 11) versionOfBackground = !versionOfBackground;
                }
                //((TextView) rootView.findViewById(idForBlank[i])).setBackgroundResource();


            }
        }
        //((TextView) rootView.findViewById(R.id.textView2)).setText("ijidjs");
        return rootView;
    }
}
