package ggikko.me.gtemplateapp.model.translate.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 16. 7. 13..
 */
public class Message {

    @SerializedName("@type")
    @Expose
    public String type;
    @SerializedName("@service")
    @Expose
    public String service;
    @SerializedName("@version")
    @Expose
    public String version;
    @SerializedName("result")
    @Expose
    public Result result;
}
