package com.example.sendemail.message.messageImp;

import com.example.sendemail.message.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageImp implements Message{

    private final HashMap<String, String> oldInformation;
    private final HashMap<String, String> newInformation;
    
    public MessageImp(HashMap<String, String> oldInformation,HashMap<String, String> newInformation)
    {
        this.oldInformation= oldInformation;
        this.newInformation= newInformation;
    }
    
    @Override
    public ArrayList<String> newPage() {
       ArrayList<String> newPage= new ArrayList<>();
       
       if (oldInformation.isEmpty())
        {
           newPage.addAll(newInformation.keySet());
           return newPage;
        }
       else
        {
            for (String key: newInformation.keySet())
            {
                if (!oldInformation.containsKey(key))
                    newPage.add(key);
            }
            return newPage;
        }
    }

    @Override
    public ArrayList<String> deletedPage() {
        ArrayList<String> deletedPage= new ArrayList<>();
        if (newInformation.isEmpty())
        {
            deletedPage.addAll(oldInformation.keySet());
            return deletedPage;
        }
        else
        {
            for (String key: oldInformation.keySet())
            {
                if (!newInformation.containsKey(key))
                    deletedPage.add(key);
            }
            return deletedPage;
        }
    }

    @Override
    public ArrayList<String> changedPage() {
        
        ArrayList<String> changedPage= new ArrayList<>();
        for (String key: newInformation.keySet())
        {
            if (oldInformation.containsKey(key) && !newInformation.get(key).equals(oldInformation.get(key)))
            {
                changedPage.add(key);
            }
                
        }
        
        return changedPage;
    }

    @Override
    public String getMessage() {
        
        return
        "Здравствуйте, дорогая и.о. секретаря\n"+
        "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n"+

        "1. Исчезли следующие страницы:"+ this.deletedPage()+"\n"+
        "2. Появились следующие новые страницы:"+ this.newPage()+"\n"+
        "3. Изменились следующие страницы:"+ this.changedPage()+ "\n\n"+

        "С уважением,\n"+
        "автоматизированная система\n"+
        "мониторинга.";
    }
}
