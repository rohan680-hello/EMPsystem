package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhaar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;
    JButton add, back;

    AddEmployee() {

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // --- ROW 1 ---
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("san_serif", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("san_serif", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        // --- ROW 2 ---
        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("san_serif", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("san_serif", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        // --- ROW 3 ---
        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("san_serif", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Phone no.:");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("san_serif", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        // --- ROW 4 ---
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("san_serif", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("san_serif", Font.BOLD, 20));
        add(education);

        String courses[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(courses);
        Boxeducation.setBackground(Color.WHITE);
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);

        // --- ROW 5 ---
        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("san_serif", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setBounds(400, 350, 150, 30);
        aadhaar.setFont(new Font("san_serif", Font.BOLD, 20));
        add(aadhaar);

        taadhaar = new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        taadhaar.setBackground(new Color(177, 252, 197));
        add(taadhaar);

        // --- Employee ID ---
        JLabel empidLabel = new JLabel("Employee ID:");
        empidLabel.setBounds(50, 400, 150, 30);
        empidLabel.setFont(new Font("san_serif", Font.BOLD, 20));
        add(empidLabel);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // --- Buttons ---
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // CORRECTION: Removed the semicolon ";" that was here
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();
            String aadhaar = taadhaar.getText();

            try {
                conn c = new conn(); // Capital 'C' for class name
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhaar + "', '" + empID + "')";
                c.statement.executeUpdate(query); // Use 's' (Statement)
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                // new Main_class(); // Uncomment this if you have the Main_class ready
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();
            // new Main_class(); // Uncomment this if you have the Main_class ready
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}