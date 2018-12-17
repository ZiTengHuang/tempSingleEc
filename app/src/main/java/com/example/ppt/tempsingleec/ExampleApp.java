package com.example.ppt.tempsingleec;

import android.app.Application;

import com.example.ppt.temp_coer.app.Mike;
import com.example.ppt.temp_coer.net.api.Constants;
import com.example.ppt.temp_coer.net.interceptor.TestInterceptor;
import com.example.ppt.temp_ec.database.DataBaseManager;
import com.example.ppt.temp_ec.icon.FontBottomModel;
import com.example.ppt.temp_ec.icon.FontTempModel;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Mike.init(this)
                .withApiHost(Constants.SERVER)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontTempModel())
                .withIcon(new FontBottomModel())
                .withLogger(new AndroidLogAdapter())
                .withInterceptor(new TestInterceptor())
                .configurator();
        initStetho();
        DataBaseManager.getInstance().init(this);

//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    /**
     * facebook的那个映射库，在googl输入：chrome:inspect查看
     */
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }

//    private void configUnits() {
//        AutoSizeConfig.getInstance().getUnitsManager()
//                .setSupportDP(false)
//                .setSupportSP(false)
//                .setSupportSubunits(Subunits.MM);
//    }

}
