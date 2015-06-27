package imgdownload;

import java.net.URL;
import java.util.Collection;

//import matlabcall.MatlabCallTest;

import threads.CrawlingThread;
import threads.LinkStack;
import websphinx.Link;

public class ImageLinksFetcher {

	public LinkStack stackContainer =LinkStack.getInstance();
	
	public Collection<String> stack = stackContainer.links;
	
	public ImageCrawler crawler;
	
	public void downloadImg(int linkID){
		 crawler = new ImageCrawler(linkID);
		
	//	crawler.mainPath = crawler.mainPath+"/"+Integer.toString(linkID);
		
	    try {
	      crawler.setRoot(new Link(new URL((stack.toArray()[linkID]).toString())));
	      crawler.run();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		
		
	}
	
	/*public String imgFeatureExtraction( String f1, String f2, String f3 ,int linkID)
	{
		
		return MatlabCallTest.fetchObject(f1,f2,f3, crawler.mainPath+"/"+Integer.toString(linkID));
	}*/
	
}
