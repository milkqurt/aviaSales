package BIGPROJECT;

import java.net.Socket;

public class Admin_BP {
    public static Socket socket;
    public static MainFrameAdmin_BP frame;
    public static void main(String[] args) {

        try{
            socket = new Socket("127.0.0.1",3339);
            //ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            //ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        }catch (Exception exception){
            exception.printStackTrace();
        }

        frame = new MainFrameAdmin_BP();
        frame.setVisible(true);
    }
}
