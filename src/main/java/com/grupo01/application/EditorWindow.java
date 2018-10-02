package com.grupo01.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class EditorWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorWindow window = new EditorWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnNewMenu.add(mntmNuevo);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon("D:\\Personal\\MAESTRIA\\ADSW\\GPS_Editor_G1\\src\\main\\resources\\icons\\save-icon.png"));
		toolBar.add(btnNewButton);
	}

}
