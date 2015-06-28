package seo.crawlers.test;

import java.net.URL;

import seo.crawlers.LuceneKeywordCrawler;
import websphinx.Link;

public class LuceneKeywordCrawlerTest {

	public static void main (String[] args){
		
		
		LuceneKeywordCrawler crawler = new LuceneKeywordCrawler(1);
		    try {
		   /*
		    *   http://fr.openclassrooms.com/
		    * 
		    * http://voitures.com/
		    * */
		    	
		      crawler.setRoot(new Link(new URL("https://en.wikipedia.org/wiki/Spring_Framework")));
		      crawler.run();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		}
}
