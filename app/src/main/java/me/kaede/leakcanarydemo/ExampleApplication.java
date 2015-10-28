package me.kaede.leakcanarydemo;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by kaede on 2015/10/28.
 */
public class ExampleApplication extends Application {

	public static RefWatcher getRefWatcher(Context context) {
		ExampleApplication application = (ExampleApplication) context.getApplicationContext();
		return application.refWatcher;
	}

	private RefWatcher refWatcher;

	@Override public void onCreate() {
		super.onCreate();
		refWatcher = LeakCanary.install(this);
	}
}