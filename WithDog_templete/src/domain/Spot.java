package domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="spot")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Spot {
	
	private int spotId;
	private String spotName;
	private String spotLocation;
	private String thumbnail;
	private String spotInfo;
	private List<String> spotImageList;
	private String spotType;
	private String registerId;
	private List<Review> reviewList;
	
	public int getSpotId() {
		return spotId;
	}
	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getSpotLocation() {
		return spotLocation;
	}
	public void setSpotLocation(String spotLocation) {
		this.spotLocation = spotLocation;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getSpotInfo() {
		return spotInfo;
	}
	public void setSpotInfo(String spotInfo) {
		this.spotInfo = spotInfo;
	}
	public List<String> getSpotImageList() {
		return spotImageList;
	}
	public void setSpotImageList(List<String> spotImageList) {
		this.spotImageList = spotImageList;
	}
	public String getSpotType() {
		return spotType;
	}
	public void setSpotType(String spotType) {
		this.spotType = spotType;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

}
