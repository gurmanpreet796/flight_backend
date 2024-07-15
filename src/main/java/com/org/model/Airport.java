package com.org.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Airport
/**
 * Class Airport
 */
{
	@Id
	private String airportCode;
	private String airportLocation;
	private String airportName;



	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '}';
	}
}
