package Controleur;

import java.beans.PropertyChangeEvent;

import Interface.IView;
import application.IAccumulateur;
import jdk.internal.access.JavaAWTAccess;

public class Controleur implements java.beans.PropertyChangeListener{
	
	private IView  view;
	private IAccumulateur model;
	
	public Controleur(IView view, IAccumulateur model){
		
		this.view  = view;
		this.model = model;
	}
	
	
	public void start(){
		
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	
}
