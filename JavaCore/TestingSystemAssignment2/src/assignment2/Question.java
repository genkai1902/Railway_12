package assignment2;

import java.time.LocalDateTime;

public class Question {
	int id;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	LocalDateTime createDate;
	Answer[] answers;
}
