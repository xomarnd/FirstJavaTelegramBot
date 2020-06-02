import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/BotConfig.properties";
    private static String BOT_NAME;
    private static String BOT_TOKEN;


    public static void main(String[] args) {
        getMyProperty();


        ApiContextInitializer.init();

        TelegramBotsApi telegram = new TelegramBotsApi();

    }

    public class Bot extends TelegramLongPollingBot{

        @Override
        public void onUpdateReceived(Update update) {
        }
        @Override
        public String getBotUsername() {
            return  BOT_NAME;
        }
        @Override
        public String getBotToken() {
            return BOT_TOKEN;
        }
    }

    private static void getMyProperty(){
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            BOT_NAME = prop.getProperty("BOT_NAME");
            BOT_TOKEN = prop.getProperty("BOT_TOKEN");
        }catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }
    }
}
