package com.exer.pro.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.exer.pro.model.PointModel;

public class MovePoint extends Command {
	private PointModel p;
	private Rectangle rect;
	private Rectangle oldrect;
	public void execute(){
		p.setLocation(rect);
	}
	public void setLoc(Rectangle rect){
		this.rect = rect;
	}
	public void setModel(Object model){
		p = (PointModel)model;
		oldrect = p.getLocation();
	}
	public void undo(){
		p.setLocation(oldrect);
	}
}
