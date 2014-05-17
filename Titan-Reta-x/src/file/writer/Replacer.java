package file.writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import deploy.appdata.directory;



public class Replacer {

	public static void append(String Name,String Rating, String Review) {
		// TODO Auto-generated method stub
		try{
		final File file = new File(directory.titanWatchItemReviewPath+"/TitanWatchNebulaReviews.txt");
		   
		final BufferedReader reader = new BufferedReader(new FileReader(file));
		final StringBuilder contents = new StringBuilder();
		while(reader.ready()) {
		     contents.append(reader.readLine());
		}
		contents.append("\n\n");
		contents.append("$CustomerName="+Name+";\n");
		contents.append("$CustomerRating="+Rating+";\n");
		contents.append("$CustomerReview="+Review+";\n");
		
		reader.close();
		       final String stringContents = contents.toString();
		       if(stringContents!=null) {
		           
		           final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		           writer.write(stringContents);
		           writer.close();
		           System.out.println("done");
		       }
		}catch(Exception e){
			e.printStackTrace();
		}
		   }		
	}


