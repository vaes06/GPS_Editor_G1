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
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
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
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public EditorWindow() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		frmEditor = new JFrame();
		frmEditor.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		frmEditor.setTitle("Editor 3000");
		frmEditor.setBounds(100, 100, 653, 582);
		frmEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		
		final JTextArea textArea = new JTextArea();
		frmEditor.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setLineWrap(true); 
		JScrollPane scroll = new JScrollPane(textArea);
		frmEditor.getContentPane().add(scroll,BorderLayout.CENTER);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmEditor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/home.gif")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/new.png")));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditorWindow window = null;
				try {
					window = new EditorWindow();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.frmEditor.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/open.png")));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mensaje();
				
			}
		});
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/save.png")));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//JOptionPane.showMessageDialog(null,"Recuerda ");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result= fileChooser.showSaveDialog(frmEditor);
				if (result== JFileChooser.CANCEL_OPTION) return;
					File name= fileChooser.getSelectedFile();
					try {
						PrintWriter output= new PrintWriter(new FileWriter( name));
						output.write(textArea.getText());
						output.close();
					}
					catch (IOException ioException) {
						JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		mnNewMenu.add(mntmGuardar);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmEnConstruccin_1 = new JMenuItem("En construcción...");
		mntmEnConstruccin_1.setForeground(Color.BLUE);
		mnNewMenu.add(mntmEnConstruccin_1);
		
		JMenu mnFormato = new JMenu("Formato");
		mnFormato.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/themes.gif")));
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
		mnCerrar.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/exit.gif")));
		menuBar.add(mnCerrar);
		
		JMenuItem mntmEnConstruccin = new JMenuItem("En construcción...");
		mntmEnConstruccin.setForeground(Color.BLUE);
		mnCerrar.add(mntmEnConstruccin);
		
		JToolBar toolBar = new JToolBar();
		frmEditor.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result= fileChooser.showSaveDialog(frmEditor);
				if (result== JFileChooser.CANCEL_OPTION) return;
					File name= fileChooser.getSelectedFile();
					try {
						PrintWriter output= new PrintWriter(new FileWriter( name));
						output.write(textArea.getText());
						output.close();
					}
					catch (IOException ioException) {
						JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/save.png")));
		toolBar.add(btnNewButton);
		

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		frmEditor.getContentPane().add(scrollBar_1, BorderLayout.SOUTH);


		
	}
	private void mensaje() {
		JOptionPane.showMessageDialog(null, "Opción disponible en el siguiente entregable","Trabajamos para ti...!", 1);
	}
}
