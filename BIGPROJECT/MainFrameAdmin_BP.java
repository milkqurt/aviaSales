package BIGPROJECT;

import javax.swing.*;

public class MainFrameAdmin_BP extends JFrame {
    protected MainMenuAdmin_BP menu;
    protected AddAircraftMenu_BP addAircraftMenu_bp;
    protected AddCityMenu_BP addCityMenu_bp;
    protected AddFlightsMenu_BP addFlightsMenu_bp;
    protected ListAircraftMenu_BP listAircraftMenu_bp;
    protected ListCityMenu_BP listCityMenu_bp;
    protected ListFlightsMenu_BP listFlightsMenu_bp;

    public MainFrameAdmin_BP(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ADMIN APPLICATION");
        setSize(1400,800);
        setLayout(null);

        menu = new MainMenuAdmin_BP();
        menu.setVisible(true);
        add(menu);

        addAircraftMenu_bp = new AddAircraftMenu_BP();
        addAircraftMenu_bp.setVisible(false);
        add(addAircraftMenu_bp);

        addCityMenu_bp = new AddCityMenu_BP();
        addCityMenu_bp.setVisible(false);
        add(addCityMenu_bp);

        addFlightsMenu_bp = new AddFlightsMenu_BP();
        addFlightsMenu_bp.setVisible(false);
        add(addFlightsMenu_bp);

        listAircraftMenu_bp = new ListAircraftMenu_BP();
        listAircraftMenu_bp.setVisible(false);
        add(listAircraftMenu_bp);

        listCityMenu_bp = new ListCityMenu_BP();
        listCityMenu_bp.setVisible(false);
        add(listCityMenu_bp);

        listFlightsMenu_bp = new ListFlightsMenu_BP();
        listFlightsMenu_bp.setVisible(false);
        add(listFlightsMenu_bp);
    }

    public void showMenu(){
        menu.setVisible(true);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(false);
    }

    public void showAddAircraftMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(true);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(false);
    }

    public void showAddCityMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(true);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(false);
    }

    public void showAddFlightsMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(true);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(false);
    }

    public void showListFlightsMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(true);
    }

    public void showListAircraftMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(true);
        listCityMenu_bp.setVisible(false);
        listFlightsMenu_bp.setVisible(false);
    }

    public void showListCityMenu(){
        menu.setVisible(false);
        addAircraftMenu_bp.setVisible(false);
        addCityMenu_bp.setVisible(false);
        addFlightsMenu_bp.setVisible(false);
        listAircraftMenu_bp.setVisible(false);
        listCityMenu_bp.setVisible(true);
        listFlightsMenu_bp.setVisible(false);
    }
}
