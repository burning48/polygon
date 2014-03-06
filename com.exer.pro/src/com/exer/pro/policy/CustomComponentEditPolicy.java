package com.exer.pro.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.exer.pro.commands.DeletePoint;

public class CustomComponentEditPolicy extends ComponentEditPolicy {
	protected Command createDeleteCommand(GroupRequest deleteRequest){
		DeletePoint deleteCommand = new DeletePoint();
		deleteCommand.setContentsModel(getHost().getParent().getModel());
		deleteCommand.setPointModel(getHost().getModel());
		return deleteCommand;
	}
}
