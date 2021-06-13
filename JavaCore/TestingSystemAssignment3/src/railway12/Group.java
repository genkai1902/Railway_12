package railway12;

public class Group implements Comparable<Group>{
	int id;
	String name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "ID: " + id + "\nGroup name: " + name;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}
		
		Group objGroup = (Group) obj;
		if (name.equals(objGroup.name)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Group o) {
		// TODO Auto-generated method stub
		if (id < o.id) {
			return -1;
		} else if (id > o.id) {
			return 1;
		} else {
			return 0;
		}
	}
}
