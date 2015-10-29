package me.kaede.leakcanarydemo.fragmentleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import me.kaede.leakcanarydemo.R;

public class FragmentLeakActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_leak);
		LeakFragment fragment = new LeakFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.container,fragment,"").commit();
	}
}
