package helpers.data;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import generator.SettingsData;
import generator.User;

import java.io.*;

public class Settings {

    private static XmlMapper xmlMapper = new XmlMapper();

    public static User getUserSetting() throws IOException {
        SettingsData settingsData = xmlMapper.readValue(inputStreamToString(new FileInputStream(new File("settings" + ".xml"))), SettingsData.class);
        User userSetting = settingsData.getUser();
        return userSetting;
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
}