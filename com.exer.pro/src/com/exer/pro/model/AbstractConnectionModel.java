package com.exer.pro.model;

public class AbstractConnectionModel {
	private PointModel source,target;
	public void attachSource(){
		if(!source.getModelSourceConnection().contains(this))
			source.addSourceConnection(this);
	}
	public void attachTarget(){
		if(!target.getModelTargetConnection().contains(this))
			target.addTargetConnection(this);
	}
	public void detachTarget(){
		target.removeTargetConnection(this);
	}
	public void detachSource(){
		source.removeSourceConnection(this);
	}
	public PointModel getSource(){
		return source;
	}
	public void setSource(PointModel model){
		source = model;
	}
	public PointModel getTarget(){
		return target;
	}
	public void setTarget(PointModel model){
		target = model;
	}
}
