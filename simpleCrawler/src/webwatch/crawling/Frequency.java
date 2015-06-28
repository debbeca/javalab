package webwatch.crawling;
import webwatch.observer.*;
public class Frequency extends Subject {
	
public int occurence;
public int uniqueWords;
public String link;

public Frequency() {
	// TODO Auto-generated constructor stub
	super();
	this.occurence = 0;
	this.uniqueWords=0;
}
public int getOccurence() {
	return occurence;
}
public void setOccurence(int occurence) {
	boolean b=false;
	if (occurence > this.occurence)
		b=true;
	this.occurence = occurence;
	 if (b)
notifyObservers();
		
}
public int getUniqueWords() {
	return uniqueWords;
	  
}
public void setUniqueWords(int uniqueWords) {
	this.uniqueWords = uniqueWords;
	//notifyObservers();
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}

}
