package com.cnnc.android.redcarpetuprepo.view.detail;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cnnc.android.redcarpetuprepo.R;
import com.cnnc.android.redcarpetuprepo.model.pojo.Country;
import com.cnnc.android.redcarpetuprepo.util.GenralUtils;
import com.cnnc.android.redcarpetuprepo.view.HomeActivity;

/**
 * Created by NIKHIL on 3/20/2018.
 */

public class ImageDetailActivity extends AppCompatActivity {

    private int imageHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Country country = extras != null ? extras.getParcelable(HomeActivity.COUNTRY_ITEM) : null;

        ImageView imageView = findViewById(R.id.detail_image);

        //retrieving screen [width,height] and calculating image height.
        imageView.getLayoutParams().height = (int) (((float) GenralUtils
                .getScreenSize(getWindowManager().getDefaultDisplay())[0]) / 1.5);

        Glide.with(this).load(country != null
                ? country.getCountryFlagUrl()
                : new ColorDrawable(Color.TRANSPARENT))
                .into(imageView);
    }

}
