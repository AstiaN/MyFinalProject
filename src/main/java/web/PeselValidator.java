package web;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("peselValidator")
public class PeselValidator implements Validator {

    @Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String pesel = (String) value;
		Pattern pattern = Pattern.compile("[0-9]{11}");
	    java.util.regex.Matcher matcher = pattern.matcher(pesel);
	    
		if (!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("PESEL: musi skladac sie z 11 cyfr");
			message.setSummary("PESEL: musi skladac sie z 11 cyfr");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
		if(sprawdz(pesel) == false) {
			FacesMessage message = new FacesMessage();
			message.setDetail("PESEL: Nieprawidlowy numer PESEL");
			message.setSummary("PESEL: Nieprawidlowy numer PESEL");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
	
	public static boolean sprawdz(String pesel){
			int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};  // zak�adamy tablic� z wagami
			//if (pesel.length() != 11) return false;
			int suma = 0;  // zak�adamy zmienn� b�d�c� sum� kontroln�
			
			for (int i = 0; i < 10; i++)  // liczymy w p�tli sum� kontroln� przemna�aj�c odpowiednie
			suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i];  // cyfry PESELU przez odpowiednie wagi
			
			int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11));  // pobieramy do zmiennej cyfraKontrolna warto�� ostatniej cyfry z PESELU
			suma %= 10;  // obliczamy cyfr� kontroln� z sumy (najpierw modulo 10 potem odejmujemy 10 i jeszcze raz modulo 10)
			suma = 10 - suma;
			suma %= 10;
			return (suma == cyfraKontrolna);  // zwracamy warto�� logiczn� por�wnania obliczonej i pobranej cyfry kontrolnej
	}
	
}