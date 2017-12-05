package domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="spots")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Spots {
	
	@XmlElement(name="spot")
	private List<Spot> spotList;

	public List<Spot> getSpotList() {
		return spotList;
	}

	public void setSpotList(List<Spot> spotList) {
		this.spotList = spotList;
	}
}
