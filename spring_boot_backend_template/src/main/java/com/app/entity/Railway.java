package com.app.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "railway")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Railway {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "category")
	private Category category;
	
	@Column(length = 20, name = "startTime")
	private LocalTime startTime;
	
	@Column(length = 20, name = "endTime")
	private LocalTime endTime;
	
	@Column(length = 20, name = "source")
	private String source;
	
	@Column(length = 20, name = "destination")
	private String destination;
	
	@Column(length = 20, name = "stationCode")
	private String stationCode;
	
	@Column(length = 20, name = "distance")
	private String distance;
	
	@Column(length = 20, name = "frequency")
	private String frequency;

    
    //insert in this format
//    {
//    	  "id": 110,
//    	  "name": "uuu",
//    	  "category": "Express",
//    	  "startTime": "04:00",
//    	  "endTime": "09:00",
//    	  "source": "uuu",
//    	  "destination": "hhhh",
//    	  "stationCode": "98",
//    	  "distance": 345,
//    	  "frequency": 3
//    	}

}
