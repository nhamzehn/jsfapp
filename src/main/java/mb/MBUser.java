package mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.User;

import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "mbUser")
public class MBUser {

	private User user;
	private boolean accept;

	@PostConstruct
	public void init(){
		user = new User();
	}

	public String signUp() {
		if (accept == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Terms & Conditions", "Please accept terms and conditions"));
		} else {
			System.out.println(user);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added successfully"));
		}

		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

}
