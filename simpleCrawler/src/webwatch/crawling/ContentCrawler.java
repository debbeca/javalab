package webwatch.crawling;




import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import websphinx.Crawler;
import websphinx.DownloadParameters;
import websphinx.Link;
import websphinx.Page;
import webwatch.iomanager.Dictionnary;


// Our own Crawler class extends the WebSphinx Crawler
public class ContentCrawler extends Crawler {
   public Frequency frq ;
	public ContentCrawler( Frequency fr , int depth) {
        super();  // Do what the parent  crawler would do
        setDomain(Crawler.SUBTREE);
        setMaxDepth(depth);
        frq= fr;
    }
    
	public ContentCrawler( Frequency fr ) {
        super();  // Do what the parent  crawler would do
        setDomain(Crawler.SUBTREE);
        setMaxDepth(0);
        frq= fr;
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
        System.out.println("Visiting.. : "+ page.getTitle());
        //System.out.println("LINK : "+ page.getOrigin().toHTML());
        /*try {
            Thread.sleep(1000L);
          } catch (InterruptedException e) {;}
          */
        	  
        // Trivial example, searching for the word  from dico
        Dictionnary dico = new Dictionnary();
        Pattern p = Pattern.compile(dico.listToRegEx(dico.readToList()),Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);
        int occurence = 0;
        HashSet set = new HashSet();
        
        while (m.find()) {
          //  System.out.println(page.getTitle() + ", would you be my valentine?    >>");
           // System.out.print("Start index: " + m.start());
			//System.out.print(" End index: " + m.end() + " ");
			//System.out.println(m.group());
			set.add(m.group().toLowerCase());
			occurence++;
        }
        System.out.println(" occurence : "+occurence + " unique words: "+ set.size());
        frq.setOccurence(occurence);
        frq.setUniqueWords(set.size());
        
        // Since we don't need to retain the pages
        // This code helps with memory management
        
       /* Pattern imgp = Pattern.compile("<img",Pattern.CASE_INSENSITIVE);
        Matcher imgm = imgp.matcher(content);
        while (imgm.find()) {
            //  System.out.println(page.getTitle() + ", would you be my valentine?    >>");
        	String src = content.substring(imgm.start());
        	 src = src.substring(src.indexOf("src=")+5);
           src = src.substring(0,src.indexOf("\""));
            
           // System.out.println("#"+src);
        }*/
        
        
        
        page.getOrigin().setPage(null);
        page.discardContent();
        
        // Print out some stats about the crawler every 10 pages visited
        int n = this.getPagesVisited();
        if (n % 10 == 0) System.out.println(this.getPagesVisited() + " pages visited.  " + this.getPagesLeft() + " pages left.  " + this.getActiveThreads() + " active threads.");
                
    }
    
}
