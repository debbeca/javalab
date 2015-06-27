package threads;

import java.net.URL;

import websphinx.Link;
import crawling.ContentCrawler;
import crawling.Frequency;
import observer.BinObserver;
public class CrawlingThread implements Runnable  {
public String threadID;
	public String link;
	
	
	public CrawlingThread(String link) {
	
		// TODO Auto-generated constructor stub
	this.link = link;
	
	}
	 

	public CrawlingThread( String ID, String link) {
	
		// TODO Auto-generated constructor stub
		this.threadID = ID;
		this.link = link;
	
	}

	public void run() {
		 Frequency sub = new Frequency();
		  new BinObserver( sub );
		  ContentCrawler crawler = new ContentCrawler(sub);
		  try {
			Thread.sleep( 200 );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    try {
		     
		      while(true){
		    	System.out.println(this.threadID+" is working...\n" );
		     crawler.setRoot(new Link(new URL(link)));
		      crawler.run();
		      crawler.clear();
		      Thread.sleep (5000);
		      }
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		
		
	}

}
