package deploy.appdata;

public class directory {
public static String rootFolderPath="/sdcard/Reta-X";
public static String titanWatchesPath=rootFolderPath+"/Titan";
public static String titanWatchItemPath=titanWatchesPath+"/Nebula";
public static String titanWatchItemContentPath=titanWatchItemPath+"/Contents";
public static String titanWatchItemStoryBoardsPath=titanWatchItemPath+"/StoryBoards";
public static String titanWatchItemPicturePath=titanWatchItemPath+"/Pictures";
public static String titanWatchItemReviewPath=titanWatchItemPath+"/Reviews";
public static String titanWatchItemMiscPath=titanWatchItemPath+"/Misc";
public static String databaseFolderPath=titanWatchesPath+"/Database";
public static String databaseFilePath=databaseFolderPath+"/titanwc.sqlite";
public static String logFolderPath=titanWatchesPath+"/Log";

/***
 * 
 * Function to change directory reference regarding new item 
 */
public static void setDirectories(String Model){
	titanWatchItemPath=titanWatchesPath+"/"+Model;
	titanWatchItemContentPath=titanWatchItemPath+"/Contents";
    titanWatchItemStoryBoardsPath=titanWatchItemPath+"/StoryBoards";
    titanWatchItemPicturePath=titanWatchItemPath+"/Pictures";
	titanWatchItemReviewPath=titanWatchItemPath+"/Reviews";
	titanWatchItemMiscPath=titanWatchItemPath+"/Misc";
	databaseFolderPath=titanWatchesPath+"/Database";
	databaseFilePath=databaseFolderPath+"/titanwc.sqlite";
	logFolderPath=titanWatchesPath+"/Log";
	
}
}
