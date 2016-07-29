package com.pages.Product;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;


import net.serenitybdd.core.annotations.findby.FindBy;

public class PictureUploadPage extends AbstractPage {

	@FindBy(css="div.browse-holder .browse-button.browse-picturesText")
	private WebElement browseButton;
	
	public void loadDocument(String documentPath) {
		element(browseButton).waitUntilVisible();
		browseButton.click();
		File file = new File(documentPath);
		uploadDocument(file.getAbsolutePath());
		waitABit(2000);}
	
		private void uploadDocument(String path) {
			// copy the path
			StringSelection clipboard = new StringSelection(path + " \n");
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(clipboard, null);

			Robot dmmyRobot;
			try {
				dmmyRobot = new Robot();
				// press CTRL+C and CTRL+V and then release them
				dmmyRobot.keyPress(KeyEvent.VK_CONTROL);
				dmmyRobot.keyPress(KeyEvent.VK_V);
				
				dmmyRobot.keyRelease(KeyEvent.VK_CONTROL);
				dmmyRobot.keyRelease(KeyEvent.VK_V);
				// hit enter
				waitABit(1000);
				dmmyRobot.keyPress(KeyEvent.VK_ENTER);
				dmmyRobot.keyRelease(KeyEvent.VK_ENTER);

			} catch (AWTException e) {
				e.printStackTrace();
			}

		}
}
