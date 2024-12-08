package com.charchores;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		int display_mode = getResources().getConfiguration().orientation;
		if (display_mode == 1) {
			Log.d("charlog", "\nDashboard loaded in portrait mode");
		} else if (display_mode == 2) {
			Log.d("charlog", "\nDashboard loaded in landscape mode");
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		EdgeToEdge.enable(this);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String outData = "some out data value";
		outState.putString("dataValue", outData); // Saving the Variable theWord
		Log.d("charlog", "saving: " + outData);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		String theData;
		theData = savedInstanceState.getString("dataValue"); // Restoring theWord
		Log.d("charlog", "retrieved: " + theData);
	}
}
