package domain.creditcard.ui.dialog;
/*
		A basic implementation of the JDialog class.
*/

import domain.creditcard.dto.NewCreditUiDTO;
import domain.creditcard.entity.CreditCardType;
import domain.creditcard.ui.frame.CreditCardMainFrame;
import domain.framework.entity.Address;
import domain.framework.entity.Customer;
import domain.framework.ui.command.UICommand;

import javax.swing.*;
import java.time.LocalDate;

public class AddCreditCardAccountDialog extends JDialog {
    private UICommand<NewCreditUiDTO> addCCAccountUICommand;
    private CreditCardMainFrame parentFrame;

    public AddCreditCardAccountDialog(CreditCardMainFrame parent, UICommand<NewCreditUiDTO> uiCommand) {
        super(parent);
        addCCAccountUICommand = uiCommand;
        this.parentFrame = parent;

        initDialog();
    }

    private void initDialog() {
        setTitle("Add credit card account");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(301,373);
        setVisible(false);
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36,12,84,24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,84,24);
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,108,48,24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,132,48,24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12,156,48,24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12,180,48,24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12,204,48,24);
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,252,96,24);
        Label7.setText("Exp. Date");
        getContentPane().add(Label7);
        Label7.setForeground(java.awt.Color.black);
        Label7.setBounds(12,276,72,24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,108,156,20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(84,156,156,20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(84,180,156,20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(84,132,156,20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(84,204,156,20);
        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(84,252,156,20);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(84,276,156,20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,312,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,312,84,24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36,60,84,24);
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12,228,48,24);
        getContentPane().add(JTextField_Email);
        JTextField_Email.setBounds(84,228,156,20);
        //}}
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);
        JRadioButton_Bronze.addMouseListener(aSymMouse);

        JButton_OK.addActionListener(e -> {

            String ccNum = JTextField_CCNR.getText();
            String name = JTextField_NAME.getText();
            String street = JTextField_STR.getText();
            String city = JTextField_CT.getText();
            String zip = JTextField_ZIP.getText();
            String state = JTextField_ST.getText();
            String email = JTextField_Email.getText();
            LocalDate expDate = LocalDate.parse(JTextField_ExpDate.getText());

            CreditCardType accountType;
            if (JRadioButton_Gold.isSelected())
                accountType = CreditCardType.GOLD;
            else if (JRadioButton_Silver.isSelected())
                accountType = CreditCardType.SILVER;
            else
                accountType = CreditCardType.BRONZE;

            NewCreditUiDTO newCreditUiDTO = new NewCreditUiDTO(
                    ccNum, new Customer(name, new Address(street, city, state, zip), email),
                    accountType, expDate
            );
            try {
                addCCAccountUICommand.execute(newCreditUiDTO);
                parentFrame.updateContent();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                dispose();
            }
        });
        JButton_Cancel.addActionListener(e -> dispose());
    }


    //{{DECLARE_CONTROLS
    JRadioButton JRadioButton_Gold = new JRadioButton();
    JRadioButton JRadioButton_Silver = new JRadioButton();
    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel JLabel6 = new JLabel();
    JLabel Label7 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_CT = new JTextField();
    JTextField JTextField_ST = new JTextField();
    JTextField JTextField_STR = new JTextField();
    JTextField JTextField_ZIP = new JTextField();
    JTextField JTextField_CCNR = new JTextField();
    JTextField JTextField_ExpDate = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Cancel = new JButton();
    JRadioButton JRadioButton_Bronze = new JRadioButton();
    JLabel JLabel7 = new JLabel();
    JTextField JTextField_Email = new JTextField();
    //}}


    class SymMouse extends java.awt.event.MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == JRadioButton_Gold)
                JRadioButtonChk_mouseClicked(event);
            else if (object == JRadioButton_Silver)
                JRadioButtonSav_mouseClicked(event);
            else if (object == JRadioButton_Bronze)
                JRadioButtonBronze_mouseClicked(event);


        }
    }

    void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(true);
        JRadioButton_Bronze.setSelected(false);

    }

    void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event) {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(true);

    }
}