 package seo.crawlers.util;

import java.net.URL;

import org.jsoup.nodes.Document;

public class WebPageData {

	public URL rootUrl;
	public URL url;
	public String description;
	public String keywords;
	public String title ; 
	public Document document;
	
	
	public WebPageData(URL rootUrl, URL url, String description,
			String title) {
		super();
		this.rootUrl = rootUrl;
		this.url = url;
		this.description = description;
		this.title = title;
	}
	public WebPageData(URL url, String title,  String description) {
		super();
		this.url = url;
		this.description = description;
		this.title = title;
	}
	public URL getRootUrl() {
		return rootUrl;
	}
	public void setRootUrl(URL rootUrl) {
		this.rootUrl = rootUrl;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	} 
	
	
	

}
