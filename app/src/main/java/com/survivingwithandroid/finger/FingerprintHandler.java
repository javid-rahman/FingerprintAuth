package com.survivingwithandroid.finger;

/*
 * Copyright (C) 2016 Surviving with Android (http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.TextView;

/**
 * Created by francesco on 29/11/16.
 */


public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private TextView tv;
    public static boolean AuthResult = false ;

    public FingerprintHandler(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        tv.setText("Auth Error !!");
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        AuthResult = true ;
        tv.setText("Authentication Successful");
        tv.setTextColor(tv.getContext().getResources().getColor(android.R.color.holo_green_dark));
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        tv.setText("Authentication Failed !!");
    }

    public void doAuth(FingerprintManager manager, FingerprintManager.CryptoObject obj) {
        CancellationSignal signal = new CancellationSignal();

        try {
            manager.authenticate(obj, signal, 0, this, null);
        }
        catch(SecurityException sce) {}
    }

}
