package db.Access;

import mod.database.ModMainEnum;
import db.handler.DbConnector;
import android.database.Cursor;

public class DbForGetProductInformationActivity {
	
	
    /**
	 *Function to get model using tagid 
	 */
	public static String getModel(String TagID) {
		Cursor cursor = DbConnector.open().rawQuery("SELECT "+ModMainEnum.ModMain.Model+" FROM mod_main where mod_tagid ='" + TagID + "'",
				null);
		if (cursor.moveToFirst()) {
			return cursor.getString(0);
		}
		DbConnector.close();
		return null;
	}

}
