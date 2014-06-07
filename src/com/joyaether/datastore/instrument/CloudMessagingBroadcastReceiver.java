package com.joyaether.datastore.instrument;

import com.joyaether.datastore.Build;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CloudMessagingBroadcastReceiver extends BroadcastReceiver {
	
	private final String TAG = CloudMessagingBroadcastReceiver.class.getSimpleName();

	@Override
	public void onReceive(Context context, Intent intent) {
		if (Build.DEBUG) {
			Log.i(TAG, intent.getExtras().toString());
		}
	}

}
