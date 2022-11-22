
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyFrame extends JFrame {
    Color BackGroundColor = new Color(0x35637C);
    Color textColor = new Color(0xDFF2EE);

    Font promtF = new Font("Segoe UI", Font.PLAIN, 15);
    Font promtTitle = new Font("Segoe UI", Font.PLAIN, 30);

    Dimension textBoxD = new DimensionUIResource(300, 30);
    Dimension feildD = new DimensionUIResource(150, 30);
    Dimension frameD = Toolkit.getDefaultToolkit().getScreenSize();

    JMenuBar bar;

    JPanel RightPanel, UIPanel;

    JFormattedTextField feildE, feildMin, feildMax, feildMod, feildBpH, feildPin;
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
        RightPanel.setSize(feildD.width + textBoxD.width, frameD.height);
        RightPanel.setLayout(new BorderLayout());
        add(RightPanel, BorderLayout.EAST);

        JLabel promtMainRight = new JLabel();
        promtMainRight.setText("Clock Information");
        promtMainRight.setFont(promtTitle);
        promtMainRight.setForeground(textColor);

        RightPanel.add(promtMainRight, BorderLayout.NORTH);

        // User input panel
        UIPanel = new JPanel();
        UIPanel.setBackground(BackGroundColor);
        UIPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));

        UIPanel.setSize(feildD.width + textBoxD.width, frameD.height * -50);
        RightPanel.add(UIPanel, BorderLayout.CENTER);
        UIPanel.setLayout(new GridLayout(6, 2));

        // promt for E
        JLabel promtE = new JLabel();
        promtE.setText("No. teeth on Ecsapemnet wheel: ");
        promtE.setSize(textBoxD);
        promtE.setForeground(textColor);
        promtE.setFont(promtF);
        UIPanel.add(promtE, 0);

        promtE.setBorder(BorderFactory.createLineBorder(Color.green));

        // Text Feild for E
        feildE = new JFormattedTextField(NumberFormat.getIntegerInstance());
        feildE.setSize(feildD);
        UIPanel.add(feildE, 1);

        feildE.setBackground(Color.red);

        // promt for min
        JLabel promtMin = new JLabel();
        promtMin.setText("Min No. of teeth: ");
        promtMin.setSize(textBoxD);
        promtMin.setForeground(textColor);
        promtMin.setFont(promtF);
        UIPanel.add(promtMin, 2);
        promtMin.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for min
        feildMin = new JFormattedTextField(NumberFormat.getIntegerInstance());
        feildMin.setSize(feildD);
        UIPanel.add(feildMin, 3);

        feildMin.setBackground(Color.orange);

        // promt for Max
        JLabel promtMax = new JLabel();
        promtMax.setText("Max No. of teeth");
        promtMax.setSize(textBoxD);
        promtMax.setForeground(textColor);
        promtMax.setFont(promtF);
        UIPanel.add(promtMax, 4);
        promtMax.setBorder(BorderFactory.createLineBorder(Color.green));

        // Text Feild for Max
        feildMax = new JFormattedTextField(NumberFormat.getIntegerInstance());
        feildMax.setSize(feildD);
        UIPanel.add(feildMax, 5);

        feildMax.setBackground(Color.yellow);

        // promt for Mod
        JLabel promtMod = new JLabel();
        promtMod.setText("Modulus(mm)");
        promtMod.setSize(textBoxD);
        promtMod.setForeground(textColor);
        promtMod.setFont(promtF);
        UIPanel.add(promtMod, 6);
        promtMod.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for Mod
        feildMod = new JFormattedTextField(DecimalFormat.getInstance());
        feildMod.setSize(feildD);
        UIPanel.add(feildMod, 7);

        feildMod.setBackground(Color.green);

        // promt for Bph
        JLabel promtBpH = new JLabel();
        promtBpH.setText("Beats per hour: ");
        promtBpH.setSize(textBoxD);
        promtBpH.setForeground(textColor);
        promtBpH.setFont(promtF);
        UIPanel.add(promtBpH, 8);
        promtBpH.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        // Text Feild for BpH
        feildBpH = new JFormattedTextField(NumberFormat.getIntegerInstance());
        feildBpH.setSize(feildD);
        UIPanel.add(feildBpH, 9);

        feildBpH.setBackground(Color.BLUE);

        // promt for PIn
        JLabel promtPin = new JLabel();
        promtPin.setText("Pin diameter(mm): ");
        promtPin.setSize(textBoxD);
        promtPin.setForeground(textColor);
        promtPin.setFont(promtF);
        UIPanel.add(promtPin, 10);
        promtPin.setBorder(BorderFactory.createLineBorder(Color.orange));

        // Text Feild for Pin
        feildPin = new JFormattedTextField(DecimalFormat.getInstance());
        feildPin.setSize(feildD);
        UIPanel.add(feildPin, 11);

        feildPin.setBackground(Color.magenta);

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
        if (feildE.isEditValid() && feildMax.isEditValid() && feildMin.isEditValid() && feildMod.isEditValid()
                && feildBpH.isEditValid() && feildPin.isEditValid()) {

            c1 = new Clocker();
            int a = Integer.parseInt(feildBpH.getText());
            c1.makeTrain((Integer.parseInt(feildMin.getText())), Integer.parseInt(feildMax.getText()),
                    Double.parseDouble(feildMod.getText()),
                    a, Integer.parseInt(feildE.getText()),
                    Double.parseDouble(feildPin.getText()));
        }

    }

}
