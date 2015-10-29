package me.kaede.leakcanarydemo.fragmentleak;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import me.kaede.leakcanarydemo.ExampleApplication;
import me.kaede.leakcanarydemo.R;
import me.kaede.leakcanarydemo.activityleak.ActivityLeakActivity;
import me.kaede.leakcanarydemo.activityleak.IDownLoadListener;


public class LeakFragment extends Fragment implements IDownLoadListener {


	public LeakFragment() {
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_leak, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ActivityLeakActivity.DownloadTask asyncTask = new ActivityLeakActivity.DownloadTask();
		asyncTask.execute(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ExampleApplication.getRefWatcher(getContext()).watch(this);
	}

	@Override
	public void onSuccess() {
		Toast.makeText(getContext(), "Download Success", Toast.LENGTH_LONG).show();
	}
}
