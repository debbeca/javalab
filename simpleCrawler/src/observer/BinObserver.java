package observer;

import crawling.Frequency;

public class BinObserver extends Observer { 
	  public BinObserver(Frequency f ) { 
	    subj = f; 
	    subj.attach( this ); } // Observers register themselves 
	    public void update() {
	    	System.out.println("#######################################");
	    System.out.println("Observer is talkin : " +((Frequency)subj).getOccurence()  ); 
	    	System.out.println("#######################################");
	    } 
	}