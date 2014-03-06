package com.exer.pro.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.exer.pro.commands.CreatePoint;
import com.exer.pro.commands.MovePoint;
import com.exer.pro.model.PointModel;



public class XYLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// TODO Auto-generated method stub
		CreatePoint command = new CreatePoint();
		Rectangle loc = (Rectangle)getConstraintFor(request);
		System.out.println(loc);
		PointModel point = (PointModel)request.getNewObject();
		point.setLocation(loc);
		command.setContentsModel(getHost().getModel());
		command.setPointModel(point);
		return command;
	}

	protected Command createChangeConstraintCommand(EditPart child,Object constraint){
		
		MovePoint command = new MovePoint();
		command.setModel(child.getModel());
		command.setLoc((Rectangle)constraint);
		return command;
	}
}
