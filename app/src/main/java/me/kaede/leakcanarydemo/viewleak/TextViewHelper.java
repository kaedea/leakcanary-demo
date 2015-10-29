package me.kaede.leakcanarydemo.viewleak;

import android.widget.TextView;

/**
 * Created by kaede on 2015/10/29.
 */
public class TextViewHelper {
	private static TextViewHelper ourInstance;

	TextView textView;
	public static TextViewHelper getInstance(TextView textView) {
		if (ourInstance == null){
			synchronized (TextViewHelper.class){
				ourInstance = new TextViewHelper(textView);
			}
		}
		return ourInstance;
	}

	private TextViewHelper(TextView textView) {
		this.textView = textView;
	}

	public void add(){
		int num = Integer.valueOf(textView.getText().toString());
		textView.setText(String.valueOf(++num));
	}
}
