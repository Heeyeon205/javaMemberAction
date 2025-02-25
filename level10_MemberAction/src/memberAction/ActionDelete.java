package memberAction;

import java.util.ArrayList;

public class ActionDelete implements Action {
	private Utils utils;
	private MemberDAO mDao;
	
	public ActionDelete() {
		utils = Utils.getInstance();
		mDao = MemberDAO.getInstance();
	}
	
	@Override
	public void execute() {
		if(!mDao.hasData()) return;
		System.out.println("==========[회원 탈퇴]==========");
		String id = utils.getString("ID 입력: ");
		if(!mDao.hasId(id)) return;
		String pw = utils.getString("PW 입력: ");
		int idx = mDao.getIdx(id);
		if(!mDao.isMatch(id, pw)) return;
		mDao.deleteMember(idx);
		System.out.printf("ID: %s 회원님 탈퇴 완료!\n", id);
	}

}
