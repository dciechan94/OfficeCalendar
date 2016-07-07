package sample;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class LanguageLoader {

    // TODO: Add per OS slash support

    private static final String LANG_PATH = "src/main/resources/lang/";

    public static Properties getLanguageProperties(String filePath) {
        Properties languagePack = new Properties();
        String country = Locale.getDefault().getCountry();

        try (BufferedReader br = new BufferedReader(new FileReader(LANG_PATH + "/" + country + "/" + filePath + "_" + country + ".properties"))) {
            languagePack.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languagePack;
    }
}
