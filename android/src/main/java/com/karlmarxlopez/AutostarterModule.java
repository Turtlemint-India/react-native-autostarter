package com.karlmarxlopez;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.judemanutd.autostarter.AutoStartPermissionHelper;

import javax.annotation.Nonnull;


public class AutostarterModule extends ReactContextBaseJavaModule {
    public static ReactApplicationContext reactContext;

    AutostarterModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Nonnull
    @Override
    public String getName() {
        return "AutoStarter";
    }

    @ReactMethod
    public void getAutoStartPermission(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        promise.resolve(AutoStartPermissionHelper.getInstance().getAutoStartPermission(currentActivity));
    }

    @ReactMethod
    public void isAutoStartPermissionAvailable(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.resolve(false);
            return;
        } else {
            promise.resolve(AutoStartPermissionHelper.getInstance().isAutoStartPermissionAvailable(currentActivity));
        }
    }
}
