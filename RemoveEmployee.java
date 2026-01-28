package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton delete, back;
    JLabel lblName, lblPhone, lblEmail;

    RemoveEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // --- Heading ---
        JLabel label = new JLabel("Employee Id");
        label.setBounds(50, 50, 100, 30);
        add(label);

        // --- Dropdown for Employee ID ---
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try {
            // CORRECTION 1:
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            while (rs.next()) {
                cEmpId.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Labels ---
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        lblName = new JLabel();
        lblName.setBounds(200, 100, 100, 30);
        add(lblName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        lblPhone = new JLabel();
        lblPhone.setBounds(200, 150, 100, 30);
        add(lblPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail);

        lblEmail = new JLabel();
        lblEmail.setBounds(200, 200, 100, 30);
        add(lblEmail);

        // --- Load Data for the Initially Selected Item ---
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee where empID = '" + cEmpId.getSelectedItem() + "'");
            while (rs.next()) {
                lblName.setText(rs.getString("name"));
                lblPhone.setText(rs.getString("phone"));
                lblEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Dynamic Update When Dropdown Changes ---
        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery("select * from employee where empID = '" + cEmpId.getSelectedItem() + "'");
                    while (rs.next()) {
                        lblName.setText(rs.getString("name"));
                        lblPhone.setText(rs.getString("phone"));
                        lblEmail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // --- Buttons ---
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // --- Images ---
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconsimg/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("iconsimg/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        // CORRECTION 2: Fixed variable name from 'img' to 'image'
        image.setBounds(0, 0, 1120, 630);
        add(image);

        setSize(1000, 400);
        setLocation(300, 150);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // CORRECTION 3: Implemented Button Logic
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                String query = "delete from employee where empID = '" + cEmpId.getSelectedItem() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Main_class();
                // new Home(); // Uncomment if you have the Home class
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            // new Home(); // Uncomment if you have the Home class
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}