package course.examples.UI.GridLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	
		// Get the Intent used to start this Activity
		Intent intent = getIntent();
		
		// Make a new ImageView
		// Example of programmatic layout definition
		ImageView imageView = new ImageView(getApplicationContext());
		
		// Get the ID of the image to display and set it as the image for this ImageView
		imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));

		setContentView(imageView);

		final int pos = intent.getIntExtra("pos", 0);

		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// display text

				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(ImageViewActivity.this,
						displayTextActivity.class);

				// Add the ID of the thumbnail to display as an Intent Extra
				//intent.putExtra(EXTRA_RES_ID, (int) id);
				intent.putExtra("pos", pos);

				Log.i("OnImageViewClick", "Image clicked! Dislpay Text");

				// Start the ImageViewActivity
				startActivity(intent);
			}


		});
	}
}