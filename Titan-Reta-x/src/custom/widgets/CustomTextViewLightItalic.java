package custom.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextViewLightItalic extends TextView {

	public CustomTextViewLightItalic(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		createFont();
	}

	public CustomTextViewLightItalic(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		createFont();
	}

	public CustomTextViewLightItalic(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		createFont();
	}

	public void createFont(){
		Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-LightItalic.ttf"); 
        setTypeface(font);
	}

}
