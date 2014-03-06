package com.exer.pro.editpart;



import java.beans.PropertyChangeEvent;












import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.*;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;





















import com.exer.pro.model.PointModel;
import com.exer.pro.policy.CustomComponentEditPolicy;
import com.exer.pro.policy.CustomNodeEditPolicy;

public class PointEditPart extends EditPartWithListener implements NodeEditPart{
	
	/*public PointEditPart(PointModel p){
		setModel(p);
		p.addPartListener(this);
	}*/
	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		PointModel model = (PointModel)getModel();
		//System.out.println(model.getX());
		IFigure e = new Ellipse();
		e.setBounds(new Rectangle(model.getX()-PointModel.RADIUS,model.getY()-PointModel.RADIUS,
				PointModel.RADIUS*2,PointModel.RADIUS*2));
		e.setBackgroundColor(ColorConstants.black);
		return e;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		installEditPolicy(EditPolicy.COMPONENT_ROLE,new CustomComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,new CustomNodeEditPolicy());
	}
	
	public void propertyChange(PropertyChangeEvent event){
		System.out.println(event.getPropertyName());
		if(event.getPropertyName().equals(PointModel.LOCATION)){
			//refreshVisuals();
			Point p = ((Rectangle)(event.getNewValue())).getCenter();
			getFigure().setLocation(p);
			System.out.println("------------");
		}
		else if(event.getPropertyName().equals(PointModel.LOCATION_X)){
			System.out.println("LOCATION_X3");
			PointModel model = (PointModel)getFigure();
			//model.setX(Integer.parseInt(event.getNewValue().toString()));
			int x = Integer.parseInt(event.getNewValue().toString());
			int y = model.getY();
			model.setLocation(new Rectangle(x,y,0,0));
		}
		else if(event.getPropertyName().equals(PointModel.LOCATION_Y)){
			System.out.println("LOCATION_Y3");
			PointModel model = (PointModel)getFigure();
			//model.setY(Integer.parseInt(event.getNewValue().toString()));
			int y = Integer.parseInt(event.getNewValue().toString());
			int x = model.getX();
			model.setLocation(new Rectangle(x,y,0,0));
		}
		else if(event.getPropertyName().equals(PointModel.SOURCE_CONNECTION))
			refreshSourceConnections();
		else if(event.getPropertyName().equals(PointModel.TARGET_CONNECTION))
			refreshTargetConnections();
			
	}
	
	protected List getModelSourceConnections(){
		return ((PointModel)getModel()).getModelSourceConnection();
	}
	protected List getModelTargetConnections(){
		return ((PointModel)getModel()).getModelTargetConnection();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}
	
	/*protected void refreshVisuals(){
		Rectangle constraint = ((PointModel)getModel()).getLocation();
		((GraphicalEditPart)getParent()).setLayoutConstraint(this,getFigure(),constraint);
	}*/

}
