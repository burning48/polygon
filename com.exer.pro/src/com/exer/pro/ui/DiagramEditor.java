package com.exer.pro.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.*;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;






import com.exer.pro.Application;
import com.exer.pro.editpart.partFactory;
import com.exer.pro.model.LineConnectionModel;
import com.exer.pro.model.PointModel;
import com.exer.pro.model.contentsModel;


public class DiagramEditor extends GraphicalEditorWithPalette {
	
	public static final String ID = "com.exer.pro.ui.DiagramEditor";
	
	GraphicalViewer viewer;

	public DiagramEditor() {
		// TODO Auto-generated constructor stub
		setEditDomain(new DefaultEditDomain(this));
	}
	
	
	protected void configureGraphicalViewer(){
		super.configureGraphicalViewer();
		viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new partFactory());
	}
	
	protected void initializeGraphicalViewer(){
		contentsModel parent = new contentsModel();
		PointModel child1 = new PointModel();
		child1.setLocation(new Rectangle(50, 50,0,0));
		//child1.setLocation(50,50);
		parent.addChild(child1);
		PointModel child2 = new PointModel();
		child2.setLocation(new Rectangle(500, 50,0,0));
		//child2.setLocation(500,50);
		parent.addChild(child2);
		viewer.setContents(parent);
		
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		PaletteRoot root = new PaletteRoot();
		PaletteGroup toolGroup = new PaletteGroup("Tools");
		ToolEntry tool = new SelectionToolEntry();
		toolGroup.add(tool);
		root.setDefaultEntry(tool);
		tool = new MarqueeToolEntry();
		toolGroup.add(tool);
		PaletteDrawer drawer = new PaletteDrawer("Diagram");
		ImageDescriptor descriptorpoint = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,"icons/point.gif");
		CreationToolEntry creationPoint = new CreationToolEntry("point",
				"point",new SimpleFactory(PointModel.class),descriptorpoint,descriptorpoint);
		drawer.add(creationPoint);
		ImageDescriptor newConnectionDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,"icons/line.gif");
		ConnectionCreationToolEntry creationConnection = new ConnectionCreationToolEntry("line",
				"line",new SimpleFactory(LineConnectionModel.class),newConnectionDescriptor,newConnectionDescriptor);
		drawer.add(creationConnection);
		root.add(toolGroup);
		root.add(drawer);
		return root;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}



}
