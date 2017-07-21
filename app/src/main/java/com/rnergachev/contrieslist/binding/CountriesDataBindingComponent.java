package com.rnergachev.contrieslist.binding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Binding component for Picasso
 *
 * Created by rnergachev.
 */

public class CountriesDataBindingComponent implements DataBindingComponent {
    private static String flagUrl = "https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/%1$s.png";

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String id) {
        if ("BQ".equals(id)) {
            id = "nl";
        } else if ("XK".equals(id)) {
            id = "kosovo";
        }
        Picasso.with(view.getContext()).load(String.format(flagUrl, id.toLowerCase())).placeholder(new ColorDrawable(Color.LTGRAY)).into(view);
    }
}
