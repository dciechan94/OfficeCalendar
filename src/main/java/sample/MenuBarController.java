package sample;


import java.util.Properties;
import java.util.ResourceBundle;

public class MenuBarController {
    private static final String LANG_FILE = "MenuBar";

    private Properties lang;
    //private ResourceBundle resource;

    public MenuBarController() {
        lang = LanguageLoader.getLanguageProperties(LANG_FILE);
    }
}
