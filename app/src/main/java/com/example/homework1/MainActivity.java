package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_nextPage,btn_prevPage;
    ViewPager pager;
    ImageView imageView;

    ArrayList<ImageInfo> allImages=new ArrayList<>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nextPage=findViewById(R.id.nextButton);
        btn_prevPage=findViewById(R.id.previousButton);
        pager=findViewById(R.id.img_pager);


        allImages.add(new ImageInfo("https://images.pexels.com/photos/38136/pexels-photo-38136.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        allImages.add(new ImageInfo("https://images.pexels.com/photos/956981/milky-way-starry-sky-night-sky-star-956981.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        allImages.add(new ImageInfo("https://images.pexels.com/photos/66997/pexels-photo-66997.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        allImages.add(new ImageInfo("https://img.freepik.com/free-photo/preparing-acai-bowl-flat-lay-style-with-tropical-fruits-grains_53876-124336.jpg?w=1380&t=st=1677939151~exp=1677939751~hmac=056b8f3b964dc93d917e6e2b0ec424eca003167f41ce3c7f11f1b3a6cdccbf2a"));
        allImages.add(new ImageInfo("https://images.pexels.com/photos/207353/pexels-photo-207353.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        allImages.add(new ImageInfo("https://images.pexels.com/photos/604684/pexels-photo-604684.jpeg"));

//        allImages.forEach(imageInfo -> Toast.makeText(this,imageInfo.getImgUrl()+"",Toast.LENGTH_LONG).show());

        adapter=new MyAdapter(allImages,this);

        pager.setAdapter(adapter);


        btn_nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (pager.getCurrentItem()>=allImages.size()-1){
                    pager.setCurrentItem(0);
                    Toast.makeText(MainActivity.this, "1  "+pager.getCurrentItem(), Toast.LENGTH_SHORT).show();

                }else {
                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
                    Toast.makeText(MainActivity.this, "2  "+pager.getCurrentItem(), Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn_prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pager.setCurrentItem(pager.getCurrentItem() - 1, true);


            }
        });




    }
}