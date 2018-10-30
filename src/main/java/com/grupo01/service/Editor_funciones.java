package com.grupo01.service;

import java.awt.Color;
import java.io.*;
import javax.swing.*;

public class Editor_funciones {
	
	public static void mensaje() {
		JOptionPane.showMessageDialog(null, "Opción disponible en el siguiente entregable","Trabajamos para ti...!", 1);
	}
	
	public static void nuevo(JTextArea textArea) {
		int contenido = 0;
		contenido = textArea.getText().charAt(contenido);
		if(contenido == 0) {
			textArea.setText("");
			textArea.setBackground(Color.white);
		}else {
			int opcion_guardar = JOptionPane.showConfirmDialog(textArea, "¿Desea guardar los cambios?","Confirmación",1,2);
			if(opcion_guardar == 0) {
				guardar(null, textArea);
				textArea.setText("");
				textArea.setBackground(Color.white);
			}else if (opcion_guardar == 1) {
				textArea.setText("");
				textArea.setBackground(Color.white);
			}
		}
		
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
