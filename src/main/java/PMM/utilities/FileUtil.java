package PMM.utilities;

import PMM.baseClass.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;


public class FileUtil extends TestBase {

	// This method is to create a 'downloads' folder
	public void download(String path) throws IOException {
		boolean isMkDir = false;
		File dir = new File(path);
		// Clean the directory before each download
		if (dir.exists()) {
			FileUtils.cleanDirectory(new File(path));
		}
		if (!dir.exists()) {
			isMkDir = new File(path).mkdirs();
			if (!isMkDir) {
				System.out.println("Could not create the downloads folder - " + path);
			}
		}
	}

	// This method is to check if the file names are present in the 'downloads'
	// folder
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	/**
     * This method will set any parameter string to the system's clipboard.
     */
	public void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public void uploadFileUsingSendKeys(String filepath, String xpath) throws InterruptedException {
		getWebDriver().findElement(By.xpath(xpath)).sendKeys(filepath);
	}

}
