package Controleur;


import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Interface.IView;


public class ActionControleur implements ActionListener{
	
	private IView vue;
	private Button bouton;
	private Button bouton2;
	

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("bouton cliqué");
	}
	
}
