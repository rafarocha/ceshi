package br.edu.curso.mockito.powermock.exemplo.jsf.basico;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import javax.faces.application.Application;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FacesContext.class)
public class ControllerBeanJSFTest {
	
	@Mock private FacesContext facesContextMock;
	@Mock private Application applicationMock;
	
	@InjectMocks private ControllerBeanJSF simpleBean;
	
	@Test public void test() throws Exception {
		PowerMockito.mockStatic( FacesContext.class );
		
		when( FacesContext.getCurrentInstance() ).thenReturn( this.facesContextMock );
		when( this.facesContextMock.getApplication() ).thenReturn( this.applicationMock );
		
		final String expected = "hello";
		when( this.applicationMock.createComponent(UIInput.COMPONENT_TYPE) )
			.then( new Answer<UIInput>() {
				public UIInput answer(InvocationOnMock invocation) throws Throwable {
					UIInput input = new HtmlInputText();
					input.setValue( expected );
					return input;
				}
			});
		
		String value = simpleBean.get();

		PowerMockito.verifyStatic( times(1) );
		FacesContext.getCurrentInstance();
		
		assertEquals(expected, value);
	}

}