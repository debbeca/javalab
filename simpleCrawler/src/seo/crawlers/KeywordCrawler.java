package seo.crawlers;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import websphinx.Crawler;
import websphinx.DownloadParameters;
import websphinx.Link;
import websphinx.Page;

public class KeywordCrawler extends Crawler {
	public int hnDepth;
	// public WebsiteData websiteData;

	public ArrayList<org.carrot2.core.Document> documentList;

	public KeywordCrawler() {
		super();
		// websiteData = new WebsiteData();

		DownloadParameters dp = new DownloadParameters();

		dp.changeObeyRobotExclusion(true);
		// dp.changeUserAgent(userAgent)
		dp.changeUserAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
		setDownloadParameters(dp);
		// Do what the parent crawler would do
		// crawl only subtree of the web page
		setDomain(Crawler.SUBTREE);
		// do not go any deeper than the page itself
		setMaxDepth(0);

	}

	public KeywordCrawler(int depth) {
		super();
		// websiteData = new WebsiteData();
		
		
		DownloadParameters dp = new DownloadParameters();
		this.documentList = new ArrayList<org.carrot2.core.Document>();
		dp.changeObeyRobotExclusion(true);
		
		// dp.changeUserAgent(userAgent)
		dp.changeUserAgent("Mozilla/5.0");
		setDownloadParameters(dp);
		// Do what the parent crawler would do
		// crawl only subtree of the web page
		setDomain(Crawler.SUBTREE);
		// do not go any deeper than the page itself
		setMaxDepth(depth);
		
		String agent = this.getDownloadParameters().getUserAgent();
		System.out.println("MimeType= "+dp.getAcceptedMIMETypes());
		System.out.println("UserAgent= "+ agent);
		
	}

	// We could choose not to visit a link based on certain circumstances
	// For now we always visit the link
	public boolean shouldVisit(Link l) {
		// String host = l.getHost();
		return true; // always visit a link
	}

	// What to do when we visit the page
	public void visit(Page page) {

		// System.out.println("Visiting: " + page.getTitle());
		String content = page.getContent();
		page.setContentEncoding("UTF-8");

		System.out.println("ENCODIN...  : " + page.getContentEncoding());

		System.out.println("URL...  : " + page.getURL());
		System.out.println("Title...  : " + page.getTitle());

		Document doc = Jsoup.parse(page.getContent());

		Elements metaTagsdesc = doc.getElementsByAttributeValue("name",
				"description");
		String desc1 = new String("");
		for (Element meta1 : metaTagsdesc) {
			desc1 = meta1.attr("content");
			System.out.println("description  : " + desc1);
		}

		documentList.add(new org.carrot2.core.Document(page.getTitle(), desc1,
				page.getURL().toString()));

		// WebPageData webpage = new WebPageData(page.getURL(), desc1,
		// page.getTitle());
		// websiteData.getPagesMap().put(page.getURL().toString(), webpage);
	}

	public int getHnDepth() {
		return hnDepth;
	}

	public void setHnDepth(int hnDepth) {
		this.hnDepth = hnDepth;
	}

	public ArrayList<org.carrot2.core.Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(
			ArrayList<org.carrot2.core.Document> documentList) {
		this.documentList = documentList;
	}

}
