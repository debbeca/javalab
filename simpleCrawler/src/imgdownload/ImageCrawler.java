package imgdownload;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import websphinx.Crawler;
import websphinx.Link;
import websphinx.Page;


// Our own Crawler class extends the WebSphinx Crawler
public class ImageCrawler extends Crawler {

	public String imgFolder ;
	public String mainPath = new String("C:/Users/Walid/Desktop/dump/images");
	
	public ImageCrawler( ) {
        super();  // Do what the parent  crawler would do
       // crawl only subtree of the web page
        setDomain(Crawler.SUBTREE);
        //do not go any deeper than the page itself
        setMaxDepth(0);
      
    }
	
	public ImageCrawler(int folderIndex ) {
		
        super();  // Do what the parent  crawler would do
        setDomain(Crawler.SUBTREE);
        setMaxDepth(0);
        this.imgFolder = Integer.toString(folderIndex);
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
        System.out.println("Visitin : "+ page.getTitle());
        //System.out.println("LINK : "+ page.getOrigin().toHTML());
        try {
            Thread.sleep(1000L);
          } catch (InterruptedException e) {;}
          
        	  
        // Trivial example, searching for the word  from dico
        
       
        
        // Since we don't need to retain the pages
        // This code helps with memory management
        
     /*  Pattern imgp = Pattern.compile("#<img [^>]*src*=*([\"|'])(.*?)\1#im",Pattern.CASE_INSENSITIVE);
        Matcher imgm = imgp.matcher(content);
        while (imgm.find()) {
            //  System.out.println(page.getTitle() + ", would you be my valentine?    >>");
        	String src = content.substring(imgm.start());
        	 src = src.substring(src.indexOf("src=")+5);
           src = src.substring(0,src.indexOf("\""));
            
            System.out.println("#"+src);
        }*/
        Document doc = Jsoup.parse(page.getContent());
        /*Element img = doc.select("img").first();
        String imgSrc = img.attr("src");
        System.out.println("Img source: " + imgSrc);*/
        
        
        Elements el = doc.select("img");
        for (Iterator i = el.iterator() ; i.hasNext();)
        {
        	Element image = (Element) i.next();
        	
        String urlimg = image.absUrl("src");
        System.out.println("#"+urlimg);
        
        String targetDir = new String(mainPath+"/"+imgFolder);
       
        URL url= null;
		try {
			url = new URL(urlimg);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			    
			InputStream in;
		
				in = url.openStream();
				System.out.println("url file"+url.getFile()); 
				System.out.println("url path"+url.getPath().replaceAll("[?//]+","")); 
				String path = url.getPath().replaceAll("[?//]+","");
				
				File targetPath = new File(targetDir);
				System.out.println("testing path :"+ targetDir ) ;
				if (! targetPath.exists()) {
					 System.out.println("we are forcing creation of :"+ targetPath);
			            FileUtils.forceMkdir(targetPath);
			          }
				
				String targetPathName = FilenameUtils.concat(targetDir, path);
				
				 System.out.println("finally : "+targetPathName); 
				
				
				 File targetFile = new File(targetPathName);
				 
				 JFileChooser chooser = new JFileChooser();
				  
				  
				  String fileTypeName = chooser.getTypeDescription(targetFile);
				  System.out.println("File Type= "+fileTypeName);
				  
		     OutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile));
		     for (int b; (b = in.read()) != -1; ) {
                 out.write(b);
             }
             out.close();
             in.close();	
		     
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        
        
        
        page.getOrigin().setPage(null);
        page.discardContent();
        
        // Print out some stats about the crawler every 10 pages visited
        int n = this.getPagesVisited();
        if (n % 10 == 0) System.out.println(this.getPagesVisited() + " pages visited.  " + this.getPagesLeft() + " pages left.  " + this.getActiveThreads() + " active threads.");
                
    }
    
}
