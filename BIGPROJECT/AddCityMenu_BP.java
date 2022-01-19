package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddCityMenu_BP extends Container {
    public static int idCity;
    protected JLabel label;
    protected JTextField nameCity;
    protected JTextField countryCity;
    protected JTextField shortNameCity;

    protected JButton addButton;
    protected JButton backButton;


    public AddCityMenu_BP(){
        setSize(1920,1080);
        setLayout(null);

        label = new JLabel("NAME : ");
        label.setSize(100,30);
        label.setLocation(100,60);
        add(label);

        nameCity = new JTextField("");
        nameCity.setSize(200,30);
        nameCity.setLocation(200,60);
        add(nameCity);


        label = new JLabel("COUNTRY : ");
        label.setSize(100,30);
        label.setLocation(440,60);
        add(label);

        countryCity = new JTextField("");
        countryCity.setSize(200,30);
        countryCity.setLocation(560,60);
        add(countryCity);


        label = new JLabel("SHORT NAME : ");
        label.setSize(110,30);
        label.setLocation(800,60);
        add(label);

        shortNameCity = new JTextField("");
        shortNameCity.setSize(200,30);
        shortNameCity.setLocation(900,60);
        add(shortNameCity);


        addButton = new JButton("ADD");
        addButton.setSize(100, 30);
        addButton.setLocation(100, 120);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String name = nameCity.getText();
                    String country = countryCity.getText();
                    String shortName = shortNameCity.getText();
                    Cities_BP city = new Cities_BP(null,name,country,shortName);
                    PackageData_BP packageData_bp = new PackageData_BP("ADD CITY",city);

                    Admin_BP.socket = new Socket("127.0.0.1",3339);
                    ObjectOutputStream outputStream = new ObjectOutputStream(Admin_BP.socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(Admin_BP.socket.getInputStream());
                    outputStream.writeObject(packageData_bp);

                }catch (Exception exception){
                    exception.printStackTrace();
                }

                nameCity.setText("");
                countryCity.setText("");
                shortNameCity.setText("");
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
