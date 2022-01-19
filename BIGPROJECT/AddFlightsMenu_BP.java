package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AddFlightsMenu_BP extends Container {
    public static int idFlights;

    DBManager_BP dbManager_bp = new DBManager_BP();

    protected JLabel label;

    protected JComboBox comboBoxAircraftId;
    protected JComboBox comboBoxDepartureCityId;
    protected JComboBox comboBoxArrivalCityId;

    protected JTextField departure_time ;
    protected JTextField econom_place_price ;
    protected JTextField business_place_price ;

    protected JButton dbUpdateButton;
    protected JButton addButton;
    protected JButton backButton;

    public AddFlightsMenu_BP(){
        setSize(1920,1080);
        setLayout(null);

        dbManager_bp.connect();


        ArrayList<Aircrafts_BP> aircraftName = new ArrayList<>(dbManager_bp.getAircraftName());
        String[] arrName = new String[aircraftName.size()];
        for(int i = 0; i < arrName.length; i++) {
            arrName[i] = aircraftName.get(i).getId() + " " + aircraftName.get(i).getName();
        }


        ArrayList<Cities_BP> departureCity = new ArrayList<>(dbManager_bp.getCityName());
        String[] arrDepartureCity = new String[departureCity.size()];
        for(int i = 0; i < arrDepartureCity.length; i++) {
            arrDepartureCity[i] = departureCity.get(i).getId() + " " + departureCity.get(i).getShort_Name();
        }

        ArrayList<Cities_BP> arrivalCityId = new ArrayList<>(dbManager_bp.getCityName());
        String[] arrArrivalCityId = new String[arrivalCityId.size()];
        for(int i = 0; i < arrArrivalCityId.length; i++) {
            arrArrivalCityId[i] = arrivalCityId.get(i).getId() + " " + arrivalCityId.get(i).getShort_Name();
        }


        dbUpdateButton = new JButton("UPDATE");
        dbUpdateButton.setSize(100, 30);
        dbUpdateButton.setLocation(800, 700);
        add(dbUpdateButton);
        dbUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Aircrafts_BP> aircraftName = new ArrayList<>(dbManager_bp.getAircraftName());
                String[] arrName = new String[aircraftName.size()];
                for(int i = 0; i < arrName.length; i++) {
                    arrName[i] = aircraftName.get(i).getId() + " " + aircraftName.get(i).getName();
                }

                ArrayList<Cities_BP> departureCity = new ArrayList<>(dbManager_bp.getCityName());
                String[] arrDepartureCity = new String[departureCity.size()];
                for(int i = 0; i < arrDepartureCity.length; i++) {
                    arrDepartureCity[i] = departureCity.get(i).getId() + " " + departureCity.get(i).getShort_Name();
                }

                ArrayList<Cities_BP> arrivalCityId = new ArrayList<>(dbManager_bp.getCityName());
                String[] arrArrivalCityId = new String[arrivalCityId.size()];
                for(int i = 0; i < arrArrivalCityId.length; i++) {
                    arrArrivalCityId[i] = arrivalCityId.get(i).getId() + " " + arrivalCityId.get(i).getShort_Name();
                }

            }
        });


        label = new JLabel("Самолет : ");
        label.setSize(110,30);
        label.setLocation(60,20);
        add(label);

        comboBoxAircraftId = new JComboBox(arrName);
        comboBoxAircraftId.setSize(200,30);
        comboBoxAircraftId.setLocation(220,20);
        add(comboBoxAircraftId);


        label = new JLabel("Вылет из : ");
        label.setSize(110,30);
        label.setLocation(440,20);
        add(label);

        comboBoxDepartureCityId = new JComboBox(arrDepartureCity);
        comboBoxDepartureCityId.setSize(200,30);
        comboBoxDepartureCityId.setLocation(540,20);
        add(comboBoxDepartureCityId);



        label = new JLabel("Пребытие : ");
        label.setSize(110,30);
        label.setLocation(780,20);
        add(label);

        comboBoxArrivalCityId = new JComboBox(arrDepartureCity);
        comboBoxArrivalCityId.setSize(200,30);
        comboBoxArrivalCityId.setLocation(880,20);
        add(comboBoxArrivalCityId);

        label = new JLabel("Время вылета : ");
        label.setSize(110,30);
        label.setLocation(60,80);
        add(label);

        departure_time = new JTextField("");
        departure_time.setSize(200,30);
        departure_time.setLocation(220,80);
        add(departure_time);


        label = new JLabel("Цена - эконом класс : ");
        label.setSize(150,30);
        label.setLocation(440,80);
        add(label);

        econom_place_price = new JTextField("");
        econom_place_price.setSize(200,30);
        econom_place_price.setLocation(580,80);
        add(econom_place_price);


        label = new JLabel("Цена - бизнесс класс : ");
        label.setSize(150,30);
        label.setLocation(780,80);
        add(label);

        business_place_price = new JTextField("");
        business_place_price.setSize(200,30);
        business_place_price.setLocation(920,80);
        add(business_place_price);


        addButton = new JButton("ADD");
        addButton.setSize(100, 30);
        addButton.setLocation(60, 140);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String intAircraftId = comboBoxAircraftId.getSelectedItem().toString();
                    String [] s = intAircraftId.split(" ");
                    String strAircraftId = s[0];
                    Long aircraftId = Long.valueOf(strAircraftId);
                    System.out.println(aircraftId);

                    String aircraftName =  s[1];


                    String intDepartureCityId = comboBoxDepartureCityId.getSelectedItem().toString();
                    String [] s2 = intDepartureCityId.split(" ");
                    String strDepartureCityId = s2[0];
                    Long departureCityId = Long.valueOf(strDepartureCityId);
                    System.out.println(departureCityId);

                    String departureCityName = s2[1];

                    String intArrivalCityId = comboBoxArrivalCityId.getSelectedItem().toString();
                    String [] s3 = intArrivalCityId.split(" ");
                    String strArrivalCityId = s3[0];
                    Long arrivalCityId = Long.valueOf(strArrivalCityId);
                    System.out.println(arrivalCityId);

                    String arrivalCityName = s3[1];

                    String departureTime = departure_time.getText();

                    String strEconomPlacePrice = econom_place_price.getText();
                    int economPlacePrice = Integer.parseInt(strEconomPlacePrice);

                    String strBusinessPlacePrice = business_place_price.getText();
                    int businessPlacePrice = Integer.parseInt(strBusinessPlacePrice);

                    Flights_BP flights_bp = new Flights_BP(null, aircraftId, departureCityId, arrivalCityId, departureTime, economPlacePrice, businessPlacePrice,aircraftName,departureCityName,arrivalCityName);

                    PackageData_BP packageData_bp = new PackageData_BP("ADD FLIGHTS", flights_bp);

                    Admin_BP.socket = new Socket("127.0.0.1",3339);

                    ObjectOutputStream outputStream = new ObjectOutputStream( Admin_BP.socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(Admin_BP.socket.getInputStream());
                    outputStream.writeObject(packageData_bp);
                }catch (Exception exception){
                    exception.printStackTrace();
                }

                departure_time.setText("");
                econom_place_price.setText("");
                business_place_price.setText("");
            }
        });



        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(1000, 700);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showMenu();
            }
        });
    }
}
