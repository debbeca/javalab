package test;

import java.net.URL;

import websphinx.Link;
import webwatch.crawling.ContentCrawler;
import webwatch.crawling.Frequency;

public class ContentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Frequency sub = new Frequency();
		  ContentCrawler crawler = new ContentCrawler(sub , 1 );
		    try {
		    	System.out.println("start");
		      crawler.setRoot(new Link(new URL("http://www.noswearing.com/dictionary")));
		      crawler.run();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		}
	
}
