package me.kaede.leakcanarydemo.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import me.kaede.leakcanarydemo.activityleak.ActivityLeakActivity;
import me.kaede.leakcanarydemo.fragmentleak.FragmentLeakActivity;
import me.kaede.leakcanarydemo.home.ActivityHolder;
import me.kaede.leakcanarydemo.home.view.IHomeView;
import me.kaede.leakcanarydemo.localvariable.LocalVariableActivity;
import me.kaede.leakcanarydemo.singleton.SingletonActivity;
import me.kaede.leakcanarydemo.viewleak.ViewLeakActivity;


/**
 * Created by kaede on 2015/5/19.
 */
public class HomePresenterCompl implements IHomePresenter {
	public static ActivityHolder activityHolder;

	static {
		activityHolder = new ActivityHolder();
		activityHolder.addActivity("Local Variable Leak", LocalVariableActivity.class);
		activityHolder.addActivity("Activity Leak", ActivityLeakActivity.class);
		activityHolder.addActivity("Fragment Leak", FragmentLeakActivity.class);
		activityHolder.addActivity("View Leak", ViewLeakActivity.class);
		activityHolder.addActivity("Singleton Leak", SingletonActivity.class);
	}

	Context context;
	IHomeView homeView;

	public HomePresenterCompl(Context context, IHomeView homeView) {
		this.context = context;
		this.homeView = homeView;
	}

	@Override
	public void loadDatas() {

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				homeView.onGetDataList(activityHolder.getNameList());
			}
		}, 2000);
	}

	@Override
	public void onItemClick(int position) {
		Class activity = activityHolder.getActivity(activityHolder.getNameList().get(position));
		if (activity != null) {
			context.startActivity(new Intent(context, activity));
		}
	}
}
