package com.grupo01.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;

public class EditorWindow {

	private JFrame frmEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorWindow window = new EditorWindow();
					window.frmEditor.setVisible(true);
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
		frmEditor = new JFrame();
		frmEditor.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		frmEditor.setTitle("Editor 3000");
		frmEditor.setBounds(100, 100, 744, 582);
		frmEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmEditor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditorWindow window = new EditorWindow();
				window.frmEditor.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje();
			}
		});
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje();
			}
		});
		mnNewMenu.add(mntmGuardar);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmEnConstruccin_1 = new JMenuItem("En construcción...");
		mntmEnConstruccin_1.setForeground(Color.BLUE);
		mnNewMenu.add(mntmEnConstruccin_1);
		
		JMenu mnFormato = new JMenu("Formato");
		menuBar.add(mnFormato);
		
		JMenuItem mntmTamaoDeLetra = new JMenuItem("Tamaño de letra");
		mntmTamaoDeLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje();
			}
		});
		mnFormato.add(mntmTamaoDeLetra);
		
		JMenuItem mntmFormatoDeLetra = new JMenuItem("Formato de letra");
		mntmFormatoDeLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje();
			}
		});
		mnFormato.add(mntmFormatoDeLetra);
		
		JMenu mnCerrar = new JMenu("Cerrar");
		menuBar.add(mnCerrar);
		
		JMenuItem mntmEnConstruccin = new JMenuItem("En construcción...");
		mntmEnConstruccin.setForeground(Color.BLUE);
		mnCerrar.add(mntmEnConstruccin);
		
		JToolBar toolBar = new JToolBar();
		frmEditor.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje();
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon("D:\\Personal\\MAESTRIA\\ADSW\\GPS_Editor_G1\\src\\main\\resources\\icons\\save-icon.png"));
		toolBar.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		frmEditor.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		frmEditor.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		frmEditor.getContentPane().add(scrollBar_1, BorderLayout.SOUTH);
	
		
	}
	private void mensaje() {
		JOptionPane.showMessageDialog(null, "Opción disponible en el siguiente entregable","Trabajamos para ti...!", 1);
	}
}
