package com.example.ppt.tempsingleec;

import android.app.Application;

import com.example.ppt.temp_coer.app.Temp;
import com.example.ppt.temp_ec.icon.FontTempModel;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Temp.init(this)
                .withHost("sddsf")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontTempModel())
                .withLogger(new AndroidLogAdapter())
                .configure();

    }

//    private void configUnits() {
//        AutoSizeConfig.getInstance().getUnitsManager()
//                .setSupportDP(false)
//                .setSupportSP(false)
//                .setSupportSubunits(Subunits.MM);
//    }

}
