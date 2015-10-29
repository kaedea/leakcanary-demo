package me.kaede.leakcanarydemo.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import me.kaede.leakcanarydemo.ExampleApplication;
import me.kaede.leakcanarydemo.R;

public class ApplicationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_application_leak);

		ExampleApplication application = (ExampleApplication) getApplication();
		View textView = this.findViewById(R.id.tv);
		application.getViews().add(textView);
	}
}
