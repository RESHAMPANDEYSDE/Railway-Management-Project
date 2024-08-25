package com.app.dto;

import java.time.LocalTime;

import com.app.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString  
public class RailwayDTO {

	private String name;
	private Category category;
	private LocalTime startTime;
	private LocalTime endTime;
	private String frequency;
}
