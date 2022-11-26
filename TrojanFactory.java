package com.virus.tf;

import java.io.File;
import java.util.Scanner;
import java.util.Formatter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
 *
 * @author SecVirus
 * 
 */

public class TrojanFactory {

    public static void main(String[] args) {
        JFrame window;
        JPanel panel;
        JTextField target_file_input, file_name_input, file_real_extension_input, file_fake_extension_input;
        JButton target_file_browse, run;
        JLabel software_name_label, target_lbl, name_lbl, real_extension_lbl, fake_extension_lbl;
        File current_name, new_name;
        Formatter $error_new_exist, $error_current_notFound;
        Scanner scaner = new Scanner(System.in);

        boolean rename_operation;
        Dimension ss;
        char rc = '\u202e'; // reverse character
        int win_width, win_height;

        window = new JFrame("Trojan Factory");
        Theme.toggle_theme(window);

        window.setResizable(false);
        ss = Toolkit.getDefaultToolkit().getScreenSize(); // ss=screen size
        win_width = ss.width / 3;
        win_height = (int) (ss.height / 2.5f);

        panel = new JPanel();
        panel.setLayout(null);
//        panel.setBackground(new Color(0x222222));

        software_name_label = new JLabel("Trojan Factory");
        software_name_label.setToolTipText("Trojan Factory OSINT tool (:");
//		software_name_label.setPreferredSize(new Dimension(100, 100));
        software_name_label.setFont(new Font("", Font.BOLD, 25));
        software_name_label.setForeground(Color.gray);
        software_name_label.setLayout(new BorderLayout());
        software_name_label.setVisible(true);

        /**
         * ********************** TARGET FILE ****************************
         */
        target_lbl = new JLabel("File"); // Select target file to spoof
        target_lbl.setToolTipText("Select target file to spoof");
        target_lbl.setBounds(17, 60, 53, 100);
        target_lbl.setForeground(Color.lightGray);
        target_lbl.setFont(new Font("", Font.BOLD, 18));

        target_file_input = new JTextField();

        target_file_input.setLayout(new FlowLayout());
        target_file_input.setSize(new Dimension(win_width - 50, 30));
//        target_file_input.setBackground(Color.decode("#1a1a1a"));
        target_file_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        target_file_input.setCaretColor(Color.white);
        target_file_input.setSelectedTextColor(Color.decode("#b3b3b3"));
        target_file_input.setBounds((int) (win_width / 8.5f), 95, win_width - 153, 30);
        target_file_input.setSelectionColor(Color.decode("#404040"));
        target_file_input.setForeground(Color.white);
        target_file_input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                target_file_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.white), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                target_file_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        });
        target_file_browse = new JButton("...");
        target_file_browse.setBounds(568, 95, 30, 30);
        target_file_browse.setFocusable(false);
        target_file_browse.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        target_file_browse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        target_file_browse.setBorder(null);

        target_file_browse.addActionListener((ActionEvent e) -> {
            JFileChooser chooseFile;
            chooseFile = new JFileChooser(".");
            int returnVal = chooseFile.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File sel_f = chooseFile.getSelectedFile();
                target_file_input.setText(sel_f.getAbsolutePath());
                target_file_input.setToolTipText(sel_f.getName());
            }
        });

        /**
         * ************************ FILE NAME ****************************
         */
        name_lbl = new JLabel("Name"); // New spoofed file name
        name_lbl.setToolTipText("New spoofed file name");
        name_lbl.setBounds(17, 120, 53, 100);
        name_lbl.setForeground(Color.lightGray);
        name_lbl.setFont(new Font("", Font.BOLD, 18));

        file_name_input = new JTextField();

        file_name_input.setLayout(new FlowLayout());
        file_name_input.setSize(new Dimension(win_width - 50, 30));
        file_name_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        file_name_input.setCaretColor(Color.white);
        file_name_input.setSelectedTextColor(Color.decode("#b3b3b3"));
        file_name_input.setBounds((int) (win_width / 8.3f), 155, win_width - 120, 30);
        file_name_input.setSelectionColor(Color.decode("#404040"));
        file_name_input.setForeground(Color.white);
        file_name_input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                file_name_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.white), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }

            public void focusLost(FocusEvent e) {
                file_name_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        });

        /**
         * ******************* FILE REAL EXTENSION ***********************
         */
        real_extension_lbl = new JLabel("Real"); // Real file extension
        real_extension_lbl.setToolTipText("Real file extension");
        real_extension_lbl.setBounds(17, 180, 53, 100);
        real_extension_lbl.setForeground(Color.lightGray);
        real_extension_lbl.setFont(new Font("", Font.BOLD, 18));

        file_real_extension_input = new JTextField();

        file_real_extension_input.setLayout(new FlowLayout());
        file_real_extension_input.setSize(new Dimension(win_width - 50, 30));
        file_real_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        file_real_extension_input.setCaretColor(Color.white);
        file_real_extension_input.setSelectedTextColor(Color.decode("#b3b3b3"));
        file_real_extension_input.setBounds((int) (win_width / 8.3f), 215, win_width - 120, 30);
        file_real_extension_input.setSelectionColor(Color.decode("#404040"));
        file_real_extension_input.setForeground(Color.white);
        file_real_extension_input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                file_real_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.white), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }

            public void focusLost(FocusEvent e) {
                file_real_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        });

        /**
         * ******************* FILE FAKE EXTENSION ***********************
         */
        fake_extension_lbl = new JLabel("Fake"); // Fake file extension
        fake_extension_lbl.setToolTipText("Fake file extension");
        fake_extension_lbl.setBounds(17, 240, 53, 100);
        fake_extension_lbl.setForeground(Color.lightGray);
        fake_extension_lbl.setFont(new Font("", Font.BOLD, 18));

        file_fake_extension_input = new JTextField();

        file_fake_extension_input.setLayout(new FlowLayout());
        file_fake_extension_input.setSize(new Dimension(win_width - 50, 30));
        file_fake_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        file_fake_extension_input.setCaretColor(Color.white);
        file_fake_extension_input.setSelectedTextColor(Color.decode("#b3b3b3"));
        file_fake_extension_input.setBounds((int) (win_width / 8.3f), 275, win_width - 120, 30);
        file_fake_extension_input.setSelectionColor(Color.decode("#404040"));
        file_fake_extension_input.setForeground(Color.white);
        file_fake_extension_input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                file_fake_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.white), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }

            public void focusLost(FocusEvent e) {
                file_fake_extension_input.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        });

        /**
         * ***************** RUN FILE SPOOFING PROCESS *******************
         */
        run = new JButton("Run");
        run.setLayout(null);
        run.setBounds(497, 330, 100, 30);
//        run.setBackground(Color.decode("#8cffac"));
        run.setForeground(Color.white);
        run.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.gray), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        run.setCursor(new Cursor(Cursor.HAND_CURSOR));
        run.addActionListener((ActionEvent e) -> {
            if (target_file_input.getText().length() > 0) {
                if (new File(target_file_input.getText()).exists()) {
                    String fake_extension, real_extension, file_name, path_seperator, file_path;
                    File new_name1, current_name1;
                    Boolean rename_operation1;
                    
                    file_name = file_name_input.getText();
                    current_name1 = new File(target_file_input.getText());
                    real_extension = file_real_extension_input.getText();
                    fake_extension = new StringBuilder(file_fake_extension_input.getText()).reverse().toString();
                    file_path = new File(target_file_input.getText()).getParentFile().toString();
                    
                    path_seperator = File.separator;
                    new_name1 = new File(file_path + path_seperator + file_name + rc + fake_extension + "." + real_extension);
                    System.out.print(new_name1);
                    
                    if (!(new_name1.exists()) || new_name1 != null) {
                        rename_operation1 = current_name1.renameTo(new_name1);
                        if (rename_operation1 == true) {
                            JOptionPane.showMessageDialog(null, "'" + target_file_input.getText() + "' " + "successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Couldn't spoof " + target_file_input.getText(), "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {}
                } else {
                    JOptionPane.showMessageDialog(null, "'" + target_file_input.getText() + "' " + "not exist!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Choose a file to spoof", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
        run.setFocusable(false);

        panel.add(run);

        panel.add(file_fake_extension_input);
        panel.add(fake_extension_lbl);

        panel.add(file_real_extension_input);
        panel.add(real_extension_lbl);

        panel.add(file_name_input);
        panel.add(name_lbl);

        panel.add(target_file_browse);
        panel.add(target_file_input);
        panel.add(target_lbl);

        window.getContentPane().setLayout(null);
        window.setContentPane(panel);
        window.setSize(win_width, win_height);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}