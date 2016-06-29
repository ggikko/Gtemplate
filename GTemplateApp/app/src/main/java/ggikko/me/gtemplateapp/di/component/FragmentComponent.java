package ggikko.me.gtemplateapp.di.component;

import dagger.Subcomponent;
import ggikko.me.gtemplateapp.di.module.FragmentModule;
import ggikko.me.gtemplateapp.di.qualifier.PerFragment;

/**
 * fragment component
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {


}
