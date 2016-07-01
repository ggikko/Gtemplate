package ggikko.me.gtemplateapp.ui.base.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ggikko.me.gtemplateapp.ui.base.main.fragment.TemplateFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TemplateFragment();
        } else {
            return new TemplateFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Simple1";
            case 1:
                return "Simple2";
            case 2:
                return "Simple3";
            case 3:
                return "Simple4";
        }
        return null;
    }
}