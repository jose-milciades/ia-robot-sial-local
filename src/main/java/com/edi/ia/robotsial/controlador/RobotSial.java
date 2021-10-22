package com.edi.ia.robotsial.controlador;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.WebElement;

import com.edi.ia.robotsial.modelo.ParametrosConfiguracionVO;
import com.edi.ia.robotsial.modelo.ReciboVO;
import com.edi.ia.robotsial.util.Utilidad;
import com.edi.ia.robotsial.util.VariablesGlobales;

public class RobotSial {

	By userNameLocator = By.name("correo");
	By passwordLocator = By.name("contrasena");
	By sesionBtnLocator = By.cssSelector("button[class='btn btn-lg btn-primary']");
	By menuItemReembolso = By.xpath("/html/body/div[1]/div[2]/a[5]");
	By menuItemComprobanteReembolso = By.xpath("/html/body/div[1]/div[2]/div[5]/div/div[1]");
	By BtnMas = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/button[1]");
	By dropdownListTipoReembolso = By.name("Tipo_de_reembolso");
	By dropdownListTipoComprobante = By.name("Tipo_de_comprobante");
	By cargarArchivo = By
			.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[2]/section/div/div[2]/div/div/div[1]/div[8]/input");
	By fechaDocumento = By.name("Fecha_documento");
	By subtotal = By.name("Subtotal");
	By regresar = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/button[1]");
	By filtrar = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/span/button");
	By dropdownListFiltro = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/span/div/div/div/select[2]");
	By datoFiltro = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/span/div/div/div/div[4]/input");
	By agregarFiltro = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/span/div/div/div/div[4]/span");
	By filtroOk = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/span/div/div/div/button");

	private ChromeDriver driver;
	private Utilidad utilidad = new Utilidad();
	DevTools devTools;
	ParametrosConfiguracionVO parametrosConfiguracionVO;

	public RobotSial(ChromeDriver driver, ParametrosConfiguracionVO parametrosConfiguracionVO) {
		this.driver = driver;
		this.parametrosConfiguracionVO = parametrosConfiguracionVO;

	}

	public void cargarPagina(boolean iniciarSesionDevTools) {
		driver.get(parametrosConfiguracionVO.urlSial);
		//driver.setPermission("profile.managed_default_content_settings.geolocation", "1");
		
		if(iniciarSesionDevTools) {
			this.iniciarSesionDevTools();
		}

	}

	public void iniciarSesionDevTools() {
		devTools = driver.getDevTools();
		devTools.createSession();
		
	}

	public void autenticarse() throws Exception {

		Thread.sleep(1000);
		try {
			driver.findElement(userNameLocator).sendKeys(parametrosConfiguracionVO.login);
			Thread.sleep(1000);
			driver.findElement(passwordLocator).sendKeys(parametrosConfiguracionVO.password);
			Thread.sleep(1000);
			driver.findElement(sesionBtnLocator).click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new Exception(VariablesGlobales.MENSAJE_ERROR_05);

		}

	}

	public void opcionCargarRecibo() throws IllegalArgumentException, InterruptedException {
		Thread.sleep(1000);
		try {
			driver.findElement(menuItemReembolso).click();
			Thread.sleep(1000);
			driver.findElement(menuItemComprobanteReembolso).click();

			this.adicionarRecibo(1);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public void adicionarRecibo(int intentosFallidos) throws IllegalArgumentException, InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(BtnMas).click();
		} catch (NoSuchElementException e) {
			if (intentosFallidos <= 5) {
				this.adicionarRecibo(intentosFallidos);
				e.printStackTrace();
				intentosFallidos++;
			}
			e.printStackTrace();
		}
	}

	public void cargarRecibo(ReciboVO reciboVO, int intentosFallidos)
			throws IllegalArgumentException, InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement dropdownList = driver.findElement(dropdownListTipoReembolso);
			List<WebElement> options = (List<WebElement>) dropdownList
					.findElements(By.tagName(VariablesGlobales.OPTION));
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().equals(VariablesGlobales.TIPO_REEMBOLSO_SANEAMIENTO)) {
					options.get(i).click();
					break;
				}
			}
			dropdownList = driver.findElement(dropdownListTipoComprobante);
			options = (List<WebElement>) dropdownList.findElements(By.tagName(VariablesGlobales.OPTION));
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().equals(VariablesGlobales.TIPO_COMPROBANTE_RECIBO)) {
					options.get(i).click();
					break;
				}
			}

			File file = new File(parametrosConfiguracionVO.pathArchivo + "/" + reciboVO.getNombreArchivo());
			String path = file.getAbsolutePath();
			driver.findElement(cargarArchivo).sendKeys(path);
			Thread.sleep(1000);
			driver.findElement(fechaDocumento).sendKeys(reciboVO.getFechaDocumento());
			Thread.sleep(1000);
			driver.findElement(subtotal).sendKeys(reciboVO.getSubtotal());

		} catch (NoSuchElementException e) {
			if (intentosFallidos <= 5) {
				this.cargarRecibo(reciboVO, intentosFallidos);
				e.printStackTrace();
				intentosFallidos++;
			}
			e.printStackTrace();
		}

	}

	public void filtrarRecibos(ReciboVO reciboVO) throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(regresar).click();
			Thread.sleep(4000);
			driver.findElement(filtrar).click();
			Thread.sleep(1000);
			WebElement dropdownList = driver.findElement(dropdownListFiltro);
			List<WebElement> options = (List<WebElement>) dropdownList
					.findElements(By.tagName(VariablesGlobales.OPTION));
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().equals(VariablesGlobales.FILTRO_FECHA_DOCUMENTO)) {
					options.get(i).click();
					break;
				}
			}
			Thread.sleep(1000);
			driver.findElement(datoFiltro).sendKeys(reciboVO.getFechaDocumento());
			Thread.sleep(1000);
			driver.findElement(agregarFiltro).click();

			dropdownList = driver.findElement(dropdownListFiltro);
			options = (List<WebElement>) dropdownList.findElements(By.tagName(VariablesGlobales.OPTION));
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().equals(VariablesGlobales.FILTRO_SUBTOTAL)) {
					options.get(i).click();
					break;
				}
			}
			Thread.sleep(1000);
			driver.findElement(datoFiltro).clear();
			Thread.sleep(1000);
			driver.findElement(datoFiltro).sendKeys("$" + reciboVO.getSubtotal());
			Thread.sleep(1000);
			driver.findElement(agregarFiltro).click();
			Thread.sleep(1000);
			driver.findElement(filtroOk).click();

		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void click(By componente, int intentosFallidos, int tiempoEspera) throws Exception {
		try {
			Thread.sleep(tiempoEspera);
			driver.findElement(componente).click();
		} catch (NoSuchElementException e) {
			if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
				intentosFallidos++;
				this.click(componente, intentosFallidos, tiempoEspera);

			} else {
				throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString());
			}

		}
	}
	
	public boolean elementoPresente(By componente, int intentosFallidos, int tiempoEspera)  {
		boolean respuesta = false;
		try {
			Thread.sleep(tiempoEspera);
			driver.findElement(componente).click();
			respuesta = true;
		} catch (NoSuchElementException e) {
			respuesta = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	public void click(By componente, String dato, int intentosFallidos, int tiempoEspera) throws Exception {
		if (!utilidad.isEmpty(dato)) {
			try {
				Thread.sleep(tiempoEspera);
				driver.findElement(componente).click();
			} catch (NoSuchElementException e) {
				if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
					intentosFallidos++;
					this.click(componente, intentosFallidos, tiempoEspera);

				} else {
					throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString());
				}
			}
		}
	}

	// Metodo que busca primero el componenteA y si no lo encuentra busca el
	// compoenteB
	public boolean click(By componenteA, By componenteB, int intentosFallidos, int tiempoEspera) throws Exception {
		boolean adicionar = false;
		try {
			Thread.sleep(tiempoEspera);
			driver.findElement(componenteA).click();
			adicionar = false;
		} catch (NoSuchElementException e) {
			if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
				intentosFallidos++;
				try {
					driver.findElement(componenteB).click();
					adicionar = true;
				} catch (NoSuchElementException ex) {
					this.click(componenteA, componenteB, intentosFallidos, tiempoEspera);
				}

			} else {
				throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componenteA.toString());
			}

		}
		return adicionar;
	}

	public void sendKeys(By componente, String dato, int intentosFallidos, int tiempoEspera) throws Exception {
		if (!utilidad.isEmpty(dato)) {
			try {
				Thread.sleep(tiempoEspera);
				driver.findElement(componente).clear();
				driver.findElement(componente).sendKeys(dato);
				

			} catch (NoSuchElementException e) {
				if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
					intentosFallidos++;
					this.sendKeys(componente, dato, intentosFallidos, tiempoEspera);

				} else {
					throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString());
				}
			}
		}
	}

	public void selectDropdownList(By componente, String dato, int intentosFallidos, int tiempoEspera)
			throws Exception {
		if (!utilidad.isEmpty(dato)) {
			boolean existeOpcion = false;
			try {
				Thread.sleep(tiempoEspera);
				WebElement dropdownList = driver.findElement(componente);
				List<WebElement> options = (List<WebElement>) dropdownList
						.findElements(By.tagName(VariablesGlobales.OPTION));
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i).getText().equals(dato)) {
						options.get(i).click();
						existeOpcion = true;
						break;
					}
				}
				if (!existeOpcion) {
					throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString() + " " + dato);
				}
			} catch (NoSuchElementException e) {
				if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
					intentosFallidos++;
					this.selectDropdownList(componente, dato, intentosFallidos, tiempoEspera);

				} else {
					throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString());
				}
			}
		}
	}

	public void selectFirstDropdownList(By componente, int intentosFallidos, int tiempoEspera) throws Exception {

		try {
			Thread.sleep(tiempoEspera);

			List<WebElement> allElements = driver.findElements(componente);
			if (allElements.size() > 0) {
				allElements.get(0).click();
			}

		} catch (NoSuchElementException e) {
			if (intentosFallidos <= VariablesGlobales.INTENTOS_FALLIDOS) {
				intentosFallidos++;
				this.selectFirstDropdownList(componente, intentosFallidos, tiempoEspera);

			} else {
				throw new Exception(VariablesGlobales.MENSAJE_ERROR_03 + componente.toString());
			}
		}

	}

	public void setGeolocalización(BigDecimal latitud, BigDecimal longitud, BigDecimal precision)   {

		Map<String, Object> coordinates = Map.of("latitude", latitud, "longitude", longitud, "accuracy", precision);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
	}

	public void switchToAlert(int tiempoEspera) throws Exception {
		
		try {
			Thread.sleep(tiempoEspera);

			driver.switchTo().alert();
			Alert alert = driver.switchTo().alert();
			String mensaje  = alert.getText();
//			alert.accept();
			alert.dismiss();
			if(!mensaje.contains("el dictamen con estatus final")) {
				throw new Exception(mensaje);
			}
			//System.out.println("Mensaje Popup: "+mensaje);
		} catch (InterruptedException e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public void salir() {
		if (driver != null) {
			driver.quit();
		}

	}
	public void salirDevTools() {
		if (devTools != null) {
			devTools.close();;
		}

	}
}
 
