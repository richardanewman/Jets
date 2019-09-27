package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets;

	
	
	public AirField() {
		jets = new ArrayList<Jet>();
	}



	public List<Jet> getJets() {
		return jets;
	}



	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jets == null) ? 0 : jets.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		if (jets == null) {
			if (other.jets != null)
				return false;
		} else if (!jets.equals(other.jets))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirField [jets=");
		builder.append(jets);
		builder.append(", getJets()=");
		builder.append(getJets());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append("]");
		return builder.toString();
	}

	

	
	
	

}
