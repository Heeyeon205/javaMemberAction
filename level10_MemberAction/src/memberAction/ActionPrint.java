package memberAction;

import java.util.ArrayList;

public class ActionPrint implements Action {
	private MemberDAO mDao;
	
	public ActionPrint() {
		mDao = MemberDAO.getInstance();
	}
	
	@Override
	public void execute() {
		if(!mDao.hasData()) return;
		System.out.println("==========[회원 목록]==========");
		mDao.printAll();
	}

}
