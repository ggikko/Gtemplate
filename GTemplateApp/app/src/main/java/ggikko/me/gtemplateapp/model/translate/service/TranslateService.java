package ggikko.me.gtemplateapp.model.translate.service;

import ggikko.me.gtemplateapp.model.translate.dto.TranslatedTextResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ggikko on 16. 6. 23..
 */
public interface TranslateService {

    @FormUrlEncoded
    @Headers({
            "X-Naver-Client-Id : hCh1RB6l31fbKNmOXjRr",
            "X-Naver-Client-Secret : obxUtFxrRE"
    })
    @POST("v1/language/translate")
    Observable<TranslatedTextResponse> translate(@Header("X-Naver-Client-Id") String id, @Header("X-Naver-Client-Secret") String secret, @Field("source") String source, @Field("target") String target, @Field("text") String text);

}
