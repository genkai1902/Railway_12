package railway12;

import java.time.LocalDate;

public class Account {
	
//	Question 2:
	int id;
	String email;
	String username;
	String fullName;
	String lastName;
	String positionName;
	LocalDate createDate;
	
//	a) Không có parameters
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
//	b) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)
	public Account(int id, String email, String username, String firstN, String lastN) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstN + " " + lastN;
	}
	
//	c) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, default createDate = now
	public Account(int id, String email, String username, String firstN, String lastN, String position){
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstN + " " + lastN;
		this.positionName = position;
		this.createDate = LocalDate.now();
	}

//	d) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, createDate
	public Account(int id, String email, String username, String firstN, String lastN, String position, LocalDate createDate){
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = firstN + " " + lastN;
		this.positionName = position;
		this.createDate = createDate;
	}
	
}
