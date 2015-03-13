package com.triadslabs.utils.network;

import com.triadslabs.utils.logger.Log4a;
import com.triadslabs.utils.reflection.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
public class NetworkUtil {

    public static String getQueryStringURL(String url, Object model) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (model != null) {
            sb.append("?");
            Boolean flag = true;
            for (Method method : ReflectionUtil.findGettersSetters(
                    model.getClass(), true)) {
                try {
                    String returnValue = (String) method.invoke(model, null);
                    if (returnValue != null) {
                        Log4a.e(method.getName(), returnValue);
                        if (flag) {
                            sb.append(method.getName() + "=" + returnValue);
                            flag = false;
                        } else {
                            sb.append("&" + method.getName() + "="
                                    + returnValue);
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    Log4a.e("error occured", e.getMessage());
                }
            }
            Log4a.e("Parcel Bean In completed", "End");
        }
        Log4a.e("Full URL = ", sb.toString());
        return sb.toString();
    }

}
