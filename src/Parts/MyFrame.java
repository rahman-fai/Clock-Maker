package Parts;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyFrame extends JFrame {
    Color BackGroundColor = new Color(0x35637C);
    Color textColor = new Color(0xDFF2EE);

    Font promptF = new Font("Segoe UI", Font.PLAIN, 15);
    Font promptTitle = new Font("Segoe UI", Font.PLAIN, 30);

    Dimension textBoxD = new DimensionUIResource(300, 30);
    Dimension fieldD = new DimensionUIResource(150, 30);
    Dimension frameD = Toolkit.getDefaultToolkit().getScreenSize();

    JMenuBar bar;

    JPanel RightPanel, UIPanel;

    JFormattedTextField fieldE, fieldMin, fieldMax, fieldMod, fieldBpH, fieldPin;
    JButton calcButton;

    Clocker c1;

    MyFrame() {
        setTitle("Clock maker");// !!!come up with better name
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        setVisible(true);
        setLayout(new BorderLayout());
        // !!! set image icon
        getContentPane().setBackground(BackGroundColor);

        // Menu bar
        bar = new JMenuBar();
        setJMenuBar(bar);
        bar.setVisible(true);

        // Right Panel
        RightPanel = new JPanel();
        RightPanel.setBackground(BackGroundColor);
        RightPanel.setSize(fieldD.width + textBoxD.width, frameD.height);
        RightPanel.setLayout(new BorderLayout());
        add(RightPanel, BorderLayout.EAST);

        JLabel promptMainRight = new JLabel();
        promptMainRight.setText("Clock Information");
        promptMainRight.setFont(promptTitle);
        promptMainRight.setForeground(textColor);

        RightPanel.add(promptMainRight, BorderLayout.NORTH);

        // User input panel
        UIPanel = new JPanel();
        UIPanel.setBackground(BackGroundColor);
        UIPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));

        UIPanel.setSize(fieldD.width + textBoxD.width, frameD.height * -50);
        RightPanel.add(UIPanel, BorderLayout.CENTER);
        UIPanel.setLayout(new GridLayout(6, 2));

        // promt for E
        JLabel promtE = new JLabel();
        promtE.setText("No. teeth on Ecsapemnet wheel: ");
        promtE.setSize(textBoxD);
        promtE.setForeground(textColor);
        promtE.setFont(promptF);
        UIPanel.add(promtE, 0);

        promtE.setBorder(BorderFactory.createLineBorder(Color.green));

        // Text Feild for E
        fieldE = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fieldE.setSize(fieldD);
        UIPanel.add(fieldE, 1);

        fieldE.setBackground(Color.red);

        // promt for min
        JLabel promtMin = new JLabel();
        promtMin.setText("Min No. of teeth: ");
        promtMin.setSize(textBoxD);
        promtMin.setForeground(textColor);
        promtMin.setFont(promptF);
        UIPanel.add(promtMin, 2);
        promtMin.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for min
        fieldMin = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fieldMin.setSize(fieldD);
        UIPanel.add(fieldMin, 3);

        fieldMin.setBackground(Color.orange);

        // promt for Max
        JLabel promtMax = new JLabel();
        promtMax.setText("Max No. of teeth");
        promtMax.setSize(textBoxD);
        promtMax.setForeground(textColor);
        promtMax.setFont(promptF);
        UIPanel.add(promtMax, 4);
        promtMax.setBorder(BorderFactory.createLineBorder(Color.green));

        // Text Feild for Max
        fieldMax = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fieldMax.setSize(fieldD);
        UIPanel.add(fieldMax, 5);

        fieldMax.setBackground(Color.yellow);

        // promt for Mod
        JLabel promtMod = new JLabel();
        promtMod.setText("Modulus(mm)");
        promtMod.setSize(textBoxD);
        promtMod.setForeground(textColor);
        promtMod.setFont(promptF);
        UIPanel.add(promtMod, 6);
        promtMod.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for Mod
        fieldMod = new JFormattedTextField(DecimalFormat.getInstance());
        fieldMod.setSize(fieldD);
        UIPanel.add(fieldMod, 7);

        fieldMod.setBackground(Color.green);

        // promt for Bph
        JLabel promtBpH = new JLabel();
        promtBpH.setText("Beats per hour: ");
        promtBpH.setSize(textBoxD);
        promtBpH.setForeground(textColor);
        promtBpH.setFont(promptF);
        UIPanel.add(promtBpH, 8);
        promtBpH.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        // Text Feild for BpH
        fieldBpH = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fieldBpH.setSize(fieldD);
        UIPanel.add(fieldBpH, 9);

        fieldBpH.setBackground(Color.BLUE);

        // promt for PIn
        JLabel promtPin = new JLabel();
        promtPin.setText("Pin diameter(mm): ");
        promtPin.setSize(textBoxD);
        promtPin.setForeground(textColor);
        promtPin.setFont(promptF);
        UIPanel.add(promtPin, 10);
        promtPin.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for Pin
        fieldPin = new JFormattedTextField(DecimalFormat.getInstance());
        fieldPin.setSize(fieldD);
        UIPanel.add(fieldPin, 11);

        fieldPin.setBackground(Color.magenta);

        // Calculate button
        JPanel calcBtNest = new JPanel();
        calcButton = new JButton("Calculate");
        calcBtNest.setBackground(BackGroundColor);

        calcButton.setVisible(true);
        calcButton.addActionListener(e -> calcClockVals());
        calcButton.setBorder(BorderFactory.createEtchedBorder(textColor, BackGroundColor));
        calcButton.setBackground(BackGroundColor);
        calcButton.setForeground(textColor);
        calcBtNest.add(calcButton);
        RightPanel.add(calcBtNest, BorderLayout.SOUTH);
        pack();

    }



    public void calcClockVals() {
        if (fieldE.isEditValid() && fieldMax.isEditValid() && fieldMin.isEditValid() && fieldMod.isEditValid()
                && fieldBpH.isEditValid() && fieldPin.isEditValid()) {

            c1 = new Clocker();

            c1.makeTrain((Integer.parseInt(fieldMin.getText())), Integer.parseInt(fieldMax.getText()),
                    Double.parseDouble(fieldMod.getText()),
                    Integer.parseInt(fieldBpH.getText().replace(",","")),
                    Integer.parseInt(fieldE.getText()),
                    Double.parseDouble(fieldPin.getText()));
        }

    }


}
