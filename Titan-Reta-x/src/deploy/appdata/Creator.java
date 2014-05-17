package deploy.appdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import zigtraka_titan.nfc.reta_x.MyDatabaseHelper;


public class Creator {
	
	public static void deploy(Context applicationContext) {
		try {
		new File(directory.databaseFolderPath).mkdirs();
		new File(directory.titanWatchesPath).mkdirs();
		new File(directory.titanWatchItemPath).mkdirs();
		new File(directory.titanWatchItemStoryBoardsPath).mkdirs();
		new File(directory.titanWatchItemContentPath).mkdirs();
		new File(directory.titanWatchItemPicturePath).mkdirs();
		new File(directory.titanWatchItemReviewPath).mkdirs();
		new File(directory.titanWatchItemMiscPath).mkdirs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
