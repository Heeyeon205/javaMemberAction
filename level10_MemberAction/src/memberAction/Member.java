package memberAction;

import java.util.Comparator;

public class Member implements Comparable<Member> {
	private String id;
	private String pw;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("ID: %s, PW: %s, 이름: %s님", id, pw, name);
	}

	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.getName());
	}

    public static class IdComparator implements Comparator<Member> {
        @Override
        public int compare(Member m1, Member m2) {
            return m1.getId().compareTo(m2.getId());
        }
    }
}
