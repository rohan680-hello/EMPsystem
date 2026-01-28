package employee.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Employee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;

    View_Employee() {

        getContentPane().setBackground(new Color(255, 131, 122));
        setLayout(null);

        // --- SEARCH INPUTS ---
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        // Fill Dropdown
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- TABLE SETUP ---
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        // --- BUTTONS ---
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // --- BUTTON LOGIC ---
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchbtn) {
            // Filter table data
            String query = "select * from employee where empID = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
            // new UpdateEmployee(choiceEMP.getSelectedItem()); // Un-comment when Update class is ready
        } else {
            setVisible(false);
            new Main_class();
            // new Home(); // Un-comment when Home class is ready
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}