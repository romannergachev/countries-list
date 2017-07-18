package com.rnergachev.contrieslist.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnergachev.contrieslist.BR;
import com.rnergachev.contrieslist.R;
import com.rnergachev.contrieslist.data.model.Country;
import com.rnergachev.contrieslist.handler.CountriesListAdapterHandler;
import com.rnergachev.contrieslist.viewmodel.CountriesListViewModel;

/**
 * Recycler view adapter for countries list
 *
 * Created by rnergachev.
 */

public class CountriesListAdapter extends RecyclerView.Adapter<CountriesListAdapter.PostListViewHolder> {

    private final CountriesListViewModel viewModel;
    private CountriesListAdapterHandler handler;

    class PostListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        PostListViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            handler.onClick(viewModel.countriesList.get(getAdapterPosition()));
        }
    }

    public CountriesListAdapter(CountriesListViewModel viewModel, CountriesListAdapterHandler handler) {
        this.viewModel = viewModel;
        this.handler = handler;
        this.viewModel.countriesList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Country>>() {
            @Override
            public void onChanged(ObservableList<Country> countries) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Country> countries, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<Country> countries, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<Country> countries, int fromPosition, int toPosition, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Country> countries, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @Override
    public PostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new PostListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PostListViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setVariable(BR.model, viewModel);
        binding.setVariable(BR.position, position);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return viewModel.countriesList.size();
    }
}
