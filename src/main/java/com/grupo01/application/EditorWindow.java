package com.grupo01.application;

import java.awt.EventQueue;

import javax.swing.*;

import com.grupo01.service.Editor_funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;

public class EditorWindow {

	private JFrame frmEditor;
	private JTextArea textArea;
	private JButton btnGuardar;
	private JMenu mnNewMenu;
	private JMenuItem mntmGuardarComo;
	private String localPath;
	//private final Action action = new SwingAction();
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
		localPath = "";
		 
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
		
		mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/home.gif")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/new.png")));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Editor_funciones.nuevo(textArea);			}
		});
		mnNewMenu.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/open.png")));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mensaje();	
				textArea.setText(Editor_funciones.guardar(frmEditor,textArea));
			}
		});
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/save.png")));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Editor_funciones.guardar(frmEditor,textArea);				
				if(localPath.isEmpty()) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Guarda tu trabajo"); 
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int userSelection = fileChooser.showSaveDialog(frmEditor);
					 
					if (userSelection == JFileChooser.CANCEL_OPTION) return;
				    
					File fileToSave = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				    localPath = fileToSave.getAbsolutePath();
				    saveFile(textArea.getText(), localPath);					    
					
				}else {
					saveFile(textArea.getText(),localPath);
				}
			}
		});
		mnNewMenu.add(mntmGuardar);
		
		mntmGuardarComo = new JMenuItem("Guardar como ...");
		mntmGuardarComo.setIcon(new ImageIcon(EditorWindow.class.getResource("/images/saveas.gif")));
		mntmGuardarComo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Guarda tu trabajo"); 
				int userSelection = fileChooser.showSaveDialog(frmEditor);
				 
				if (userSelection == JFileChooser.CANCEL_OPTION) return;
			    
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
		//btnGuardar.setAction(action);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor_funciones.guardar(frmEditor,textArea);
			}
		});


		
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
}
