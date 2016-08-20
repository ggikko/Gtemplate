package ggikko.me.gtemplateapp.ui.base.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ggikko.me.gtemplateapp.R;

/**
 * A sample {@link Fragment} subclass.
 */
public class TemplateFragment extends Fragment {


    public TemplateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_template, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("ggikko", "koko");
    }
}
