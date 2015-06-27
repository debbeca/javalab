package seo.crawlers.test;

import imgdownload.ImageCrawler;

import java.net.URL;

import seo.crawlers.HnCrawler;

import websphinx.Link;

public class HnContentTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HnCrawler crawler = new HnCrawler(3);
		    try {
		   /*
		    *   http://fr.openclassrooms.com/
		    * 
		    * http://voitures.com/
		    * */
		    	
		      crawler.setRoot(new Link(new URL("http://www.hyperassur.com/")));
		      crawler.run();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		}
	
}
