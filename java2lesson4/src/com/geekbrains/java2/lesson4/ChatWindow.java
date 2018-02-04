package com.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame {
    public ChatWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,600,400);

        JTextArea messageFeed = new JTextArea();
        messageFeed.setLineWrap(true);
        messageFeed.setEditable(false);
        JScrollPane sp = new JScrollPane(messageFeed);
        add(sp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JTextField newMessage = new JTextField();
        newMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(newMessage, messageFeed);
            }
        });

        JScrollPane sp1 = new JScrollPane(newMessage);
        bottomPanel.add(sp1,BorderLayout.CENTER);

        JButton send = new JButton();
        send.setText("Отправить");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(newMessage, messageFeed);
            }
        });

        bottomPanel.add(send, BorderLayout.EAST);

        add(bottomPanel,BorderLayout.SOUTH);

        setVisible(true);

    }

    private void sendMessage(JTextField message, JTextArea feed) {
        String text = message.getText();
        if (text.length() != 0) {
            feed.append(text + "\n");
            message.setText("");
        }
        message.grabFocus();
    }
}
