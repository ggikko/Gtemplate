package ggikko.me.gtemplateapp.ui.base.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import ggikko.me.gtemplateapp.ui.base.main.fragment.TemplateFragment;

/**
 * section pager, 페이지 어답터
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> fragmentCollection = new SparseArray<Fragment>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //items
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TemplateFragment();
        } else {
            return new TemplateFragment();
        }
    }

    //page count
    @Override
    public int getCount() {
        return 4;
    }

    //title
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fragmentCollection.put(position,fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        fragmentCollection.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getFragmentFromCollection(int position){
        return fragmentCollection.get(position);
    }
}