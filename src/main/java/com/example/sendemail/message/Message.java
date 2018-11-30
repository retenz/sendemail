package com.example.sendemail.message;

import java.util.ArrayList;

public interface Message {
    
    public ArrayList<String> newPage();     //Возвращает список новых страниц
    public ArrayList<String> deletedPage(); //Возвращает список удалённых страниц
    public ArrayList<String> changedPage(); //Возвращает список изменённых страниц
    public String getMessage();             //Возвращает текст сообщения
}
