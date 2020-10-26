/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.utils;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author hoxua
 */
public class XMLParserHelper {
    public static XMLEventReader parseStringToXMLEventReader(String xmlSection) 
            throws UnsupportedEncodingException, XMLStreamException {
        byte[] byteArray = xmlSection.getBytes("UTF-8");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.IS_COALESCING, true);
        XMLEventReader reader = factory.createXMLEventReader(inputStream);
        
        return reader;
    }
}
