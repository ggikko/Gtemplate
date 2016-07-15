package ggikko.me.gtemplateapp.model.translate.service;


import ggikko.me.gtemplateapp.model.translate.dto.TranslateResponse;
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

    //naver open api - translator sample
    @FormUrlEncoded
    @Headers({
            "X-Naver-Client-Id : hCh1RB6l31fbKNmOXjRr",
            "X-Naver-Client-Secret : obxUtFxrRE"
    })
    @POST("v1/language/translate")
    Observable<TranslateResponse> translate(@Field("source") String source, @Field("target") String target, @Field("text") String text);

}
