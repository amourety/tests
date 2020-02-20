package tests;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import helpers.data.AccountData;
import helpers.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class TextGeneratorTest extends TestBase {
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test() throws ParserConfigurationException, IOException, SAXException {

        //files of directory
        File[] fileList = new File("/Users/amourety/IdeaProjects/xml/").listFiles();

        applicationManager.getNavigationHelper().openPage();
        applicationManager.getLoginHelper().login(new AccountData("amourety","di9cbdy4"));

        if (fileList != null) {
            for (File value : fileList) {
                applicationManager.getEntityHelper().createEntity(new Data(parcing(inputStreamToString(new FileInputStream(value)))));
            }
        }
        applicationManager.getLoginHelper().logout();
    }
    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    private String parcing(String string){
        String xml = string;
        xml = xml.replace("<Data>","");
        xml = xml.replace("<data>","");
        xml = xml.replace("</Data>","");
        xml = xml.replace("</data>","");
        return xml;
    }
}
