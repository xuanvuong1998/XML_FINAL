/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.crawler.stax;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import vuonghx.utils.XMLParserHelper;

/**
 *
 * @author hoxua
 */
public class StAXABD {
    
    public static Map<String, String> parseCategories(String document)
            throws UnsupportedEncodingException, XMLStreamException {
        document = document.trim();
        XMLEventReader eventReader = XMLParserHelper.parseStringToXMLEventReader(document);
        Map<String, String> categories = new HashMap<>();

        while (eventReader.hasNext()) {
            XMLEvent event = (XMLEvent) eventReader.next(); 
            if (event.isStartElement()) { 
                StartElement startElement = event.asStartElement();
                String tagName = startElement.getName().getLocalPart();
                //String tagName = startElement.getName().;
                System.out.println(tagName);
                               
                if ("a".equals(tagName)) {
                    Attribute href = startElement.getAttributeByName(new QName("href"));
                    String link = href.getValue();
                    event = (XMLEvent) eventReader.next();
                    Characters categoryNameChars = event.asCharacters();

                    categories.put(link, categoryNameChars.getData());
                }
            }
        }

        return categories;
    }
}
