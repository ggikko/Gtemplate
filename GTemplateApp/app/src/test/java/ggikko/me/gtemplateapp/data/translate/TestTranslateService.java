package ggikko.me.gtemplateapp.data.translate;

import com.annimon.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import ggikko.me.gtemplateapp.data.DaggerTestApiComponent;
import ggikko.me.gtemplateapp.data.DaggerTestNetworkComponent;
import ggikko.me.gtemplateapp.data.TestNetworkComponent;
import ggikko.me.gtemplateapp.di.module.TestNetworkModule;
import ggikko.me.gtemplateapp.di.module.network.NetworkModule;
import ggikko.me.gtemplateapp.model.translate.dto.TranslateResponse;
import ggikko.me.gtemplateapp.model.translate.service.TranslateService;
import ggikko.me.gtemplateapp.util.api.ConstantApi;
import rx.observers.TestSubscriber;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by admin on 16. 7. 13..
 */
public class TestTranslateService {

    @Inject
    TranslateService translateService;

    @Before
    public void setup() {

        //dagger inject
        DaggerTestApiComponent
                .builder()
                .testNetworkComponent(getTestNetworkComponent())
                .build()
                .inject(this);
    }

    private TestNetworkComponent getTestNetworkComponent() {
        return DaggerTestNetworkComponent.builder().networkModule(new NetworkModule(ConstantApi.RELEASE_URL)).build();
    }

    @Test
    public void testTranslateSimulation() {

        //given
        TestSubscriber<TranslateResponse> translateSubscriber = TestSubscriber.create();

        //when
        translateService.translate("en", "ko", "hello").subscribe(translateSubscriber);
        List<TranslateResponse> translatedTextItems = translateSubscriber.getOnNextEvents();

        //then
        translateSubscriber.awaitTerminalEvent();

        //test
        assertThat(translatedTextItems).hasSize(1);
        Stream.of(translatedTextItems).forEach(value -> {
            assertThat(value.message.equals("안녕하세요."));
        });
    }
}
