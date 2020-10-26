package vuonghx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import vuonghx.utils.TextUtils;

/**
 *
 * @author chien
 */
public class TestWelformer {

    public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        StringBuilder stringBuilder;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            String line;
            stringBuilder = new StringBuilder();
            URL url = new URL("https://www.javatpoint.com/java-tutorial");
            inputStream = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String html = stringBuilder.toString();
            String xhtml = TextUtils.refineHtml(html);
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
