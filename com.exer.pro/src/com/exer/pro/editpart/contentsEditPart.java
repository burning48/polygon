package com.exer.pro.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;








import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;




import com.exer.pro.model.contentsModel;
import com.exer.pro.policy.XYLayoutPolicy;


public class contentsEditPart extends EditPartWithListener {

	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		Layer figure = new Layer();
		figure.setLayoutManager(new XYLayout());
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		installEditPolicy(EditPolicy.LAYOUT_ROLE,new XYLayoutPolicy());
	}

	protected List getModelChildren(){
		return ((contentsModel)getModel()).getChildren();
	}
	public void propertyChange(PropertyChangeEvent event){
		if(event.getPropertyName().equals(contentsModel.CHILDREN)){
			refreshChildren();
		}
	}
}
