package BIGPROJECT;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCityMenu_BP extends Container {
    protected JLabel label;
    protected JButton backButton;
    protected JTextField deleteId;
    protected JButton delButton;
    protected JButton tableButton;
    private JScrollPane scrollPane;
    private String header[] = {"id","name","country","short_name"};
    private JTable table;

    DBManager_BP dbManager_bp = new DBManager_BP();

    public ListCityMenu_BP(){
        setSize(1400,800);
        setLayout(null);

        dbManager_bp.connect();

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(1200,400);
        scrollPane.setLocation(100,60);
        add(scrollPane);

        tableButton = new JButton("Обнавить таблицу");
        tableButton.setSize(200, 30);
        tableButton.setLocation(600, 500);
        add(tableButton);
        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Cities_BP> cities_bpArrayList = new ArrayList<>(dbManager_bp.getAllCity());
                Object data[][] = new Object[cities_bpArrayList.size()][4];

                for(int i =0;i<cities_bpArrayList.size();i++){
                    data[i][0] = cities_bpArrayList.get(i).getId();
                    data[i][1] = cities_bpArrayList.get(i).getName();
                    data[i][2] = cities_bpArrayList.get(i).getCountry();
                    data[i][3] = cities_bpArrayList.get(i).getShort_Name();


                }

                DefaultTableModel model = new DefaultTableModel(data, header);
                table.setModel(model);

            }
        });


        label = new JLabel("deleteId : ");
        label.setSize(100,30);
        label.setLocation(100,500);
        add(label);

        deleteId = new JTextField("");
        deleteId.setSize(60,30);
        deleteId.setLocation(180,500);
        add(deleteId);

        delButton = new JButton("DEL");
        delButton.setSize(100, 30);
        delButton.setLocation(260, 500);
        add(delButton);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = deleteId.getText();
                Long longId = Long.valueOf(id);

                dbManager_bp.deleteCity(longId);

                deleteId.setText("");
            }
        });


        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(1200, 700);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_BP.frame.showMenu();
            }
        });
    }


    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JTextField getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(JTextField deleteId) {
        this.deleteId = deleteId;
    }

    public JButton getDelButton() {
        return delButton;
    }

    public void setDelButton(JButton delButton) {
        this.delButton = delButton;
    }

    public JButton getTableButton() {
        return tableButton;
    }

    public void setTableButton(JButton tableButton) {
        this.tableButton = tableButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DBManager_BP getDbManager_bp() {
        return dbManager_bp;
    }

    public void setDbManager_bp(DBManager_BP dbManager_bp) {
        this.dbManager_bp = dbManager_bp;
    }
}
