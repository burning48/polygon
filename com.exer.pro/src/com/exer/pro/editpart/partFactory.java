package com.exer.pro.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;





import com.exer.pro.model.LineConnectionModel;
import com.exer.pro.model.PointModel;
import com.exer.pro.model.contentsModel;

public class partFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		// TODO Auto-generated method stub
		
		//��ȡģ�͵ı༭����
		EditPart part = getPartForElement(model);
		//�ڱ༭�����ϴ洢ģ��
		part.setModel(model);
		return part;
	}
	private EditPart getPartForElement(Object modelElement){
		if(modelElement instanceof contentsModel)
			return new contentsEditPart();
		else if(modelElement instanceof PointModel)
			return new PointEditPart();
		else if(modelElement instanceof LineConnectionModel)
			return new LineConnectionEditPart();
		throw new RuntimeException("Can't create part for model element:"+
			((modelElement != null)?modelElement.getClass().getName():"null"));
	}


}
