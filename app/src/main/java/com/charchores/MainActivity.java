package com.charchores;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private int progressStatus = 0;
	private final Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);
		Log.d("charlog", "Starting loader...");
		ProgressBar progressBar = findViewById(R.id.progressBar);

		// Start long running operation in a background thread
		new Thread(new Runnable() {
			public void run() {
				while (progressStatus < 100) {
					progressStatus += 4;
					// Update the progress bar and display the
					//current value in the text view
					handler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(progressStatus);
						}
					});
					try {
						// Sleep for 200 milliseconds.
						Thread.sleep(80);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				loadMainWindow();
			}
		}).start();
	}

	private void loadMainWindow() {
		Log.d("charlog", "Switching to dashboard...");
		Intent myIntent = new Intent(this, DashboardActivity.class);
		startActivity(myIntent);
	}


}