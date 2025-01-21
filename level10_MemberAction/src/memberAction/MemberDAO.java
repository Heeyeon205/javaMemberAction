package memberAction;

import java.util.ArrayList;
import java.util.Collections;

public class MemberDAO {
	private static ArrayList<Member> mList;
	private static MemberDAO instance;
	
	private MemberDAO() {}
	
	public static ArrayList<Member> getMemberList() {
		if(mList == null) {
			mList = new ArrayList<Member>();
		}
		return mList;
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public boolean isDupId(String id) {
		for(Member m : mList) {
			if(m.getId().equals(id)) {
				System.out.println("중복 ID는 사용할 수 없습니다.");
				return true;
			}
		}
		return false;
	}

	public boolean hasId(String id) {
		for(Member m : mList) {
			if(m.getId().equals(id)) {
				return true;
			}
		}
		System.out.println("해당 ID는 없는 ID입니다.");
		return false;
	}
	
	public void addMember(String id, String pw, String name) {
		mList.add(new Member(id, pw, name));
	}
	
	public void deleteMember(int idx) {
		mList.remove(idx);
	}
	
	public void setMember(int idx, String id, String pw, String newName) {
		mList.set(idx, new Member(id, pw, newName));
	}

	public boolean isMatch(String id, String pw) {
		for(int i = 0; i < mList.size(); i++) {
			if(mList.get(i).getId().equals(id) && mList.get(i).getPw().equals(pw)) {
				return true;
			}
		}
		System.out.println("PW가 일치하지 않습니다.");
		return false;
	}

	public int getIdx(String id) {
		int idx = 0;
		for(int i = 0; i < mList.size(); i++) {
			if(mList.get(i).getId().equals(id)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public boolean hasData() {
		if(mList.size() == 0) {
			System.out.println("데이터가 없습니다.");
			return false;
		}
		return true;
	}

	public boolean isDupName(String name, int idx) {
		for(int i = 0; i < mList.size(); i++) {
			if(mList.get(idx).getName().equals(name)) {
				System.out.println("현재 이름으로 변경할 수 없습니다.");
				return true;
			}
		}
		return false;
	}
	
	public void printAll() {
		ArrayList<Member> temp = (ArrayList<Member>) mList.clone();
		Collections.sort(temp);
		for(Member m : temp) {
			System.out.println(m);
		}
		
	}
}
