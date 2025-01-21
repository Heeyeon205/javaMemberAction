package memberAction;

import java.util.ArrayList;

public class ActionSave implements Action {
	private Utils utils;
	private MemberDAO mDao;
	
	public ActionSave() {
		utils = Utils.getInstance();
		mDao = MemberDAO.getInstance();
	}
	
	@Override
	public void execute() {
		if(!mDao.hasData()) return;
		System.out.println("==========[회원 데이터 저장]==========");
		utils.saveFile(mDao);
	}

}
