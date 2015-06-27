package imgdownload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ResultsToXml {

	

	public String filePath = new String("C:/Users/walid/Desktop/dump/images");
	public String fileName = new String("results.txt");
	
	public static void main ( String args[]){
	
		ResultsToXml result = new ResultsToXml();
		
		//System.out.println(img_dbPath);
		
	
	
	}
	
	
	public String readToList(String img_dbPath)
	{ String result = new String();
	  List<String> list = new ArrayList<String>();
	 String xmlResult = new String();
	  HashMap<String, Double> map = new HashMap<String, Double> ();
	  ValueComparator bvc =  new ValueComparator(map);
      TreeMap<String,Double> sorted_map = new TreeMap(bvc);
	// Collections.sort(list);
	 
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(img_dbPath+"/"+ fileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  //System.out.println (strLine);
			  result = strLine.substring(strLine.indexOf(" ")+1);
			  String imageName= strLine.substring(0,strLine.indexOf(" ")-1);
			  //System.out.println("$$"+imageName+"$$");
			  //System.out.println("#"+result+"#");
			  map.put(new String (img_dbPath+"/"+imageName), Double.valueOf(result));
			  
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			   
			    System.out.println(map.toString());
			   // Collections.sort();
			    
			  
		        sorted_map.putAll(map);
		        Collection<String> imgList = new ArrayList<String>();
		        
		        System.out.println("results");
		        for (String key : sorted_map.keySet()) {
		           // System.out.println("key/value: " + key + "/"+sorted_map.get(key));
		            imgList.add(new String(key));
		        }
		        XStream xStream = new XStream(new DomDriver());
		        xStream.alias("list", java.util.Collection.class);
		      xmlResult = xStream.toXML(imgList);
		    //  System.out.println(xmlResult);
			  return   xmlResult;
	}
	
}
