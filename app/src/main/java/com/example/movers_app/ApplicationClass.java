package com.example.movers_app;
import android.app.Application;
import com.onesignal.OneSignal;

public class ApplicationClass extends Application{
    private static final String ONESIGNAL_APP_ID = "ebfef1a0-05d8-4652-8d29-01042ef61b93";

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

}
