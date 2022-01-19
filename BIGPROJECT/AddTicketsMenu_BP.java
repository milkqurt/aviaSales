package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AddTicketsMenu_BP extends Container {
    public static int idTickets;

    DBManager_BP dbManager_bp = new DBManager_BP();

    private JLabel label;
    protected JComboBox comboBoxFlightId;
    protected JTextField nameTickets;
    protected JTextField surnameTickets;
    protected JTextField passport_numberTickets;

    protected JComboBox ticketTypeTickets;

    protected JButton addButton;
    protected JButton backButton;


    public AddTicketsMenu_BP(){
        setSize(1400,800);
        setLayout(null);

        dbManager_bp.connect();

        ArrayList<Flights_BP> flights_bp = new ArrayList<>(dbManager_bp.getFlightsName());
        String[] arrName = new String[flights_bp.size()];
        for(int i = 0; i < arrName.length; i++) {
            arrName[i] =flights_bp.get(i).getId() + " " +  flights_bp.get(i).getAircraft_name() + " " + flights_bp.get(i).getDeparture_city_name() +" "+flights_bp.get(i).getArrival_city_name() +
                    " " + flights_bp.get(i).getDeparture_time();
        }

        label = new JLabel("Полет : ");
        label.setSize(110,30);
        label.setLocation(20,20);
        add(label);

        comboBoxFlightId = new JComboBox(arrName);
        comboBoxFlightId.setSize(400,30);
        comboBoxFlightId.setLocation(100,20);
        add(comboBoxFlightId);


        label = new JLabel("NAME : ");
        label.setSize(100,30);
        label.setLocation(60,60);
        add(label);

        nameTickets = new JTextField("");
        nameTickets.setSize(200,30);
        nameTickets.setLocation(200,60);
        add(nameTickets);


        label = new JLabel("SURNAME : ");
        label.setSize(100,30);
        label.setLocation(60,100);
        add(label);

        surnameTickets = new JTextField("");
        surnameTickets.setSize(200,30);
        surnameTickets.setLocation(200,100);
        add(surnameTickets);


        label = new JLabel("passport_number : ");
        label.setSize(120,30);
        label.setLocation(60,140);
        add(label);

        passport_numberTickets = new JTextField("");
        passport_numberTickets.setSize(200,30);
        passport_numberTickets.setLocation(200,140);
        add(passport_numberTickets);


        label = new JLabel("ticket_type : ");
        label.setSize(120,30);
        label.setLocation(60,180);
        add(label);

        String [] arrTicketTypeTickets = {"ec","bc"};
        ticketTypeTickets = new JComboBox(arrTicketTypeTickets);
        ticketTypeTickets.setSize(200,30);
        ticketTypeTickets.setLocation(200,180);
        add(ticketTypeTickets);


        addButton = new JButton("ADD");
        addButton.setSize(100, 30);
        addButton.setLocation(60, 350);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String intFlightId = comboBoxFlightId.getSelectedItem().toString();
                    String [] s = intFlightId.split(" ");
                    String strFlightId = s[0];
                    Long flightId = Long.valueOf(strFlightId);
                    String strflightName = comboBoxFlightId.getSelectedItem().toString();
                    String name = nameTickets.getText();
                    String surname = surnameTickets.getText();
                    String passport_num = passport_numberTickets.getText();
                    String ticket = ticketTypeTickets.getSelectedItem().toString();

                    Tickets_BP tickets_bp = new Tickets_BP(null,flightId,name,surname,passport_num,ticket,strflightName);

                    PackageData_BP packageData_bp = new PackageData_BP("ADD TICKET",tickets_bp);

                    Cashier_BP.socket2 = new Socket("127.0.0.1",3339);
                    ObjectOutputStream outputStream = new ObjectOutputStream(Cashier_BP.socket2.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(Cashier_BP.socket2.getInputStream());
                    outputStream.writeObject(packageData_bp);

                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        });

        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(250, 350);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cashier_BP.frame2.showMenu();
            }
        });
    }
}
