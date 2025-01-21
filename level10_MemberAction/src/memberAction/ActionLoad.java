package memberAction;

import java.util.ArrayList;

public class ActionLoad implements Action {
	private Utils utils;
	private MemberDAO mDao;
	
	public ActionLoad() {
		utils = Utils.getInstance();
		mDao = MemberDAO.getInstance();
	}
	
	@Override
	public void execute() {
		System.out.println("==========[회원 데이터 불러오기]==========");
		utils.loadFile(mDao);
	}

}
