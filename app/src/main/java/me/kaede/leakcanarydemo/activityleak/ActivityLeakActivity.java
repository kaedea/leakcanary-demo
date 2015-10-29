package me.kaede.leakcanarydemo.activityleak;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import me.kaede.leakcanarydemo.R;

public class ActivityLeakActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leak);

		DownloadTask asyncTask = new DownloadTask();
		asyncTask.execute(new IDownLoadListener() {
			@Override
			public void onSuccess() {
				Toast.makeText(ActivityLeakActivity.this,"Download Success",Toast.LENGTH_LONG).show();
			}
		});
	}


	public static class DownloadTask extends AsyncTask<IDownLoadListener,Void,IDownLoadListener>{

		@Override
		protected IDownLoadListener doInBackground(IDownLoadListener... params) {
			try {
				Thread.sleep(20000);
			} catch (Throwable t) {
				t.printStackTrace();
			}
			return params[0];
		}

		@Override
		protected void onPostExecute(IDownLoadListener iDownLoadListener) {
			super.onPostExecute(iDownLoadListener);
			if (iDownLoadListener!=null){
				iDownLoadListener.onSuccess();
			}
		}
	}
}
