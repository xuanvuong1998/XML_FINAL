/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.test;

import java.util.List;
import vuonghx.constants.urls.CrawlUrls;
import vuonghx.crawler.dothethao.CategoryCrawler;
import vuonghx.dao.category.CategoryDAO;
import vuonghx.dao.product.ProductDAO;
import vuonghx.entities.Category;

/**
 *
 * @author hoxua
 */
public class Test {
    public static void main(String[] args) {
        CategoryCrawler crawler = new CategoryCrawler(null);
        
        crawler.getCategories(CrawlUrls.AO_BONG_DA_24H);
        
        
    }
}
