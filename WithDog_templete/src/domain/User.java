package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class User {
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", contact=" + contact + ", favoriteLocation="
				+ favoriteLocation + ", petInfo=" + petInfo + ", petImage=" + petImage + "]";
	}
	private String userId;
	private String password;
	private String contact;
	private String favoriteLocation;
	private String petInfo;
	private String petImage;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getFavoriteLocation() {
		return favoriteLocation;
	}
	public void setFavoriteLocation(String favoriteLocation) {
		this.favoriteLocation = favoriteLocation;
	}
	public String getPetInfo() {
		return petInfo;
	}
	public void setPetInfo(String petInfo) {
		this.petInfo = petInfo;
	}
	public String getPetImage() {
		return petImage;
	}
	public void setPetImage(String petImage) {
		this.petImage = petImage;
	}

}
