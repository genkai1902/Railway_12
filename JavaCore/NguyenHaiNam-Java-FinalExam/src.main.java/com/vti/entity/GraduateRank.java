package com.vti.entity;

public enum GraduateRank {
//	EXCELLENT, GOOD, FAIR, POOR;
 	EXCELLENT ("excellent"), GOOD ("good"), FAIR ("fair"), POOR ("poor");
 	String value;
	
 	GraduateRank(String value) {
 		this.value = value;
 	}
 	
 	public static GraduateRank fromValue(String value) throws Exception {
 			for (GraduateRank item : values()) {
 				if (item.value.equalsIgnoreCase(value)) {
 					return item;
 				}
 			}
 			throw new Exception("Invalid Graduate Rank!");
 	}
} 	