package test;

import java.net.URL;

import crawling.ContentCrawler;
import crawling.Frequency;

import websphinx.Link;

public class ContentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Frequency sub = new Frequency();
		  ContentCrawler crawler = new ContentCrawler(sub);
		    try {
		    //  crawler.setTargetDir("C:/Users/walid/Desktop/dump");
		     // crawler.init();
		      crawler.setRoot(new Link(new URL("http://www.socialistrevolution.org/1483/london-south-bank-students-occupy/")));
		      crawler.run();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		}
	
}
