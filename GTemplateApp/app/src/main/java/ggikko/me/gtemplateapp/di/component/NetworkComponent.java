package ggikko.me.gtemplateapp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.gtemplateapp.di.module.network.NetworkModule;
import retrofit2.Retrofit;

/**
 * Created by ggikko on 16. 5. 25..
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {

    Retrofit retrofit();
}
