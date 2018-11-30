package com.example.sendemail;

import com.example.sendemail.sender.senderImp.SenderImp;
import com.example.sendemail.message.messageImp.MessageImp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        
        //Создаём и заполняем хэш таблицы
        HashMap<String, String> yesterday= new HashMap<>();
        HashMap<String, String> today= new HashMap<>();
        
        yesterday.put("TestUrl1", "TestHtml1");
        today.put("TestUrl1", "TestHtml1");
        yesterday.put("TestUrl2", "TestHtml2");
        today.put("TestUrl2", "TestHtml5");
        yesterday.put("TestUrl3", "TestHtml3");
        today.put("TestUrl4", "TestHtml4");
        
        //Загружаем properties с почтой отправителя и получателя
        try(FileInputStream  fis= new FileInputStream("src/main/resources/login.properties"))
        {Properties properties= new Properties();
        properties.load(fis);
        
        //Создаём отправителя
        SenderImp sender= new SenderImp(properties.getProperty("yourEmail"), properties.getProperty("password"));
        
        
        //Ложим в наш email необходимый текст и отправляем его
        MessageImp message= new MessageImp(yesterday, today);
        sender.send("Test", message.getMessage(), properties.getProperty("recipientEmail"));
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }
}
