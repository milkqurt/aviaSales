package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddAircraftMenu_BP extends Container {
    public static int idAircraft;
    protected JLabel label;
    protected JTextField nameAircraft;
    protected JTextField modelAircraft;
    protected JTextField business_class_capacity;
    protected JTextField econom_class_capacity;
    protected JButton addButton;
    protected JButton backButton;


    public AddAircraftMenu_BP(){
        setSize(1920,1080);
        setLayout(null);

        label = new JLabel("NAME : ");
        label.setSize(100,30);
        label.setLocation(100,60);
        add(label);

        nameAircraft = new JTextField("");
        nameAircraft.setSize(200,30);
        nameAircraft.setLocation(200,60);
        add(nameAircraft);


        label = new JLabel("MODEL : ");
        label.setSize(100,30);
        label.setLocation(440,60);
        add(label);

        modelAircraft = new JTextField("");
        modelAircraft.setSize(200,30);
        modelAircraft.setLocation(560,60);
        add(modelAircraft);


        label = new JLabel("BUSINESS CLASS CAPACITY : ");
        label.setSize(200,30);
        label.setLocation(100,140);
        add(label);

        business_class_capacity = new JTextField("");
        business_class_capacity.setSize(100,30);
        business_class_capacity.setLocation(300,140);
        add(business_class_capacity);


        label = new JLabel("ECONOM CLASS CAPACITY : ");
        label.setSize(200,30);
        label.setLocation(440,140);
        add(label);

        econom_class_capacity = new JTextField("");
        econom_class_capacity.setSize(100,30);
        econom_class_capacity.setLocation(660,140);
        add(econom_class_capacity);


        addButton = new JButton("ADD");
        addButton.setSize(100, 30);
        addButton.setLocation(100, 200);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String name = nameAircraft.getText();
                    String model = modelAircraft.getText();
                    String strBusinessClassCapacity = business_class_capacity.getText();
                    int businessClassCapacity = Integer.parseInt(strBusinessClassCapacity);
                    String strEconomClassCapacity = econom_class_capacity.getText();
                    int economClassCapacity = Integer.parseInt(strEconomClassCapacity);
                    Aircrafts_BP aircrafts_bp = new Aircrafts_BP(null,name,model,businessClassCapacity,economClassCapacity);
                    PackageData_BP packageData_bp = new PackageData_BP("ADD AIRCRAFT",aircrafts_bp);


                    Admin_BP.socket = new Socket("127.0.0.1",3339);

                    ObjectOutputStream outputStream = new ObjectOutputStream(Admin_BP.socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(Admin_BP.socket.getInputStream());
                    outputStream.writeObject(packageData_bp);

                }catch (Exception exception){
                    exception.printStackTrace();
                }

                nameAircraft.setText("");
                modelAircraft.setText("");
                business_class_capacity.setText("");
                econom_class_capacity.setText("");
            }
        });


        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(700, 700);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showMenu();
            }
        });
    }

    public static int getIdAircraft() {
        return idAircraft;
    }

    public static void setIdAircraft(int id) {
        AddAircraftMenu_BP.idAircraft = id;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getNameAircraft() {
        return nameAircraft;
    }

    public void setNameAircraft(JTextField nameAircraft) {
        this.nameAircraft = nameAircraft;
    }

    public JTextField getModelAircraft() {
        return modelAircraft;
    }

    public void setModelAircraft(JTextField modelAircraft) {
        this.modelAircraft = modelAircraft;
    }

    public JTextField getBusiness_class_capacity() {
        return business_class_capacity;
    }

    public void setBusiness_class_capacity(JTextField business_class_capacity) {
        this.business_class_capacity = business_class_capacity;
    }

    public JTextField getEconom_class_capacity() {
        return econom_class_capacity;
    }

    public void setEconom_class_capacity(JTextField econom_class_capacity) {
        this.econom_class_capacity = econom_class_capacity;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}
