package me.kaede.leakcanarydemo.localvariable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.kaede.leakcanarydemo.ExampleApplication;
import me.kaede.leakcanarydemo.R;

public class LocalVariableActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Cat cat = new Cat();
		Box box = new Box();
		box.hiddenCat = cat;
		Docker.container = box;//The static Docker.container references the local variable box, and box references local variable cat. Cat leaks!

		ExampleApplication.getRefWatcher(this).watch(cat);//watch cat, LeakCanary would detect this leak
	}



}
