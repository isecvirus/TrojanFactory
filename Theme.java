package com.virus.tf;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SecVirus
 * 
 */

public class Theme {
    public static void toggle_theme(JFrame window) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(window);
        } catch (UnsupportedLookAndFeelException error) {
            error.printStackTrace();
        }
    }
}
