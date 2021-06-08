package assignment2;

import java.time.LocalDateTime;
import java.util.Date;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion category;
	int duration;
	Account creator;
	LocalDateTime createDate;
	Question[] questions;
}
