package webwatch.crawling.test;

import java.util.ArrayList;
import java.util.Collection;

import webwatch.threads.CrawlingThread;
import webwatch.threads.LinkStack;

public class AlertSender {

	  public AlertSender() {
	        super();
	        // TODO Auto-generated constructor stub
	       /* BinObserver obs = new BinObserver();
			obs.sendMessage();*/
	    	System.out.println("Alert Sender Instanciated");

	    	LinkStack stack = LinkStack.getInstance();
	    	stack.add("http://docs.oracle.com/javase/1.5.0/docs/guide/language/foreach.html");
	    	stack.add("http://wildjungleharry.blogspot.fr/2011/08/bang-bang-i-shot-him-down-bang-bang-he.html?zx=2f8b40d9d4a8aeb0");
	    	stack.add("http://sujitpal.blogspot.com/2008/03/crawling-web-pages-with-websphinx.html");
	    	stack.add("http://wddc.blogspot.com/2012/01/writing-java-code-in-blogger-posts.html");
	    	
	    	Collection<CrawlingThread> threads = new ArrayList<CrawlingThread>();
	    	
	    	for ( int i =0; i < stack.size(); i++){
	    		(new Thread(new CrawlingThread(Integer.toString(i), (String) stack.links.toArray()[i]))).start();
	    	}
	    	
	    }
}
