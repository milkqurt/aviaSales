package BIGPROJECT;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListTicketsMenu_BP extends Container {
    protected JButton backButton;
    protected JButton delButton;
    protected JButton tableButton;
    private String header[] = {"id","flight_id","name","surname","passport_number","ticket_type","strflightName"};
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel label;
    protected JTextField deleteId;


    DBManager_BP dbManager_bp = new DBManager_BP();


    public ListTicketsMenu_BP(){
        setSize(1400,800);
        setLayout(null);

        dbManager_bp.connect();
        ArrayList<Tickets_BP> tickets_bpArrayList = new ArrayList<>(dbManager_bp.getAllTickets());


        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(1200,400);
        scrollPane.setLocation(100,60);
        add(scrollPane);


        Object data[][] = new Object[tickets_bpArrayList.size()][7];

        for(int i =0;i<tickets_bpArrayList.size();i++){
            data[i][0] = tickets_bpArrayList.get(i).getId();
            data[i][1] = tickets_bpArrayList.get(i).getFlight_id();
            data[i][2] = tickets_bpArrayList.get(i).getName();
            data[i][3] = tickets_bpArrayList.get(i).getSurname();
            data[i][4] = tickets_bpArrayList.get(i).getPassport_number();
            data[i][5] = tickets_bpArrayList.get(i).getTicket_type();
            data[i][6] = tickets_bpArrayList.get(i).getStrflightName();

        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);


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
                dbManager_bp.connect();
                dbManager_bp.deleteTickets(longId);

                deleteId.setText("");
            }
        });


        tableButton = new JButton("Обнавить таблицу");
        tableButton.setSize(200, 30);
        tableButton.setLocation(600, 500);
        add(tableButton);
        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbManager_bp.connect();
                ArrayList<Tickets_BP> tickets_bpArrayList = new ArrayList<>(dbManager_bp.getAllTickets());
                Object data[][] = new Object[tickets_bpArrayList.size()][7];

                for(int i =0;i<tickets_bpArrayList.size();i++){
                    data[i][0] = tickets_bpArrayList.get(i).getId();
                    data[i][1] = tickets_bpArrayList.get(i).getFlight_id();
                    data[i][2] = tickets_bpArrayList.get(i).getName();
                    data[i][3] = tickets_bpArrayList.get(i).getSurname();
                    data[i][4] = tickets_bpArrayList.get(i).getPassport_number();
                    data[i][5] = tickets_bpArrayList.get(i).getTicket_type();
                    data[i][6] = tickets_bpArrayList.get(i).getStrflightName();

                }

                DefaultTableModel model = new DefaultTableModel(data, header);
                table.setModel(model);

            }
        });


        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(1200, 700);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cashier_BP.frame2.showMenu();
            }
        });
    }
}
