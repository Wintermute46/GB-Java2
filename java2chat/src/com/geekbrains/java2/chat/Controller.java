package com.geekbrains.java2.chat;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    final String SERVER = "localhost";
    final int PORT = 8189;

    public TextField jtf;
    public TextArea jta;
    public TextField logf;
    public PasswordField passf;
    public HBox authPanel;
    public HBox msgPanel;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private boolean authorized;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(SERVER, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            setAuthorized(false);
            Thread th = new Thread(() -> {
                try {
                    while (true) {
                        String inputMes = in.readUTF();
                        if (inputMes.equals("/authOk")) {
                            setAuthorized(true);
                            break;
                        } else if (inputMes.equals("/authFail")) showAlert("Неправильный логин/пароль!");
                    }
                    while (true) {
                        String inputMes = in.readUTF();
                        jta.appendText(inputMes + "\n");
                    }
                } catch (IOException e) {
                    showAlert(e.getMessage());
                } finally {
                    setAuthorized(false);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        showAlert(e.getMessage());
                    }
                }
            });
            th.setDaemon(true);
            th.start();
        } catch (IOException e) {
            showAlert(e.getMessage());
        }
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
        if (authorized) {
            msgPanel.setVisible(true);
            msgPanel.setManaged(true);
            authPanel.setVisible(false);
            authPanel.setManaged(false);
        } else {
            msgPanel.setVisible(false);
            msgPanel.setManaged(false);
            authPanel.setVisible(true);
            authPanel.setManaged(true);
        }
    }

    public void sendAuth() {
        try {
            out.writeUTF("/auth " + logf.getText() + " " + passf.getText());
            logf.clear();
            passf.clear();
        } catch (IOException e) {
            showAlert(e.getMessage());
        }
    }

    public void sendMsg() {
        try {
            String message = jtf.getText();
            if (!message.equals("")) {
                out.writeUTF(message);
                jtf.clear();
                jtf.requestFocus();
            }
        } catch (IOException e) {
            showAlert(e.getMessage());
        }
    }

    public void showAlert(String msg) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Возникли проблемы");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        });
    }
}