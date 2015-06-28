package seo.crawlers;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import seo.crawlers.util.Keyword;
import websphinx.Crawler;
import websphinx.DownloadParameters;
import websphinx.Link;
import websphinx.Page;

public class LuceneKeywordCrawler extends Crawler{

	   public int hnDepth ; 
	   
		public LuceneKeywordCrawler() {
			super();
			 DownloadParameters dp = new DownloadParameters();
			 
			    dp.changeObeyRobotExclusion(true);
			    //dp.changeUserAgent(userAgent)
			    dp.changeUserAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
			    setDownloadParameters(dp);
				// Do what the parent  crawler would do
			    // crawl only subtree of the web page
		        setDomain(Crawler.SUBTREE);
		        //do not go any deeper than the page itself
		        setMaxDepth(0);
		      
		}
		public LuceneKeywordCrawler( int hndepth) {
			super();
			 DownloadParameters dp = new DownloadParameters();
			 
			    dp.changeObeyRobotExclusion(true);
			    //dp.changeUserAgent(userAgent)
			    dp.changeUserAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
			    setDownloadParameters(dp);
				// Do what the parent  crawler would do
			    // crawl only subtree of the web page
		        setDomain(Crawler.SUBTREE);
		        //do not go any deeper than the page itself
		        setMaxDepth(0);
		        hnDepth = hndepth;
		}
		
		
		

		 // We could choose not to visit a link based on certain circumstances
	    // For now we always visit the link
	    public boolean shouldVisit(Link l) {
	        //String host = l.getHost();
	        return true; // always visit a link
	    }
		
	    // What to do when we visit the page
	    public void visit(Page page) {
	    	
	        //System.out.println("Visiting: " + page.getTitle());
	        String content = page.getContent();
	        // System.out.println("Visiting...  : "+ page.getTitle());
	        Document doc = Jsoup.parse(page.getContent());
	        String text = doc.body().text();
	        System.out.println(text);
	        try {
				System.out.println(Keyword.guessFromString(text));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	    }

		public int getHnDepth() {
			return hnDepth;
		}

		public void setHnDepth(int hnDepth) {
			this.hnDepth = hnDepth;
		}
		
	    
	    
	}