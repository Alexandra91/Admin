package com.steps.Product.ImageManager;

import com.pages.Product.ImageManager.PictureUploadPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class PictureUploadSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	public PictureUploadPage pictureUploadPage;
	
	@Step
	public void loadDocument(String documentPath) {
		pictureUploadPage.loadDocument(documentPath);
	}
	
}
