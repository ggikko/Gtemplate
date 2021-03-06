package ggikko.me.gtemplateapp.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.injector.FragmentInjector;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * fragment for injection, v4.fragment
 */
public class InjectionFragment extends Fragment {

    @Getter(value = AccessLevel.PACKAGE)
    private FragmentInjector fragmentInjector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        inject();
        super.onCreate(savedInstanceState);
    }

    /** inject */
    private void inject() {
        final GgikkoApplication application = ((GgikkoApplication) getActivity().getApplication());
        fragmentInjector = application.getInjectorCreator().makeFragmentInjector(this);
        fragmentInjector.inject(this);
    }
}
