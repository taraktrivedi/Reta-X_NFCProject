package listview.adapters;

import java.util.ArrayList;
import java.util.List;

import zigtraka_titan.nfc.reta_x.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomFragmentReviewListAdapter extends ArrayAdapter<Object> {
	private Context mContext;
	private ArrayList<Object> mdata;
	private String[] Names;
	private float[] Ratings;
	private String[] Reviews;

	public CustomFragmentReviewListAdapter(Context context,
			int textViewResourceId, ArrayList<Object> data) {
		super(context, textViewResourceId, (String[])data.get(0));
		// TODO Auto-generated constructor stub
		mContext = context;
		mdata = data;
		if (data != null) {
			Names = (String[]) data.get(0);
			Ratings = (float[]) data.get(1);
			Reviews = (String[]) data.get(2);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.fragment_review_listview,
				parent, false);
		TextView Name = (TextView) rowView
				.findViewById(R.id.fragment_review_listview_name);
		RatingBar Rating = (RatingBar) rowView
				.findViewById(R.id.fragment_review_listview_ratingBar);
		TextView Review = (TextView) rowView
				.findViewById(R.id.fragment_review_listview_review);

			Name.setText(Names[position].toString());
			Rating.setRating(Ratings[position]);
			Review.setText(Reviews[position].toString());
		return rowView;
	}

}
