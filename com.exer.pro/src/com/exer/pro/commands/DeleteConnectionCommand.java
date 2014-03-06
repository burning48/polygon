package com.exer.pro.commands;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.AbstractConnectionModel;

public class DeleteConnectionCommand extends Command {
	private AbstractConnectionModel model;
	public void execute(){
		model.detachSource();
		model.detachTarget();
	}
	public void setConnectionModel(Object model){
		this.model = (AbstractConnectionModel)model;
	}
	public void undo(){
		model.attachSource();
		model.attachTarget();
	}

}
