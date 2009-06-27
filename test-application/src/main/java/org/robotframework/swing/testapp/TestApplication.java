package org.robotframework.swing.testapp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestApplication {
    private JPanel panel;
    private JFrame frame;

    public static void main(String[] args) {
        new TestApplication().runTestApplication();
    }

    public void runTestApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame();
                createMainPanel();
                addMenuBar();
                addComponentsToMainPanel();
                addMainPanelToFrame();
                showGUI();
            }
        });
    }

    private void showGUI() {
        frame.pack();
        frame.setVisible(true);
    }

    private void addMainPanelToFrame() {
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(TestDesktopPane.INSTANCE, BorderLayout.NORTH);
    }

    private void createMainPanel() {
        panel = new JPanel();
        panel.setName("Main Panel");
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.setLayout(flowLayout);
    }

    private void addMenuBar() {
        frame.setJMenuBar(new TestMenuBar());
    }

    private void createFrame() {
        frame = new JFrame("Test App") {
            public Dimension getPreferredSize() {
                return new Dimension(1000, 1000);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsToMainPanel() {
        panel.add(new TestTextField());
        panel.add(new TestButton());
        panel.add(new TestList());
        panel.add(new JCheckBox("Test Checkbox"));
        panel.add(new JCheckBox("Test Checkbox 2"));
        panel.add(new JCheckBox("Test Checkbox 3"));
        panel.add(new JCheckBox("Test Checkbox 4"));
        panel.add(new TestComboBox());
        panel.add(new TestComboBox() {{
            setName("comboboxWithRenderer");
            setRenderer(new DefaultListCellRenderer() {
                public String getText() {
                    return super.getText().toUpperCase();
                }
            });
        }});
        panel.add(new TestLabel());
        panel.add(new TestTable("testTable"));
        panel.add(new TestTable("anotherTable"));
        panel.add(new TestTree());
        panel.add(new TestTabbedPane("testTabbedPane1"));
        panel.add(new TestTabbedPane("testTabbedPane2"));
        panel.add(new TestTextArea());
        panel.add(new TestSpinnerButton());
        panel.add(new TestRadioButton());
        panel.add(new TestToggleButton());
        panel.add(new JButton("Open File Chooser") {{
            setName("openFileChooser");
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TestFileChooser().showSaveDialog(panel);
                }
            });
        }});
        panel.add(new TestEditorPane());
    }
}
