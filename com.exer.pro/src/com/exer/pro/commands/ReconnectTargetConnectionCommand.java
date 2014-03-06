package com.exer.pro.commands;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.AbstractConnectionModel;
import com.exer.pro.model.PointModel;

public class ReconnectTargetConnectionCommand extends Command {
	private AbstractConnectionModel cmodel;
	private PointModel target,oldtarget;
	/*public ReconnectTargetConnectionCommand(Object model,Object point){
		super();
		cmodel = (AbstractConnectionModel)model;
		target = (PointModel)point;
	}*/
	public void execute(){
		oldtarget = cmodel.getTarget();
		cmodel.detachTarget();
		cmodel.setTarget(target);
		cmodel.attachTarget();
		
	}
	public void setConnectionModel(Object model){
		cmodel = (AbstractConnectionModel)model;
	}
	public void setTargetModel(Object model){
		target = (PointModel)model;
		//cmodel.setTarget(target);
	}
	
	public void undo(){
		target = cmodel.getTarget();
		cmodel.detachTarget();
		cmodel.setTarget(oldtarget);
		cmodel.attachTarget();
	}

}
