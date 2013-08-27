/*
 Copyright 2013 The MITRE Corporation, All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this work except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package org.mitre.svmp.events;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author Joe Portner
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = BootBroadcastReceiver.class.getName();

    public void onReceive(Context context, Intent intent) {
        // we receive the BOOT_COMPLETED broadcast intent to start this service as soon as the phone boots up
        if( intent.getAction().equals("android.intent.action.BOOT_COMPLETED") ) {
            Log.d(TAG, "Received system boot intent broadcast");

            // start the EventServer if it hasn't been started
            context.startService( new Intent(context, BackgroundService.class) );
        }
    }
}
