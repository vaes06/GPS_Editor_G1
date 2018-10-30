package com.grupo01.service;

import java.io.*;
import javax.swing.*;

public class Editor_funciones {
	
	public static void mensaje() {
		JOptionPane.showMessageDialog(null, "Opción disponible en el siguiente entregable","Trabajamos para ti...!", 1);
	}
	
	public static void guardar(JFrame frmEditor, JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Guarda tu trabajo");
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
	
	
	
}
