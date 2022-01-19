package BIGPROJECT;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler_BP extends Thread{
    private Socket socket;
    DBManager_BP dbManager_bp = new DBManager_BP();

    public ClientHandler_BP() {
    }

    public ClientHandler_BP(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            PackageData_BP pd = null;
            while ((pd = (PackageData_BP) inputStream.readObject()) !=null){
                if(pd.getOperationType().equals("ADD AIRCRAFT")){
                    dbManager_bp.connect();
                    dbManager_bp.addAircrafts(pd.getAircrafts_bp());
                }else if(pd.getOperationType().equals("ADD CITY")) {
                    dbManager_bp.connect();
                    dbManager_bp.addCity(pd.getCities_bp());
                }else if(pd.getOperationType().equals("ADD FLIGHTS")) {
                    dbManager_bp.connect();
                    dbManager_bp.addFlights(pd.getFlights_bp());
                }else if(pd.getOperationType().equals("ADD TICKET")) {
                    dbManager_bp.connect();
                    dbManager_bp.addTickets(pd.getTickets_bp());
                }else {
                    System.out.println(pd);
                    outputStream.writeObject(pd);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
