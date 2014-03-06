package com.exer.pro.commands;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.AbstractConnectionModel;
import com.exer.pro.model.PointModel;

public class ReconnectSourceConnectionCommand extends Command {
	private AbstractConnectionModel cmodel;
	private PointModel source,oldsource;
	
	/*public ReconnectSourceConnectionCommand(Object model,Object point){
		super();
		cmodel = (AbstractConnectionModel)model;
		source = (PointModel)point;
	}*/
	public void execute(){
		oldsource = cmodel.getSource();
		cmodel.detachSource();
		cmodel.setSource(source);
		cmodel.attachSource();
		
	}
	public void setConnectionModel(Object model){
		cmodel = (AbstractConnectionModel)model;
	}
	
	public void setSourceModel(Object model){
		source = (PointModel)model;
		//cmodel.setSource(source);
	}
	public void undo(){
		source = cmodel.getSource();
		cmodel.detachSource();
		cmodel.setSource(oldsource);
		cmodel.attachSource();
	}

}
