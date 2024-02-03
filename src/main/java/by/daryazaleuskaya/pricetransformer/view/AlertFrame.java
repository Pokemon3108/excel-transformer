package by.daryazaleuskaya.pricetransformer.view;

import javax.swing.*;
import java.awt.*;

class AlertFrame extends JFrame {

    public AlertFrame(String labelName, Color alertColor) {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Only close this frame, not the whole application
        setSize(250, 100);
        setLocationRelativeTo(null);
        setTitle("Confirmation");

        JLabel label = new JLabel(labelName);
        label.setForeground(alertColor);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton button = new JButton("OK");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            AlertFrame.this.dispose();
        });

        add(label);
        add(Box.createVerticalStrut(10));
        add(button);
    }
}
