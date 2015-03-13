package com.triadslabs.internetcafe.activity;

import android.app.Application;
import android.content.res.Configuration;

import com.triadslabs.networklayer.manager.NetworkConfig;
import com.triadslabs.networklayer.manager.NetworkManager;

import java.util.Locale;
/**
 * Created by MuzammilPeer on 12/21/2014.
 */
public class ICApplication extends Application {
    //variables
    public static String appLanguage = "en";
    public static final String APP_SETTINGS_FILE = "ic_preferences";


    //singleton reference
    private static ICApplication ourInstance = new ICApplication();
    public static synchronized ICApplication getInstance() {
        return ourInstance;
    }

    public ICApplication() {
    }

    //application life cycle methods
    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the singleton
        ourInstance = this;
        //setup network layer
        NetworkManager.setConfiguration(new NetworkConfig(this.getApplicationContext()));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        changeLocale(ICApplication.appLanguage);
    }

    //Localization support
    public void changeLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }


}
