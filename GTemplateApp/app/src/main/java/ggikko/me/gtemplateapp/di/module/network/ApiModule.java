package ggikko.me.gtemplateapp.di.module.network;

import dagger.Module;
import dagger.Provides;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.model.translate.service.TranslateService;
import retrofit2.Retrofit;

/**
 * Created by ggikko on 16. 5. 25..
 */
@Module
public class ApiModule {

    /**
     * Sample Translate Service
     * @param retrofit
     * @return
     */
    @Provides
    @PerActivity
    TranslateService provideTranslateService(Retrofit retrofit){
        return retrofit.create(TranslateService.class);
    }
}
