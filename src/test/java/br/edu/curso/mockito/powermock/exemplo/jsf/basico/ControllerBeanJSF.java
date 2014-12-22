package br.edu.curso.mockito.powermock.exemplo.jsf.basico;

import javax.faces.application.Application;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class ControllerBeanJSF {
	
	private static final String input = UIInput.COMPONENT_TYPE;
	
	public String get() {
		Application app = getApplication();
		UIInput component = getComponent( app );
		return component.getValue().toString();
	}
	
	private UIInput getComponent(Application app) {
		return(UIInput) app.createComponent(input);
	}
	
	private Application getApplication() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication();
	}

}