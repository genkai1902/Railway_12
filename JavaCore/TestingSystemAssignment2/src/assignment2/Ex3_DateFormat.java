package assignment2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Ex3_DateFormat {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// create typeQuestion
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.id = 1;
		typeQuestion1.name = typeQuestion1.name.ESSAY;

		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.id = 2;
		typeQuestion2.name = typeQuestion2.name.MULTIPLECHOICE;

		// create CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.id = 1;
		categoryQuestion1.name = "Java";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.id = 2;
		categoryQuestion2.name = "C#";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.id = 3;
		categoryQuestion3.name = "PHP";

		CategoryQuestion categoryQuestion4 = new CategoryQuestion();
		categoryQuestion4.id = 4;
		categoryQuestion4.name = "Python";

		// create Questions & Answers
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "Question 1?";
		question1.category = categoryQuestion1;
		question1.type = typeQuestion1;
		question1.createDate = LocalDateTime.now();

		Question question2 = new Question();
		question2.id = 2;
		question2.content = "Question 2?";
		question2.category = categoryQuestion1;
		question2.type = typeQuestion1;
		question2.createDate = LocalDateTime.now();

		// create Answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Answer question 1";
		answer1.isCorrect = true;

		Answer[] answerQuestion1 = { answer1 };
		question1.answers = answerQuestion1;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "Answer question 2";
		answer1.isCorrect = false;

		Answer[] answerQuestion2 = { answer2 };
		question2.answers = answerQuestion2;

		// create Exams
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "JAVA1";
		exam1.title = "Java Exam";
		exam1.duration = 60;
		exam1.category = categoryQuestion1;
		Question[] questionExam1 = { question1, question2 };
		exam1.questions = questionExam1;
		exam1.createDate = LocalDateTime.now();

//			Question 1:
//			In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng CHINESE
		System.out.println("________________________Question 1________________________");
		DateTimeFormatter dTF1 = DateTimeFormatter.ofPattern("dd - MMMM - yyyy", Locale.CHINESE);
		System.out.println("Title: " + exam1.title);
		System.out.println(exam1.createDate.format(dTF1));

//			Question 2:
//			In ra thông tin: Exam đã tạo ngày nào theo định dạng Năm – tháng – ngày – giờ – phút – giây
		System.out.println("________________________Question 2________________________");
		DateTimeFormatter dTF2 = DateTimeFormatter.ofPattern("yyyy - MMMM - dd - HH - mm - ss");
		System.out.println("Title: "+exam1.title);
		System.out.println("Create Date: "+exam1.createDate.format(dTF2));

//			Question 3:
//			Chỉ in ra năm của create date property trong Question 2
		System.out.println("________________________Question 3________________________");
		DateTimeFormatter dTF3 = DateTimeFormatter.ofPattern("yyyy");
		System.out.println("Content: "+question2.content);
		System.out.println("Create Date: "+question2.createDate.format(dTF3));

//			Question 4:
//			Chỉ in ra tháng và năm của create date property trong Question 2
		System.out.println("________________________Question 4________________________");
		DateTimeFormatter dTF4 = DateTimeFormatter.ofPattern("MM - yyyy");
		System.out.println("Content: "+question2.content);
		System.out.println("Create Date: "+question2.createDate.format(dTF4));
		
//			Question 5:
//			Chỉ in ra "MM-DD" của create date trong Question 2
		System.out.println("________________________Question 5________________________");
		DateTimeFormatter dTF5 = DateTimeFormatter.ofPattern("MM - dd");
		System.out.println("Content: "+question2.content);
		System.out.println("Create Date: "+question2.createDate.format(dTF5));
		
	}

}
