package memberAction;

import java.util.ArrayList;

public class ActionInsert implements Action{
	private Utils utils;
	private MemberDAO mDao;

	public ActionInsert() {
		utils = Utils.getInstance();
		mDao = MemberDAO.getInstance();
	}

	@Override
	public void execute() {
		System.out.println("==========[회원 가입]==========");
		String id = utils.getString("ID 입력: ");
		if(mDao.isDupId(id)) return;
		String pw = utils.getString("PW 입력: ");
		String name = utils.getString("이름 입력: ");
		mDao.addMember(id, pw, name);
		System.out.printf("ID: %s, %s님 회원 가입 완료!\n", id, name);
	}
	
}
