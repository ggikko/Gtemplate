package ggikko.me.gtemplateapp.model.translate.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 16. 7. 13..
 */
public class Result {

    @SerializedName("translatedText")
    @Expose
    public String translatedText;
}
