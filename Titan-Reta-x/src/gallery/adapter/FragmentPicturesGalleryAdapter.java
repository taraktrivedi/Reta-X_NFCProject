package gallery.adapter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.zip.Inflater;

import deploy.appdata.directory;

import zigtraka_titan.nfc.reta_x.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentPicturesGalleryAdapter extends BaseAdapter{

	private Context mContext;
	private int mGalleryItemBackground;
    private ArrayList<String> mContent;
    private ArrayList<String> mTitle;
    
	public FragmentPicturesGalleryAdapter(Context c,ArrayList<String> Content,ArrayList<String> Title){
		mContext = c;
		mContent=Content;
		mTitle=Title;
		
		TypedArray attr =
		mContext.obtainStyledAttributes(R.styleable.HelloGallery);
		mGalleryItemBackground =
		attr.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground, 0);
		attr.recycle();
		   
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mContent.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View view=inflater.inflate(R.layout.fragment_storyboard_customgallery, parent, false);
        
        TextView mContentText = (TextView) view
				.findViewById(R.id.storyboardtextview);
        TextView mtitleText = (TextView) view
				.findViewById(R.id.storyboardtitletextView);

        mContentText.setText(mContent.get(position).toString());
        mtitleText.setText(mTitle.get(position).toString());
        
		return view;
	}

}
