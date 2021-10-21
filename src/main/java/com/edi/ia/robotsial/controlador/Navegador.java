package com.edi.ia.robotsial.controlador;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.edi.ia.robotsial.modelo.ParametrosConfiguracionVO;



public class Navegador {
	public ChromeDriver configurarNavegador(ParametrosConfiguracionVO parametrosConfiguracionVO) {
		System.setProperty(parametrosConfiguracionVO.webDriver, parametrosConfiguracionVO.pathWebDriver);
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		ChromeOptions options = new ChromeOptions();
		
		//contentSettings.put("geolocation.enabled", true);
		//contentSettings.put("profile.managed_default_content_settings.geolocation",true);
	    //profile.put("managed_default_content_settings", contentSettings);
	    //prefs.put("profile", profile);
		
		//prefs.put("googlegeolocationaccess.enabled", true);
		//prefs.put("geolocation", true);
		prefs.put("profile.managed_default_content_settings.geolocation",1);
		//options.addArguments("--no-sandbox", "--disable-gpu-dev-shm-usage", "--window-size=1920,1200", "--ignore-certificate-errors");
		options.addArguments("--no-sandbox", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
		options.setExperimentalOption("prefs", prefs);
		//options.setHeadless(true);
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
}

