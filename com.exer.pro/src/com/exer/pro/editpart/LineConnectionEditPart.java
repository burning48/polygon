package com.exer.pro.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import com.exer.pro.policy.CustomConnectionEditPolicy;
import com.exer.pro.policy.CustomConnectionEndPointEditPolicy;

public class LineConnectionEditPart extends AbstractConnectionEditPart {

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,new CustomConnectionEndPointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE,new CustomConnectionEditPolicy());
	}

}
