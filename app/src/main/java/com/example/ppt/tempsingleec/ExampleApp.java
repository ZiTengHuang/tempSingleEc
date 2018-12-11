package com.example.ppt.tempsingleec;

import android.app.Application;

import com.example.ppt.temp_coer.app.Mike;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.interceptor.HttpLoggingInterceptor;
import com.example.ppt.temp_ec.icon.FontTempModel;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Mike.init(this)
                .withApiHost(Constants.SERVER)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontTempModel())
                .withLogger(new AndroidLogAdapter())
                .withInterceptor(logging)
                .configurator();

    }

//    private void configUnits() {
//        AutoSizeConfig.getInstance().getUnitsManager()
//                .setSupportDP(false)
//                .setSupportSP(false)
//                .setSupportSubunits(Subunits.MM);
//    }

}
