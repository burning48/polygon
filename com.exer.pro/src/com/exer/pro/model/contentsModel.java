package com.exer.pro.model;


import java.util.ArrayList;
import java.util.List;



public class contentsModel extends AbstractModel{
	public static final String CHILDREN = "_children";
	private List children = new ArrayList();
	public void addChild(Object child){
		children.add(child);
		firePropertyChange(CHILDREN,null,null);
	}
	public List getChildren(){
		return children;
	}
	
	public void removeChild(Object child){
		children.remove(child);
		firePropertyChange(CHILDREN,null,null);
	}
}
