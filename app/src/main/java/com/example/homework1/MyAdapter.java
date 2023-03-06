package com.example.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    private ArrayList<ImageInfo> images;
    private Context context;

    public MyAdapter(ArrayList<ImageInfo> images, Context context) {
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.size();
    }



    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.img_custom_item,container,false);

        ImageView img_view = v.findViewById(R.id.custom_img);

        Glide.with(context)
                .load(images.get(position).getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img_view);
        container.addView(v);


//        Picasso.get()
//                .load(images.get(position).getImgUrl())
//                .resize(800, 400)
//                .centerCrop()
//                .into(img_view);

//        img_view.setImageResource(R.drawable.left);
        return v;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
