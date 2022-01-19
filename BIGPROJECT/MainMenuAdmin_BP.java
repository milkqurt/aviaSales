package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuAdmin_BP extends Container {
    protected JButton addAircraft;
    protected JButton addCity;
    protected JButton addFlights;
    protected JButton exitButton;
    protected JButton listAircraft;
    protected JButton listCity;
    protected JButton listFlights;


    public MainMenuAdmin_BP(){
        setSize(1400,800);
        setLayout(null);


        addAircraft = new JButton("ADD AIRCRAFT");
        addAircraft.setSize(300,30);
        addAircraft.setLocation(100,120);
        add(addAircraft);
        addAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showAddAircraftMenu();
            }
        });


        addCity = new JButton("ADD CITY");
        addCity.setSize(300,30);
        addCity.setLocation(100,160);
        add(addCity);
        addCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showAddCityMenu();
            }
        });


        addFlights = new JButton("ADD FLIGHTS");
        addFlights.setSize(300,30);
        addFlights.setLocation(100,200);
        add(addFlights);
        addFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showAddFlightsMenu();
            }
        });


        listAircraft = new JButton("LIST AIRCRAFT");
        listAircraft.setSize(300,30);
        listAircraft.setLocation(100,240);
        add(listAircraft);
        listAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showListAircraftMenu();
            }
        });


        listCity = new JButton("LIST CITY");
        listCity.setSize(300,30);
        listCity.setLocation(100,280);
        add(listCity);
        listCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showListCityMenu();
            }
        });


        listFlights = new JButton("LIST FLIGHTS");
        listFlights.setSize(300,30);
        listFlights.setLocation(100,320);
        add(listFlights);
        listFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showListFlightsMenu();
            }
        });



        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,360);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


    public JButton getAddAircraft() {
        return addAircraft;
    }

    public void setAddAircraft(JButton addAircraft) {
        this.addAircraft = addAircraft;
    }

    public JButton getAddCity() {
        return addCity;
    }

    public void setAddCity(JButton addCity) {
        this.addCity = addCity;
    }

    public JButton getAddFlights() {
        return addFlights;
    }

    public void setAddFlights(JButton addFlights) {
        this.addFlights = addFlights;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JButton getListAircraft() {
        return listAircraft;
    }

    public void setListAircraft(JButton listAircraft) {
        this.listAircraft = listAircraft;
    }

    public JButton getListCity() {
        return listCity;
    }

    public void setListCity(JButton listCity) {
        this.listCity = listCity;
    }

    public JButton getListFlights() {
        return listFlights;
    }

    public void setListFlights(JButton listFlights) {
        this.listFlights = listFlights;
    }
}
