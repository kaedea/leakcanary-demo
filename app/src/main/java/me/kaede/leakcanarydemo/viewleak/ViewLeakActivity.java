package me.kaede.leakcanarydemo.viewleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import me.kaede.leakcanarydemo.R;
import me.kaede.leakcanarydemo.singleton.ToastHelper;

public class ViewLeakActivity extends AppCompatActivity {

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_leak);
		textView = (TextView) findViewById(R.id.tv);
	}

	public void onAdd(View view){
		TextViewHelper.getInstance(textView).add();
	}
}
