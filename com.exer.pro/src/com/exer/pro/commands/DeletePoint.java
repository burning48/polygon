package com.exer.pro.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.AbstractConnectionModel;
import com.exer.pro.model.PointModel;
import com.exer.pro.model.contentsModel;

public class DeletePoint extends Command {
	private contentsModel cmodel;
	private PointModel pmodel;
	private List sourceConnection = new ArrayList();
	private List targetConnection = new ArrayList();
	
	public void execute(){
		sourceConnection.addAll(pmodel.getModelSourceConnection());
		targetConnection.addAll(pmodel.getModelTargetConnection());
		for(int i=0;i<sourceConnection.size();i++){
			AbstractConnectionModel model = (AbstractConnectionModel)sourceConnection.get(i);
			model.detachSource();
			model.detachTarget();
		}
		for(int i=0;i<targetConnection.size();i++){
			AbstractConnectionModel model = (AbstractConnectionModel)targetConnection.get(i);
			model.detachSource();
			model.detachTarget();
		}
		cmodel.removeChild(pmodel);
	}
	public void setContentsModel(Object model){
		cmodel = (contentsModel)model;
	}
	public void setPointModel(Object model){
		pmodel = (PointModel)model;
	}
	public void undo(){
		cmodel.addChild(pmodel);
		for(int i=0;i<sourceConnection.size();i++){
			AbstractConnectionModel model = (AbstractConnectionModel)sourceConnection.get(i);
			model.attachSource();
			model.attachTarget();
		}
		for(int i=0;i<targetConnection.size();i++){
			AbstractConnectionModel model = (AbstractConnectionModel)targetConnection.get(i);
			model.attachSource();
			model.attachTarget();
		}
		sourceConnection.clear();
		targetConnection.clear();
	}
}
