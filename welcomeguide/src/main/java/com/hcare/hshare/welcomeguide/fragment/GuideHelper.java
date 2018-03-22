package com.hcare.hshare.welcomeguide.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.hcare.hshare.welcomeguide.adapter.NormalViewPageAdapter;
import com.hcare.hshare.welcomeguide.adapter.NormalViewPageBaseBean;
import com.hcare.hshare.welcomeguide.indicator.spring.SpringIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper for GuideFragment
 *
 * @author hzl
 */
public class GuideHelper {

    public static GuideHelper getInstance() {
        return new GuideHelper();
    }

    public void init(FragmentManager fManager, ViewPager viewPager,
                     SpringIndicator springIndicator, String[] titles, int[] res) {
        List<NormalViewPageBaseBean> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            list.add(new NormalViewPageBaseBean(titles[i], res[i], i, res.length));
        }
        NormalViewPageAdapter adapter = new NormalViewPageAdapter(fManager, list, GuideFragment.class);
        viewPager.setAdapter(adapter);
        springIndicator.setViewPager(viewPager);
    }

}
