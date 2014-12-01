package com.comfyard.moodalpha.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by moredream on 11/14/14.
 */
public class AuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {

        Authenticator authenticator = new Authenticator(this);
        return authenticator.getIBinder();
    }
}