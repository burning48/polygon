package com.exer.pro.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;





public class PointModel extends AbstractModel{
	public static final String LOCATION = "_location";
	public static final String LOCATION_Y = "_y";
	public static final String LOCATION_X = "_x";
	public static final String SOURCE_CONNECTION = "_source_connection";
	public static final String TARGET_CONNECTION = "_target_connection";
	public static final int RADIUS = 5;
	private int x;
	private int y;
	private List sourceConnection = new ArrayList();
	private List targetConnection = new ArrayList();
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		firePropertyChange(LOCATION_X,null,this.x);
		System.out.println("X");
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		firePropertyChange(LOCATION_Y,null,this.y);
		System.out.println("Y");
	}
	public void setLocation(Rectangle rect){
		this.x = rect.getCenter().x;
		this.y = rect.getCenter().y;
		//System.out.println(x);
		firePropertyChange(LOCATION,null,getLocation());
		//firePropertyChange(LOCATION_Y,null,y);
	}
	/*public void setLocation(int x,int y){
		this.x = x;
		this.y = y;
		//System.out.println(x);
		//firePropertyChange(LOCATION,null,rect);
		//firePropertyChange(LOCATION_Y,null,y);
	}*/
	public Rectangle getLocation(){
		return new Rectangle(x,y,0,0);
	}
	
	public void addSourceConnection(Object conn){
		sourceConnection.add(conn);
		firePropertyChange(SOURCE_CONNECTION,null,null);
	}
	public void addTargetConnection(Object conn){
		targetConnection.add(conn);
		firePropertyChange(TARGET_CONNECTION,null,null);
	}
	public List getModelSourceConnection(){
		return sourceConnection;
	}
	public List getModelTargetConnection(){
		return targetConnection;
	}
	public void removeSourceConnection(Object conn){
		sourceConnection.remove(conn);
		firePropertyChange(SOURCE_CONNECTION,null,null);
	}
	public void removeTargetConnection(Object conn){
		targetConnection.remove(conn);
		firePropertyChange(TARGET_CONNECTION,null,null);
	}
	
	public IPropertyDescriptor[] getPropertyDescriptors(){
		IPropertyDescriptor[] descriptors = new IPropertyDescriptor[]{
				new TextPropertyDescriptor(LOCATION_X,"X"),new TextPropertyDescriptor(LOCATION_Y,"Y")};
		/*for (int i = 0; i < descriptors.length-1; i++) {
			((PropertyDescriptor) descriptors[i])
					.setValidator(new ICellEditorValidator() {
						public String isValid(Object value) {
							int intValue = -1;
							try {
								intValue = Integer.parseInt((String) value);
							} catch (NumberFormatException exc) {
								return "Not a number";
							}
							return null;
						}
					});
		}*/
		return descriptors;
		
	}
	public Object getProeprtyValue(Object id){
		if(id.equals(LOCATION_X)){
			System.out.println("LOCATION_X1");
			return Integer.toString(x);
		}
		else if(id.equals(LOCATION_Y)){
			return Integer.toString(y);
		}
		return null;
	}
	public boolean isPropertySet(Object id){
		if(id.equals(LOCATION_X)||id.equals(LOCATION_Y))
			return true;
		else
			return false;
	}
	public void setPropertyValue(Object id,Object value){
		if(id.equals(LOCATION_X)){
			System.out.println("LOCATION_X2");
			setLocation(new Rectangle((Integer)value,y,0,0));
		}
		else if(id.equals(LOCATION_Y)){
			System.out.println("LOCATION_Y2");
			setLocation(new Rectangle(x,(Integer)value,0,0));
		}
	}
}
