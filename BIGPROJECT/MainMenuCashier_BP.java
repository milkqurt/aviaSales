package BIGPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuCashier_BP extends Container {
    protected JButton addButton;
    protected JButton listButton;
    protected JButton exitButton;

    public MainMenuCashier_BP(){
        setSize(1400,800);
        setLayout(null);


        addButton = new JButton("ADD TICKETS");
        addButton.setSize(300,30);
        addButton.setLocation(100,120);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cashier_BP.frame2.showAddTicketsMenu();
            }
        });


        listButton = new JButton("LIST TICKETS");
        listButton.setSize(300,30);
        listButton.setLocation(100,160);
        add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cashier_BP.frame2.showListTicketsMenu();
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getListButton() {
        return listButton;
    }

    public void setListButton(JButton listButton) {
        this.listButton = listButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
}
