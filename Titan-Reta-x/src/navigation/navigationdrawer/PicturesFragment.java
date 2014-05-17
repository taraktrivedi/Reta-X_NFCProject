package navigation.navigationdrawer;

import java.io.File;
import java.io.FileFilter;

import pl.polidea.view.ZoomView;

import deploy.appdata.directory;

import zigtraka_titan.nfc.reta_x.R;
import android.app.Fragment;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.ImageView.ScaleType;

public class PicturesFragment extends Fragment {
	private LinearLayout gallery;
	private Context mContext;
	private File[] mPictures;
	private File mPicturesdirectory;
	private int mWidthLimit;
	private int mHeigthLimit;
	DisplayMetrics displaymetrics = new DisplayMetrics();

    private LinearLayout.LayoutParams params;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_pictures, container,
				false);

		mContext = rootView.getContext();

		displaymetrics=mContext.getResources().getDisplayMetrics();
		mHeigthLimit = displaymetrics.heightPixels -100;
		mWidthLimit = displaymetrics.widthPixels -50;
		
		gallery = (LinearLayout) rootView.findViewById(R.id.watchpicsgallery);

		mPicturesdirectory = new File(directory.titanWatchItemPicturePath);
		mPictures = mPicturesdirectory.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.isFile()
						&& (file.getName().toLowerCase().endsWith(".png") || file
								.getName().toLowerCase().endsWith(".jpg"));
			}
		});

		for (File file : mPictures) {
			Space space = new Space(mContext);
			space.setLayoutParams(new RelativeLayout.LayoutParams(100, mHeigthLimit));
			gallery.addView(space);
			gallery.addView(addImage(file));
		}
		Space space = new Space(mContext);
		space.setLayoutParams(new RelativeLayout.LayoutParams(100, mHeigthLimit));
		gallery.addView(space);

		return rootView;
	}

	public ImageView addImage(File file) {
		final ImageView imageView = new ImageView(mContext);
		imageView.setImageBitmap(BitmapFactory.decodeFile(file
				.getAbsolutePath()));
		params=new LinearLayout.LayoutParams(mWidthLimit, mHeigthLimit);
		params.gravity=Gravity.CENTER;
	
		imageView.setLayoutParams(params);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		imageView.setOnTouchListener(new OnTouchListener() {
			private boolean ZoomIn = false;
		    private float mOldDist,mNewDist;
		    private int mScale,mWidth,mHeigth;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()&event.getActionMasked()) {
				case MotionEvent.ACTION_POINTER_DOWN:
						ZoomIn=true;
						mOldDist=spacing(event);
					break;

				case MotionEvent.ACTION_MOVE:
                    if(ZoomIn){	
					mNewDist=spacing(event);
                    mScale=(int)(mOldDist-mNewDist)*10;

                    mWidth=imageView.getWidth()-mScale;
                    mHeigth=imageView.getHeight()-mScale;
					if (!( mWidth< mWidthLimit)
							&& !(mHeigth < mHeigthLimit)){
						params=new LinearLayout.LayoutParams(
								mWidth,
								mHeigth);
						params.gravity=Gravity.CENTER;	
							
						imageView.setLayoutParams(params);
				gallery.setGravity(Gravity.CENTER);
					}
}	
					break;

				default:
                    ZoomIn=false;         
					break;
				}
					
				return true;
			}
		});

		return imageView;

	}
	
	private float spacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
		}
}
