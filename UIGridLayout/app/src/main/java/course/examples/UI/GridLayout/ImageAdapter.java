package course.examples.UI.GridLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImageAdapter extends ArrayAdapter {
	//private static final int PADDING = 8;

	private ArrayList animalList = new ArrayList<>();
	//private int[] image;

	public ImageAdapter(Context context, int textViewResourceId, ArrayList objects) {
		super(context, textViewResourceId, objects);
		animalList = objects;
	}
	// Save the list of image IDs and the context

	// Now the methods inherited from abstract superclass BaseAdapter

	// Return the number of items in the Adapter
	@Override
	public int getCount() {
		return super.getCount();
	}

	// Return the data item at position
	@Override
	public Object getItem(int position) {
		return animalList.get(position);
	}

	// Will get called to provide the ID that
	// is passed to OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return (((Item)animalList.get(position)).getAnimalImage());
	}

	// Return an ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v;
		v = convertView;
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.grid_item, null);
		TextView textView = (TextView) v.findViewById(R.id.item_name);
		ImageView imageView = (ImageView) v.findViewById(R.id.grid_image);

		textView.setText(((Item)animalList.get(position)).getAnimalName());
		imageView.setImageResource(((Item)animalList.get(position)).getAnimalImage());
//		imageView.setScaleType();


		return v;
	}

}
