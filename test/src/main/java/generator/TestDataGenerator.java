package generator;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TestDataGenerator {

    public static void main(String[] args) throws IOException {
        generateEntity();
        generateSettingsData();
    }

    public static void generateEntity() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        for (int i = 0; i < 5; i++) {
            xmlMapper.writeValue(new File("/Users/amourety/IdeaProjects/xml/" + i + ".xml"),
                    new Data(StringGenerator.getRandomString()));
        }
    }

    public static void generateSettingsData() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SettingsData settingsData = new SettingsData();
        settingsData.setUser(new User("amourety", "di9cbdy4"));
        settingsData.setBaseUrl("https://diary.anek.ws/");
        xmlMapper.writeValue(new File("settings.xml"), settingsData);
    }
}
