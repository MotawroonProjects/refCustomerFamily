package com.refCustomerFamily.adapters;


import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.makeramen.roundedimageview.RoundedImageView;
import com.refCustomerFamily.R;
import com.refCustomerFamily.models.SliderModel;
import com.refCustomerFamily.tags.Tags;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SlidingImage_Adapter extends PagerAdapter {
    List<SliderModel.Data.Sliders> IMAGES;
    private LayoutInflater inflater;
    Context context;

    public SlidingImage_Adapter(Context context, List<SliderModel.Data.Sliders> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_slider, view, false);

        assert imageLayout != null;
        final RoundedImageView imageView = imageLayout
                .findViewById(R.id.image);
        SliderModel.Data.Sliders slider = IMAGES.get(position);
        Picasso.get().load(Uri.parse(Tags.IMAGE_URL + slider.getImage())).fit().into(imageView);
        Log.e("eeeee",Tags.IMAGE_URL + slider.getImage());
        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
