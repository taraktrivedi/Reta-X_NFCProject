package navigation.navigationdrawer;

import java.util.ArrayList;

import deploy.appdata.directory;

import file.reader.ContentReader;

import listview.adapters.CustomFragmentReviewListAdapter;
import zigtraka_titan.nfc.reta_x.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ReviewsFragment extends Fragment {
	private ListView mReviewList;
	private String[] mCustomerNames, mCustomerReviews,
			mRatingsInString;
	private float[] mCustomerRatings;
    private ArrayList<Object> mData;
	public ReviewsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_review, container,
				false);

		mReviewList = (ListView) rootView
				.findViewById(R.id.fragment_review_listView);
		
		ArrayList<String> Temp;
		Temp=ContentReader.getToFromContents(directory.titanWatchItemReviewPath+"/TitanWatchNebulaReviews.txt", "$CustomerName=");
		mCustomerNames=new String[Temp.size()];
		mCustomerNames=Temp.toArray(mCustomerNames);
		
		Temp=ContentReader.getToFromContents(directory.titanWatchItemReviewPath+"/TitanWatchNebulaReviews.txt", "$CustomerRating=");
		mRatingsInString=new String[Temp.size()];
		mRatingsInString=Temp.toArray(mRatingsInString);
		
		Temp=ContentReader.getToFromContents(directory.titanWatchItemReviewPath+"/TitanWatchNebulaReviews.txt", "$CustomerReview=");
		mCustomerReviews=new String[Temp.size()];
		mCustomerReviews=Temp.toArray(mCustomerReviews);
		
				
		mCustomerRatings=new float[mRatingsInString.length];
		//convert ratings retrieved in string to float.....
		for(int i=0;i<mRatingsInString.length;i++){
			mCustomerRatings[i]=Float.parseFloat(mRatingsInString[i]);				
		}
		
		mData=new ArrayList<Object>();
		mData.add(mCustomerNames);
		mData.add(mCustomerRatings);
		mData.add(mCustomerReviews);
		
						mReviewList.setAdapter(new CustomFragmentReviewListAdapter(rootView
				.getContext(), android.R.layout.simple_list_item_1, mData));
		return rootView;
	}
}
