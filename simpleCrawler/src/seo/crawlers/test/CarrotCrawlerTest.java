package seo.crawlers.test;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.ProcessingResult;

import seo.crawlers.CarrotCrawler;
import websphinx.Link;
import carot.example.ConsoleFormatter;

public class CarrotCrawlerTest {
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<org.carrot2.core.Document> documents = new ArrayList<org.carrot2.core.Document>();
		
		CarrotCrawler crawler = new CarrotCrawler(1);
		CarrotCrawler crawler2 = new CarrotCrawler(1);
		    try {
		      	
		      crawler.setRoot(new Link(new URL("http://www.assurland.com/")));
		      crawler.run();
		      
		      crawler2.setRoot(new Link(new URL("http://www.lelynx.com/")));
		      crawler2.run();
		      
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		  //  System.out.println( crawler.getDocumentList().toString());
		   // System.out.println(crawler.getDocumentList().size());
		    
		    
		    
		   // documents  = crawler.getDocumentList().addAll(crawler2.getDocumentList());
		    documents = crawler.getDocumentList();
		    documents.addAll(crawler2.getDocumentList());
		    
		    /* A controller to manage the processing pipeline. */
            final Controller controller = ControllerFactory.createSimple();

            /*
             * Perform clustering by topic using the Lingo algorithm. Lingo can 
             * take advantage of the original query, so we provide it along with the documents.
             */
            final ProcessingResult byTopicClusters = controller.process(documents, "comparateur assurance auto",
                LingoClusteringAlgorithm.class);
            final List<Cluster> clustersByTopic = byTopicClusters.getClusters();
            
            /* Perform clustering by domain. In this case query is not useful, hence it is null. */
            //final ProcessingResult byDomainClusters = controller.process(documents, null,
              //  ByUrlClusteringAlgorithm.class);
            //final List<Cluster> clustersByDomain = byDomainClusters.getClusters();
            // [[[end:clustering-document-list]]]
          
            ConsoleFormatter.displayClusters(clustersByTopic);
          //  ConsoleFormatter.displayClusters(clustersByDomain);
		    
		}
	
	
	
}
