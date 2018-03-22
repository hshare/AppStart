package hcare.hshare.appstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.hcare.hshare.welcomeguide.fragment.GuideHelper;
import com.hcare.hshare.welcomeguide.indicator.spring.SpringIndicator;
import com.hcare.hshare.welcomeguide.viewpager.scroller.ScrollerViewPager;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wg_activity_basefor);
        GuideHelper.getInstance().init(getSupportFragmentManager()
                , (ScrollerViewPager) findViewById(R.id.view_pager)
                , (SpringIndicator) findViewById(R.id.indicator)
                , getResources().getStringArray(R.array.indicator_titles)
                , new int[]{R.mipmap.guide1,
                        R.mipmap.guide2,
                        R.mipmap.guide3,
                        R.mipmap.guide4});
    }
}
