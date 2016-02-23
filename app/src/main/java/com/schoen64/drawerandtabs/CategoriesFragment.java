package com.schoen64.drawerandtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe on 2/22/2016.
 */
public class CategoriesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private List<String> mData = new ArrayList<>();

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupData(mData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_categories, container, false);

        /** Set up the recycler view */
        mRecyclerView = (RecyclerView) root.findViewById(R.id.categoriesRecycler);
        mRecyclerView.setHasFixedSize(true);

        /** Set up a linear layout manager */
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        /** Set up the adapter */
        mAdapter = new CategoriesAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
        private List<String> mDataset = new ArrayList<>();

        /**
         * Provide a reference to the view for each data item
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            public View mView;
            public ViewHolder(View v) {
                super(v);
                mView = v;
            }
        }

        public CategoriesAdapter(List<String> dataset) {
            mDataset = dataset;
        }

        @Override
        public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            TextView tv = (TextView) holder.mView.findViewById(R.id.categoryName);
            tv.setText(mDataset.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

    }

    private void setupData(List<String> data) {

        data.add("Cooking");
        data.add("Refrigeration");
        data.add("Kitchen Cleanup");
    }
}
