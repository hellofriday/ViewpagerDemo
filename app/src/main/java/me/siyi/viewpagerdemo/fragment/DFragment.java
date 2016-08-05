package me.siyi.viewpagerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.siyi.viewpagerdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment {


    @BindView(R.id.txt_header_title)
    TextView txtTitle;
    public DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        txtTitle.setText("我的");
    }

}
