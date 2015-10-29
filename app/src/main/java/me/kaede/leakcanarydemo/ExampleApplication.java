package me.kaede.leakcanarydemo;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/10/28.
 */
public class ExampleApplication extends Application {

	public static RefWatcher getRefWatcher(Context context) {
		ExampleApplication application = (ExampleApplication) context.getApplicationContext();
		return application.refWatcher;
	}

	public List<View> getViews() {
		return views;
	}

	List<View> views;

	private RefWatcher refWatcher;

	@Override public void onCreate() {
		super.onCreate();
		refWatcher = LeakCanary.install(this);
		views = new ArrayList<>();
	}
}