package webwatch.iomanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * This Class manages I/O of a text file considered as a dictionary for violent content
 * or any special query
 * */
public class Dictionnary {

	public static String FilePath = "badwords.txt";
	
	public static void main(String args[])
	  {
		Dictionnary dico = new Dictionnary();
		dico.append("cut");
		//System.out.println(dico.readToString());
		System.out.println(dico.listToRegEx(dico.readToList()));
		
	  }
	
	public String readToString()
	{ String result = new String();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(FilePath);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  //System.out.println (strLine);
			  result = result+ "\n" + strLine;
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			  return   result;
	}
	
	public Collection<String> readToList()
	{
		Collection<String> result = new ArrayList<String>();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(FilePath);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  
			  result.add(strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			  return   result;
	}
	public String listToRegEx(Collection<String> query)
	{ 
		String result = new String();
	
		for(Iterator<String> i = query.iterator(); i.hasNext(); )
		{
			result= result +"|"+ i.next(); 
		//	System.out.println(result);
		}
		return(result.substring(1));
	}
	
	public void append(String word)
	{
	

		      BufferedWriter bw = null;

		      try {
		         bw = new BufferedWriter(new FileWriter(FilePath, true));
		      
		         bw.write(word);
			 bw.newLine();
			 bw.flush();
		      } catch (IOException ioe) {
			 ioe.printStackTrace();
		      } finally {                       // always close the file
			 if (bw != null) try {
			    bw.close();
			 } catch (IOException ioe2) {
			    // just ignore it
			 }
		      } // end try/catch/finally

		  
		
	}
	
	
	
}
