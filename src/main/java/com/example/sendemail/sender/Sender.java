package com.example.sendemail.sender;

public interface Sender {
    
    public void send(String subject, String text, String toEmail); //отправляет сообщение
}
