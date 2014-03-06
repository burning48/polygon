package com.exer.pro.commands;

import org.eclipse.gef.commands.Command;

import com.exer.pro.model.PointModel;
import com.exer.pro.model.contentsModel;

public class CreatePoint extends Command {
	private contentsModel cmodel;
	private PointModel point;
	
	public void execute(){
		cmodel.addChild(point);
		System.out.println(point.getX()+" "+point.getY());
	}
	public void setContentsModel(Object c){
		cmodel = (contentsModel)c;
	}
	public void setPointModel(Object p){
		point = (PointModel)p;
	}
}
