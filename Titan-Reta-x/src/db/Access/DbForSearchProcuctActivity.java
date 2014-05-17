package db.Access;

import mod.database.ModMainEnum;
import db.handler.DbConnector;

import android.content.ContentValues;
import android.database.Cursor;

public class DbForSearchProcuctActivity {

	/**
	 * Funtion for searching keyword in mod_main table of database
	 */
	public static Cursor searchViewResult(String keyword) {
		Cursor cursor = DbConnector.open().rawQuery(
				"SELECT * " + "FROM [mod_main]"
						+ " WHERE (substr([mod_id],1,4096) LIKE '%"
						+ keyword
						+ "%')"
						+ " OR (substr([mod_tagid],1,4096) LIKE '%"
						+ keyword
						+ "%')"
						+ " OR (substr([mod_category],1,4096) LIKE '%"
						+ keyword
						+ "%')"
						+ " OR (substr([mod_description],1,4096) LIKE '%"
						+ keyword
						+ "%')"
						+ " OR (substr([mod_model],1,4096) LIKE '%"
						+ keyword
						+ "%')"
						+ " OR (substr([mod_comments],1,4096) LIKE '%"
						+ keyword + "%')", null);

		
		return cursor;
	}

	/**
	 * Function to edit mod_main table of database
	 */
	public static void updateRowByTagID(String TagID, String ProductCode,
			String ProductModel, String Price, String Type, String Wear) {
		
		ContentValues values = new ContentValues();
		values.put("mod_id", ProductCode);
		values.put("mod_model", ProductModel);
		values.put("mod_price", Float.parseFloat(Price));
		values.put("mod_comments", Type);
		values.put("mod_category", Wear);
		DbConnector.open().update("mod_main", values, "mod_tagid = '" + TagID
				+ "'", null);
		DbConnector.close();

	}
}
