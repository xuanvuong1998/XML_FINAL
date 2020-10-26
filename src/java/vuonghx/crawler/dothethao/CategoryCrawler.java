/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.crawler.dothethao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.xml.stream.XMLStreamException;
import vuonghx.crawler.base.BaseCrawler;
import vuonghx.crawler.stax.StAXABD;

/**
 *
 * @author hoxua
 */
public class CategoryCrawler extends BaseCrawler{
    
    public CategoryCrawler(ServletContext context) {
        super(context);
    }
    
    
    public void getCategories(String url){
        
        try {
            String filteredContent = filterDocument(url);
            
            //String wellFormedXMLContent = TextUtils.refineHtml(filteredContent);
            
            StAXABD.parseCategories(filteredContent);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CategoryCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(CategoryCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private String filterDocument(String url){
        try {
            BufferedReader br = getBufferedReaderForUrl(url);
            
            String line = null;
            boolean isStart = false;
            
            String filteredContent = "";
            
            
            while((line = br.readLine()) != null)
            {
                if (line.contains("<header")){                    
                    isStart = true;
                }
                if (line.contains("</header")){                
                    filteredContent += line.trim() + "\n";
                    break;
                }
                
                if (isStart) filteredContent += line.trim();             
                
            }
            
            br.close();
            
            //System.out.println(filteredContent);
            
            return line;
            
        } catch (IOException ex) {
            Logger.getLogger(CategoryCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
