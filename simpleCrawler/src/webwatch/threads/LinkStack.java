package webwatch.threads;

import java.util.ArrayList;
import java.util.Collection;



public class LinkStack {
 
	
	private static LinkStack instance = null;
	 public static LinkStack getInstance() {
	      if(instance == null) {
	         instance = new LinkStack();
	      }
	      return instance;
	   }
	
	protected LinkStack() {}
	
	
	public Collection<String> links= new ArrayList<String>();
 
	public void add(String link){
	 
		links.add(link);
	 
	}
	
	public int delete(String link){
		
		if(links.contains(link))
			{links.remove(link);
				return 0;
			}
		else return -1;
		}
	
	
	public int size(){
		return links.size();
	}
	
}
