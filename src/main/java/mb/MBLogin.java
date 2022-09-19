package mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.User;
import dao.UserDAO;

@ManagedBean(name = "mbLogin")
public class MBLogin {

	private User user;

	public String submit() {

		UserDAO userDAO = new UserDAO();

		if (userDAO.isAuthenticated(user.getEmail(), user.getPassword())) {
			return "/home.xhtml";
		}
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Login Failed", 
						"Please check email or password"));
		return null;

	}

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
