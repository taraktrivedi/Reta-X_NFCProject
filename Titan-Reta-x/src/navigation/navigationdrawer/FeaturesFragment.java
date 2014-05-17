package navigation.navigationdrawer;

import java.util.ArrayList;

import zigtraka_titan.nfc.reta_x.R;

import deploy.appdata.directory;

import file.reader.ContentReader;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FeaturesFragment extends Fragment {
	private TextView textview;

	public FeaturesFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_features, container,
				false);

		textview = (TextView) rootView
				.findViewById(R.id.fragment_features_textView);
		StringBuilder result = new StringBuilder();

		ArrayList<String> features = ContentReader.getToFromContents(
				directory.titanWatchItemContentPath + "/TitanWatchContent.txt",
				"$FeatureContent=");
		if (features != null) {
			for (int i = 0; i < features.size(); i++)
				result.append("* " + features.get(i).toString() + "\n\n");
		} else
			Toast.makeText(rootView.getContext(), "No Content File On Sdcard",
					Toast.LENGTH_SHORT).show();
		textview.setText(result.toString());
		return rootView;
	}
}
