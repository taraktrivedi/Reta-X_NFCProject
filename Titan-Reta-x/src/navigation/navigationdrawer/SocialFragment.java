package navigation.navigationdrawer;


import zigtraka_titan.nfc.reta_x.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SocialFragment extends Fragment {
	
	public SocialFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.social_fragment, container, false);
         
        return rootView;
    }
}
