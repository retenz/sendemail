/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sendemail.sender;

/**
 *
 * @author Tenadze
 */
public interface Sender {
    
    public void send(String subject, String text, String toEmail); //отправляет сообщение
}
