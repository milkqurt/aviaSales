package BIGPROJECT;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_BP{
        public static void main(String[] args) {
            try {
                ServerSocket server = new ServerSocket(3339);
                System.out.println("WAITING FOR CLIENT");

                while (true){
                    Socket socket = server.accept();
                    System.out.println("CLIENT CONNECTED");
                    ClientHandler_BP clientHandler_bp = new ClientHandler_BP(socket);
                    clientHandler_bp.start();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
}
