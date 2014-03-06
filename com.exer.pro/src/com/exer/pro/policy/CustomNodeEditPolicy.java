package com.exer.pro.policy;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.exer.pro.commands.CreateConnectionCommand;

import com.exer.pro.commands.ReconnectSourceConnectionCommand;
import com.exer.pro.commands.ReconnectTargetConnectionCommand;

public class CustomNodeEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCompleteCommand(
			CreateConnectionRequest request) {
		// TODO Auto-generated method stub
		CreateConnectionCommand command = (CreateConnectionCommand)request.getStartCommand();
		command.setTarget(getHost().getModel());
		return command;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		// TODO Auto-generated method stub
		CreateConnectionCommand command = new CreateConnectionCommand();
		command.setConnection(request.getNewObject());
		command.setSource(getHost().getModel());
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		ReconnectTargetConnectionCommand command = new ReconnectTargetConnectionCommand();
		command.setConnectionModel(request.getConnectionEditPart().getModel());
		command.setTargetModel(getHost().getModel());
		return command;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		ReconnectSourceConnectionCommand command = new ReconnectSourceConnectionCommand();
		command.setConnectionModel(request.getConnectionEditPart().getModel());
		command.setSourceModel(getHost().getModel());
		return command;
	}

}
