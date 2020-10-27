package vuonghx.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;
import vuonghx.utils.TextUtils;

/**
 *
 * @author chien
 */
public class TestTransformer {

    public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException, TransformerConfigurationException, TransformerException {
        StringBuilder stringBuilder;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            String xhtml;
            {
                String line;
                stringBuilder = new StringBuilder();
                URL url = new URL("https://www.bachhoaxanh.com/mi/mi-reeva-lau-nam-chua-cay-ly-65g");
                inputStream = url.openStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                String html = stringBuilder.toString();
                xhtml = TextUtils.refineHtml(html);
            }

            TransformerFactory factory = TransformerFactory.newInstance();
            String output;
            {
                OutputStream outputStream = new ByteArrayOutputStream();
                Transformer transformer = factory.newTransformer(new StreamSource(new File("bachhoaxanh_1.xsl")));
                transformer.transform(
                        new StreamSource(new ByteArrayInputStream(xhtml.getBytes("UTF-8"))),
                        new StreamResult(outputStream));
                output = outputStream.toString();
            }

            System.out.println(output);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
