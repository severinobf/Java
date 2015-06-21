/**
 * 
 */
package br.com.navita.workflow.mdm.gesture;

import java.sql.Timestamp;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.MaritalStatus;
import br.com.navita.workflow.mdm.model.Gesture;
import br.com.navita.workflow.mdm.model.Gender;

/**
 * Transfer Object para persistência de um Gesto na base noSQL.
 * Persistirá gestos apenas com dados estatísticos, sem citar identidades de pessoas ou empresas.
 * 
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class GestureTO extends BaseTO implements Gesture {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -7666548630629779335L;

	private Gender gender = null;
	
	private MaritalStatus maritalStatus = null;
	
	private Integer age = null;
	
	private Timestamp eventHour = null;
	
	private Long productOrServiceID = null;
	
	private String productOrServicedescription = null;
	
	private String gestureDescription = null;
	
	private String role = null;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getEventHour() {
		return eventHour;
	}

	public void setEventHour(Timestamp eventHour) {
		this.eventHour = eventHour;
	}

	public String getProductOrServicedescription() {
		return productOrServicedescription;
	}

	public void setProductOrServicedescription(String productOrServicedescription) {
		this.productOrServicedescription = productOrServicedescription;
	}

	public String getGestureDescription() {
		return gestureDescription;
	}

	public void setGestureDescription(String gestureDescription) {
		this.gestureDescription = gestureDescription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getProductOrServiceID() {
		return productOrServiceID;
	}

	public void setProductOrServiceID(Long productOrServiceID) {
		this.productOrServiceID = productOrServiceID;
	}

}
