package me.kaede.leakcanarydemo.singleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import me.kaede.leakcanarydemo.R;

public class SingletonActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singleton);
	}

	public void onToast(View view){
		ToastHelper.getInstance(this).toast("Toast something!");
	}
}
