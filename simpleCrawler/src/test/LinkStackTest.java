package test;

import imgdownload.ImageLinksFetcher;

import java.util.ArrayList;
import java.util.Collection;

import threads.CrawlingThread;
import threads.LinkStack;

public class LinkStackTest {

static public void main (String args[]){
	
	LinkStack stack = LinkStack.getInstance();
	stack.add("http://docs.oracle.com/javase/1.5.0/docs/guide/language/foreach.html");
	stack.add("http://wildjungleharry.blogspot.com/2011/08/bang-bang-i-shot-him-down-bang-bang-he.html");
	stack.add("http://sujitpal.blogspot.com/2008/03/crawling-web-pages-with-websphinx.html");
	stack.add("http://wddc.blogspot.com/2012/01/writing-java-code-in-blogger-posts.html");
	stack.add("http://olegvolk.net/blog/");
	/*Collection<CrawlingThread> threads = new ArrayList<CrawlingThread>();
	
	for ( int i =0; i < stack.size(); i++){
		(new Thread(new CrawlingThread(Integer.toString(i), (String) stack.links.toArray()[i]))).start();
	}
	*/
	System.out.print("hello World");
	ImageLinksFetcher fetcher = new ImageLinksFetcher();
	fetcher.downloadImg(4);
//	System.out.println(fetcher.imgFeatureExtraction("C:/Users/walid/Desktop/dump/M1Rifle.jpg","C:/Users/walid/Desktop/dump/M1Rifle2.jpg","C:/Users/walid/Desktop/dump/M1Rifle3.jpg", 4));
	
}	
	
}
