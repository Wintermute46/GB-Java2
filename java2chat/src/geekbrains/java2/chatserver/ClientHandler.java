package geekbrains.java2.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;


    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/auth")) {
                            String[] authData = message.split("\\s");
                            nick = server.getAuthService().getNickByAuth(authData[1], authData[2]);
                            if (nick != null) {
                                sendMsg("/authOk");
                                server.subscribe(this);
                                server.broadcastMsg("К беседе присоединился " + nick);
                                break;
                            } else {
                                sendMsg("/authFail");
                            }
                        }
                    }
                    while (true) {
                        String message = in.readUTF();
                        System.out.println(nick + ": " + message);
                        if (message.equals("/end")) break;
                        server.broadcastMsg(nick + ": " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
