package BIGPROJECT;

import java.net.Socket;

public class Cashier_BP {
    public static Socket socket2;
    public static MainFrameCashier_BP frame2;
    public static void main(String[] args) {

        try{
            socket2= new Socket("127.0.0.1",3339);
            //ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            //ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        }catch (Exception exception){
            exception.printStackTrace();
        }


        frame2 = new MainFrameCashier_BP();
        frame2.setVisible(true);
    }
}
