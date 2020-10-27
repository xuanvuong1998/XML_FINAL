/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.crawler.abd24h;

import java.util.List;
import vuonghx.constants.urls.CrawlUrls;

/**
 *
 * @author hoxua
 */
public class MainCrawlerAbd24h {

    public static void startCrawling() {
        List<String> catLinks = new CategoryCrawler(null).getCategorieUrls(CrawlUrls.AO_BONG_DA_24H);

        for (String catLink : catLinks) {
            List<String> pagesLinks = new CategoryPageCrawler(catLink, null).getPagesLinks();

            for (String pageLink : pagesLinks) {
                List<String> productsUrls = new ProductInPageCrawler(pageLink, null).getProductsUrls();
                
                
            }
        }
    }
}
