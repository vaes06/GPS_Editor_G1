package com.grupo01.application;

import java.awt.EventQueue;

import javax.swing.*;

import com.grupo01.service.Editor_funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JScrollBar;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import javax.swing.Action;
=======
import java.awt.event.ActionEvent;
import java.awt.Font;

>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0

public class EditorWindow {

	private JFrame frmEditor;
	private JTextArea textArea;
	private JButton btnGuardar;
	private JMenu mnNewMenu;
	private JMenuItem mntmGuardarComo;
	private String localPath;
	private final Action action = new SwingAction();
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
<<<<<<< HEAD
	private void initialize() {
		localPath = "";
		
=======
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
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
		
<<<<<<< HEAD
		mnNewMenu = new JMenu("Archivo");
=======
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/home.gif")));
>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/new.png")));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Editor_funciones.nuevo(textArea);			}
		});
		mnNewMenu.add(mntmNuevo);
		
<<<<<<< HEAD
		JMenuItem mntmAbrir = new JMenuItem("Abrir ...");
=======
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/open.png")));
>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
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
<<<<<<< HEAD
				if(localPath.isEmpty()) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save"); 
					int userSelection = fileChooser.showSaveDialog(frmEditor);
					 
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
					    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					    localPath = fileToSave.getAbsolutePath();
					    saveFile(textArea.getText(), localPath);					    
					}
				}else {
					saveFile(textArea.getText(),localPath);
				}
				//mensaje();
				
			}
		});
		mnNewMenu.add(mntmGuardar);
		
		mntmGuardarComo = new JMenuItem("Guardar como ...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save"); 
				int userSelection = fileChooser.showSaveDialog(frmEditor);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				    localPath = fileToSave.getAbsolutePath();
				    if(fileToSave.exists() && !fileToSave.isDirectory()) {
				    	int dialogButton = JOptionPane.YES_NO_OPTION;
						JOptionPane.showConfirmDialog(null,"¿Está seguro que desea reemplazar el archivo existente?","Warning", dialogButton);
						if (dialogButton == JOptionPane.YES_OPTION) saveFile(textArea.getText(), localPath);		 
				    }
				    else 
				    	saveFile(textArea.getText(), localPath);		   			    
				}
				
=======
				Editor_funciones.guardar(frmEditor,textArea);				
>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
			}
		});
		mnNewMenu.add(mntmGuardarComo);
		
		JMenu mnFormato = new JMenu("Formato");
		mnFormato.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/themes.gif")));
		menuBar.add(mnFormato);
		
		JMenuItem mntmTamaoDeLetra = new JMenuItem("Tamaño de letra");
		mntmTamaoDeLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor_funciones.mensaje();
			}
		});
		mnFormato.add(mntmTamaoDeLetra);
		
		JMenuItem mntmFormatoDeLetra = new JMenuItem("Formato de letra");
		mntmFormatoDeLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor_funciones.mensaje();
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
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.TRAILING);
		btnGuardar.setAction(action);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				if(localPath.isEmpty()) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save"); 
					int userSelection = fileChooser.showSaveDialog(frmEditor);
					 
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
					    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					    localPath = fileToSave.getAbsolutePath();
					    saveFile(textArea.getText(), localPath);
					}
				}else {
					saveFile(textArea.getText(),localPath);
				}
			}
		});
		btnGuardar.setIcon(new ImageIcon("D:\\Personal\\MAESTRIA\\ADSW\\GPS_Editor_G1\\src\\main\\resources\\icons\\save-icon.png"));
		toolBar.add(btnGuardar);
		
		//JTextArea 
		textArea = new JTextArea();
		frmEditor.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		frmEditor.getContentPane().add(scrollBar, BorderLayout.EAST);
		
=======
				Editor_funciones.guardar(frmEditor,textArea);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/save.png")));
		toolBar.add(btnNewButton);
		

>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		frmEditor.getContentPane().add(scrollBar_1, BorderLayout.SOUTH);


		
<<<<<<< HEAD
		//Add JChoose
		
		
	}
	private void mensaje() {
		JOptionPane.showMessageDialog(null, "Opción disponible en el siguiente entregable","Trabajamos para ti...!", 1);
	}
	
	private void showMessage(String message) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		JOptionPane.showConfirmDialog(null,message,"Warning", dialogButton);
	}
	private boolean saveFile(String content, String path) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			bw.write(content);
			
			return true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
				return true;

			} catch (final IOException ex) {
				ex.printStackTrace();
				return false;
			}
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
=======
	}	
>>>>>>> 618e86f58ee9217bd89003f34de808ff96b9ecf0
}
