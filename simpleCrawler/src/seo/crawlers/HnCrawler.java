package seo.crawlers;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import websphinx.Crawler;
import websphinx.DownloadParameters;
import websphinx.Link;
import websphinx.Page;

public class HnCrawler extends Crawler{
   public int hnDepth ; 
   
	public HnCrawler() {
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
	public HnCrawler( int hndepth) {
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
        String indentation = new String("");
        /*for (int i=1;i<= hnDepth; i++)
        {	
        	indentation = indentation.concat("-");
        	String hnTag = "h"+Integer.toString(i);
            Elements el = doc.select(hnTag);
	        for (Iterator it = el.iterator() ; it.hasNext();)
	        {
	        	Element hn = (Element) it.next();
	        	// System.out.println(hn);
	        		System.out.println(indentation+hn.ownText());
	        }	
	        
        }*/
        
        Elements h3links = doc.select("h1,h2,h3,h4");
        for (Iterator itt = h3links.iterator() ; itt.hasNext();)
        {
        	Element hh = (Element) itt.next();
        	System.out.println(hh.tagName());
        	
        	System.out.println(hh.ownText());
        }
        
    }

	public int getHnDepth() {
		return hnDepth;
	}

	public void setHnDepth(int hnDepth) {
		this.hnDepth = hnDepth;
	}
	
    
    
}
