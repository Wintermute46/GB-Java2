package geekbrains.java2.chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService = null;

    public Server() {

        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            clients = new Vector<>();
            authService = new AuthService();
            authService.connect();
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getInetAddress() + " " + socket.getPort() + " " + socket.getLocalPort());
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            authService.disconnect();
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void broadcastMsg(String message) {
        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }
}
