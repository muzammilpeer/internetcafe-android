package com.triadslabs.networklayer.requests;

import com.google.gson.JsonObject;
import com.triadslabs.networklayer.enums.NetworkRequestEnum;
import com.triadslabs.utils.network.GsonUtil;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
public class SDSuggestionsCategoryListRequest extends BaseNetworkRequest {

    public SDSuggestionsCategoryListRequest() {

    }

    public SDSuggestionsCategoryListRequest(Object model) {
        super(model);
    }

    public String getURL() throws Exception {
        return NetworkRequestEnum.BASE_REQUEST.getRelativeUrl()
                + NetworkRequestEnum.SUBMIT_RECORD_PAYMENT.getRelativeUrl();
    }

    // for testing purpose change it to true for HTTP Method POST
    public Boolean havePostData() {
        return true;
    }

    public JsonObject postData() throws Exception {
        return  GsonUtil.getJsonObjectFromObject(this.getDataModel());
    }

//    public Boolean haveGetData() {
//        return false;
//    }
//
//    public String getData() throws Exception {
//        return NetworkUtil.getQueryStringURL(this.getURL(),
//                this.getDataModel());
//    }
}