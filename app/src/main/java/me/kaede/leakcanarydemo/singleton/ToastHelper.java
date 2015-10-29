package me.kaede.leakcanarydemo.singleton;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kaede on 2015/10/29.
 */
public class ToastHelper {
	static ToastHelper instance;
	Context context;

	public static ToastHelper getInstance(Context context){
		if (instance==null){
			synchronized (ToastHelper.class){
				instance = new ToastHelper(context);
			}
		}
		return instance;
	}

	private ToastHelper(Context context){
		this.context =context;
	}

	public void toast(String msg){
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}
