package ggikko.me.gtemplateapp.di.injector;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ggikko.me.gtemplateapp.GgikkoApplication;
import lombok.AccessLevel;
import lombok.Getter;

public class InjectionFragment extends Fragment {

    @Getter(value = AccessLevel.PACKAGE)
    private FragmentInjector fragmentInjector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        inject();
        super.onCreate(savedInstanceState);
    }

    private void inject() {
        final GgikkoApplication application = ((GgikkoApplication) getActivity().getApplication());
        fragmentInjector = application.getInjectorCreator().makeFragmentInjector(this);
        fragmentInjector.inject(this);
    }
}
