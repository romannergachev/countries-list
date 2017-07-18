package com.rnergachev.contrieslist.binding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Binding component for Picasso
 *
 * Created by rnergachev.
 */

public class CountriesDataBindingComponent implements DataBindingComponent {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
