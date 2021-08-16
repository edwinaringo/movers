package com.example.movers_app.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movers_app.MovingOrdersDetailFragment;
import com.example.movers_app.models.MovingOrders;

import java.util.List;

public class MovingOrdersPageAdapter extends FragmentPagerAdapter {

    private MovingOrders mMovingOrders;

    List<MovingOrders> mMovingOrdersList;
    public MovingOrdersPageAdapter(@NonNull FragmentManager fm, int behavior, List<MovingOrders> results) {
        super(fm, behavior);
        mMovingOrdersList= results;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
     return MovingOrdersDetailFragment.newInstance(mMovingOrdersList.get(position));
    }

    @Override
    public int getCount() {
        return mMovingOrdersList.size();
    }
    @Override
    public String getPageTitle(int position) {
        return mMovingOrdersList.get(position).getMovingCompany();
    }
}
