package com.exer.pro;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		final String properties = "org.eclipse.ui.views.PropertySheet";
		final String editorArea = layout.getEditorArea();
		IFolderLayout leftTopFolder = layout.createFolder("LeftTop", IPageLayout.LEFT, 0.4f, editorArea);
		leftTopFolder.addView(properties);
		layout.setEditorAreaVisible(true);
	}
}
