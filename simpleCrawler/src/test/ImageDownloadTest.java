package test;

import imgdownload.ImageCrawler;

import java.net.URL;

import websphinx.Link;
import webwatch.crawling.ContentCrawler;
import webwatch.crawling.Frequency;

public class ImageDownloadTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImageCrawler crawler = new ImageCrawler(1);
		    try {
		    //  crawler.setTargetDir("C:/Users/walid/Desktop/dump");
		     // crawler.init();
		      crawler.setRoot(new Link(new URL("http://olegvolk.net/blog/")));
		      crawler.run();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}

		}
}
