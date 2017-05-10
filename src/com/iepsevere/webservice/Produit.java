package com.iepsevere.webservice;

import java.io.Serializable; 

public class Produit implements Serializable{
	private static final long serialVersionUID = 1L; 
	private int id;
	private String libele;
	
	public Produit(){}
	
	public Produit(int id, String libele) {
		super();
		this.id = id;
		this.libele = libele;
	}
	
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", libele=" + libele + "]";
	}
}
