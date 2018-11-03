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
	
	public static String guardar(JFrame frmEditor, JTextArea textArea) {
		String aux="";   
		  String texto = "";
		  try
		  {
		   /**llamamos el metodo que permite cargar la ventana*/
		   JFileChooser file=new JFileChooser();
		   file.showOpenDialog(frmEditor);
		   /**abrimos el archivo seleccionado*/
		   File abre=file.getSelectedFile();
		 
		   /**recorremos el archivo, lo leemos para plasmarlo
		   *en el area de texto*/
		   if(abre!=null)
		   {     
		      FileReader archivos=new FileReader(abre);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return texto;
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
