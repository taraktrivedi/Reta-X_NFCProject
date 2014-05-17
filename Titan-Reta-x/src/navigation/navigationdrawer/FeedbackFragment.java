package navigation.navigationdrawer;

import file.writer.Replacer;
import zigtraka_titan.nfc.reta_x.R;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.sax.RootElement;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackFragment extends Fragment {
	private EditText mName, mReview;
	private RatingBar mRating;
	private Button mSubmit;

	public FeedbackFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_feedback, container,
				false);

		mName = (EditText) rootView
				.findViewById(R.id.fragment_feedback_nameeditText);
		mReview = (EditText) rootView
				.findViewById(R.id.fragment_feedback_revieweditText);
		mRating = (RatingBar) rootView
				.findViewById(R.id.fragment_feedback_ratingBar);
		mSubmit = (Button) rootView
				.findViewById(R.id.fragment_feedback_submitbutton);

		mSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (validationCheck(v.getContext()))
					;
				else {
					Replacer.append(mName.getText()
							.toString(), String.valueOf(mRating.getRating()), mReview.getText()
							.toString());
					Toast.makeText(v.getContext(), "Added ", Toast.LENGTH_LONG)
					.show();
					
				}
			}
		});
		
		return rootView;
	}

	private boolean validationCheck(Context c) {
		if (mName.getText().toString() == null
				|| mName.getText().toString().length() < 1) {
			Toast.makeText(c, "Please Enter Name", Toast.LENGTH_LONG).show();
			mName.requestFocus();
			return true;
		}
		if (mReview.getText().toString() == null
				|| mReview.getText().toString().length() < 1) {
			Toast.makeText(c, "Please Enter Feedback", Toast.LENGTH_LONG)
					.show();
			mReview.requestFocus();
			return true;
		}
		return false;
	}
}
