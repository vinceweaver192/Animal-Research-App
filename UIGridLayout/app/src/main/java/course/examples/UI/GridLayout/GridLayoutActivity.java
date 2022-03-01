package course.examples.UI.GridLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

//This application uses some deprecated methods. 
//See UIViewPager for a more modern version of this application

public class GridLayoutActivity extends Activity {

	protected static final String EXTRA_RES_ID = "POS";

	String[] urlList = {"https://en.wikipedia.org/wiki/Duck", "https://en.wikipedia.org/wiki/Hedgehog",
					"https://en.wikipedia.org/wiki/Bear", "https://en.wikipedia.org/wiki/Leopard",
					"https://en.wikipedia.org/wiki/Lizard", "https://en.wikipedia.org/wiki/Penguin",
					"https://en.wikipedia.org/wiki/pig", "https://en.wikipedia.org/wiki/Polar_bear",
					"https://en.wikipedia.org/wiki/Scorpion", "https://en.wikipedia.org/wiki/Teddy_bear",
					"https://en.wikipedia.org/wiki/Giant_panda", "https://en.wikipedia.org/wiki/Whale"};

	ArrayList animalList = new ArrayList<>();

	int index;
	int theID;

	private String[] animalNames = {"Duck", "Hedge", "Bear",
									"Leopard", "Lizard", "Penguin",
									"Pig", "Polar Bear", "Scorpion",
									"Grizzly Bear", "Panda", "Whale"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		animalList.add(new Item(animalNames[0],R.drawable.baby_duck, animalNames[0]));
		animalList.add(new Item(animalNames[1],R.drawable.hedgehog, animalNames[1]));
		animalList.add(new Item(animalNames[2],R.drawable.cub, animalNames[2]));
		animalList.add(new Item(animalNames[3],R.drawable.leopard, animalNames[3]));
		animalList.add(new Item(animalNames[4],R.drawable.lizard, animalNames[4]));
		animalList.add(new Item(animalNames[5],R.drawable.penguin, animalNames[5]));
		animalList.add(new Item(animalNames[6],R.drawable.pig, animalNames[6]));
		animalList.add(new Item(animalNames[7],R.drawable.polar_bear, animalNames[7]));
		animalList.add(new Item(animalNames[8],R.drawable.scorpion, animalNames[8]));
		animalList.add(new Item(animalNames[9],R.drawable.teddy_bear, animalNames[9]));
		animalList.add(new Item(animalNames[10],R.drawable.panda, animalNames[10]));
		animalList.add(new Item(animalNames[11],R.drawable.whale, animalNames[11]));

		//MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,birdList);
		ImageAdapter myAdapter = new ImageAdapter(this, R.layout.grid_item, animalList);

		//simpleList.setAdapter(myAdapter);
		gridview.setAdapter(myAdapter);

		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) id);

				// stores the grid position that the user clicked
				intent.putExtra("pos", position);

				Log.i("mainActivity", "id selected: " + v.getId());
				Log.i("mainActivity", "real id is: " + id);
				Log.i("mainActivity", "position is: " + position);
				
				// Start the ImageViewActivity
				startActivity(intent);
			}
		});

		// make the gridview able to be access the menu
		registerForContextMenu(gridview);

		gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
										   int position, long arg3) {
				//startImageGalleryActivity(position);
				Log.i("mainActivity", "the new long click");
				Log.i("mainActivity", "position of grid selected = " + position);
				Log.i("mainActivity", "ID of grid selected = " + arg3);

				index = position;
				theID = (int) arg3;

				return false;
			}
		});
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		getMenuInflater().inflate(R.menu.menu_options, menu);
	}

	// select an item once menu appears
	@Override
	public boolean onContextItemSelected(@NonNull MenuItem item) {
		switch(item.getItemId()){
			case R.id.option_1:
				Toast.makeText(this,"option 1 selected", Toast.LENGTH_SHORT).show();
				//Create an Intent to start the ImageViewActivity

				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);

				intent.putExtra(EXTRA_RES_ID, (int) theID);
				intent.putExtra("pos", index);

				// Start the ImageViewActivity
				startActivity(intent);

				Log.i("mainActivity", "option 1 selected: " + intent.getStringExtra("pos"));

				return true;
			case R.id.option_2:
				Toast.makeText(this,"option 2 selected", Toast.LENGTH_SHORT).show();

				// display text

				//Create an Intent to start the ImageViewActivity
				Intent intent2 = new Intent(GridLayoutActivity.this,
						displayTextActivity.class);

				// Add the ID of the thumbnail to display as an Intent Extra
				intent2.putExtra("pos", index);

				Log.i("OnImageViewClick", "Image clicked! Dislpay Text");

				// Start the ImageViewActivity
				startActivity(intent2);

				return true;
			case R.id.option_3:
				Toast.makeText(this,"option 3 selected", Toast.LENGTH_SHORT).show();

				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( urlList[index] ) );

				startActivity( browse );

				return true;
			default:
				return super.onContextItemSelected(item);
		}
	}
}