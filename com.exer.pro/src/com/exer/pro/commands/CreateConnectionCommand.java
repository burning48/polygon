package com.exer.pro.commands;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.AbstractConnectionModel;
import com.exer.pro.model.PointModel;

public class CreateConnectionCommand extends Command {
	private PointModel source,target;
	private AbstractConnectionModel connection;
	public boolean canExecute(){
		if(source == null || target == null)
			return false;
		if(source.equals(target))
			return false;
		return true;
	}
	public void execute(){
		connection.attachSource();
		connection.attachTarget();
	}
	public void setConnection(Object model){
		connection = (AbstractConnectionModel)model;
	}
	public void setSource(Object model){
		source = (PointModel)model;
		connection.setSource(source);
	}
	public void setTarget(Object model){
		target = (PointModel)model;
		connection.setTarget(target);
	}
	public void undo(){
		connection.detachSource();
		connection.detachTarget();
	}

}
