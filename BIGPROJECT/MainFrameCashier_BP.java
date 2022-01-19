package BIGPROJECT;

import javax.swing.*;

public class MainFrameCashier_BP extends JFrame {
    protected MainMenuCashier_BP mainMenuCashier_bp;
    protected AddTicketsMenu_BP addTicketsMenu_bp;
    protected ListTicketsMenu_BP listTicketsMenu_bp;

    public MainFrameCashier_BP(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CASHIER APPLICATION");
        setSize(1400,800);
        setLayout(null);

        mainMenuCashier_bp = new MainMenuCashier_BP();
        mainMenuCashier_bp.setVisible(true);
        add(mainMenuCashier_bp);

        addTicketsMenu_bp = new AddTicketsMenu_BP();
        addTicketsMenu_bp.setVisible(false);
        add(addTicketsMenu_bp);

        listTicketsMenu_bp = new ListTicketsMenu_BP();
        listTicketsMenu_bp.setVisible(false);
        add(listTicketsMenu_bp);


    }

    public void showMenu(){
        mainMenuCashier_bp.setVisible(true);
        addTicketsMenu_bp.setVisible(false);
        listTicketsMenu_bp.setVisible(false);
    }

    public void showAddTicketsMenu(){
        mainMenuCashier_bp.setVisible(false);
        addTicketsMenu_bp.setVisible(true);
        listTicketsMenu_bp.setVisible(false);
    }

    public void showListTicketsMenu(){
        mainMenuCashier_bp.setVisible(false);
        addTicketsMenu_bp.setVisible(false);
        listTicketsMenu_bp.setVisible(true);
    }
}
