package file.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import deploy.appdata.directory;

public class ContentReader {
	private static boolean flag = false;
	static StringBuilder tempName;
	static ArrayList<String> result;

	public static ArrayList<String> getToFromContents(String FilePath,String Start) {
		try {
			FileInputStream fstream = new FileInputStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			tempName = new StringBuilder();
			// Loop through and check if a header or footer line, if not
			// equate a substring to a temp variable and print it....
			while ((strLine = br.readLine()) != null) {
				tempName.append(strLine);
			}

			Matcher matcher = Pattern.compile(Pattern.quote(Start)+"(.*?)"+Pattern.quote(";") ).matcher(
					tempName.toString());
			result=new ArrayList<String>();
			
			while (matcher.find()) {
				result.add( matcher.group(1));
			}
			// Close the input stream
			fstream.close();
		} catch (Exception e) {
			
		}
		return result;
	}
}
