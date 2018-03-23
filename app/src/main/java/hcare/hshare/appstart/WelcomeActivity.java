package hcare.hshare.appstart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hcare.hshare.welcomeguide.fragment.GuideHelper;
import com.hcare.hshare.welcomeguide.fragment.SimpleOnPageClickListener;
import com.hcare.hshare.welcomeguide.indicator.spring.SpringIndicator;
import com.hcare.hshare.welcomeguide.viewpager.scroller.ScrollerViewPager;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(100,2500);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(100);
    }
}
