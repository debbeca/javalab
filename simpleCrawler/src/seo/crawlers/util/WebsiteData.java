package seo.crawlers.util;

import java.util.HashMap;

public class WebsiteData {

	public String websiteUrl;
	public HashMap<String, WebPageData> pagesMap;
	
	
	
	
	public WebsiteData() {
		super();
		pagesMap = new HashMap<String, WebPageData>();
		
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public HashMap<String, WebPageData> getPagesMap() {
		return pagesMap;
	}
	public void setPagesMap(HashMap<String, WebPageData> pagesMap) {
		this.pagesMap = pagesMap;
	}
	
	
}
