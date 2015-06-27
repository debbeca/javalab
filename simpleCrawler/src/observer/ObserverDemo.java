package observer;

import java.net.URL;
import java.util.Scanner;

import websphinx.Link;
import crawling.ContentCrawler;
import crawling.Frequency;

public class ObserverDemo {
	  public static void main( String[] args ) {
		  Frequency sub = new Frequency();
		  new BinObserver( sub );
		  ContentCrawler crawler = new ContentCrawler(sub);
		    try {
		     
		      while(true){
		    	
		     crawler.setRoot(new Link(new URL("http://wildjungleharry.blogspot.com/2011/08/bang-bang-i-shot-him-down-bang-bang-he.html")));
		      crawler.run();
		      crawler.clear();
		      Thread.sleep (1000);
		      }
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		
		  
	   
	   
	    
	   
	  }
	}