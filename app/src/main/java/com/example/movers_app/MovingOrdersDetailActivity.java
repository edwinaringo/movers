package com.example.movers_app;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.movers_app.adapters.MovingOrdersPageAdapter;
import com.example.movers_app.models.MovingOrders;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovingOrdersDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private MovingOrdersPageAdapter adapterViewPager;
    private MovingOrders mMovingOrders;

    List<MovingOrders> mMovingOrdersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_moving_orders_detail);
        ButterKnife.bind(this);

        mMovingOrdersList = Parcels.unwrap(getIntent().getParcelableExtra("movingOrders"));
        int startingPosition = getIntent().getIntExtra("position",0);
        for(int i=0;i<mMovingOrdersList.size();i++){
            Log.i("click",mMovingOrdersList.get(i).getMovingCompany().toString());
        }

        adapterViewPager = new MovingOrdersPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mMovingOrdersList);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }

}
