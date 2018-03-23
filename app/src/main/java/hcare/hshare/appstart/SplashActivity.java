package hcare.hshare.appstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hcare.hshare.welcomeguide.fragment.GuideHelper;
import com.hcare.hshare.welcomeguide.fragment.SimpleOnPageClickListener;
import com.hcare.hshare.welcomeguide.indicator.spring.SpringIndicator;
import com.hcare.hshare.welcomeguide.viewpager.scroller.ScrollerViewPager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wg_activity_basefor);
        GuideHelper.getInstance().init(getSupportFragmentManager()
                , (ScrollerViewPager) findViewById(R.id.view_pager)
                , (SpringIndicator) findViewById(R.id.indicator)
                , getResources().getStringArray(R.array.indicator_titles)
                , new int[]{
                        R.mipmap.guide5,
                        R.mipmap.guide6,
                        R.mipmap.guide7,
                        R.mipmap.guide8}, new SimpleOnPageClickListener() {
                    @Override
                    public void onFinish(boolean isFinish) {
                        if (isFinish) {
                            startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                            SplashActivity.this.finish();
                        }
                    }
                });
    }
}
