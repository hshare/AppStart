package com.hcare.hshare.welcomeguide.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hcare.hshare.welcomeguide.R;
import com.hcare.hshare.welcomeguide.adapter.NormalViewPageBaseBean;

/**
 * 标配的fragment，可自定义
 *
 * @author hzl
 */
public class GuideFragment extends Fragment {

    /**
     * 当前页面的图片资源
     */
    private int bgRes;
    /**
     * 总页数
     */
    private int bgSum;
    /**
     * 当前页面编号
     */
    private int pageNo;
    /**
     * 当前界面的图片
     */
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            NormalViewPageBaseBean normalViewPageBaseBean = (NormalViewPageBaseBean) getArguments().getSerializable("databean");
            bgRes = normalViewPageBaseBean.getWhat();
            pageNo = normalViewPageBaseBean.getWhat1();
            bgSum = normalViewPageBaseBean.getWhat2();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wg_fragment_guide, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = getView().findViewById(R.id.image);
        imageView.setImageResource(bgRes);

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (pageNo + 1 == bgSum) {
                    getActivity().finish();
                }
            }
        });
    }
}
