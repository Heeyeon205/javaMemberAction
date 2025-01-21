package memberAction;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	private Map<Menu, Action> mapList;
	private Utils utils;
	
	public Controller() {
		mapList = new HashMap<Menu, Action>();
		mapList.put(Menu.INSERT, new ActionInsert());
		mapList.put(Menu.DELETE, new ActionDelete());
		mapList.put(Menu.UPDATE, new ActionUpdate());
		mapList.put(Menu.PRINT, new ActionPrint());
		mapList.put(Menu.SAVE, new ActionSave());
		mapList.put(Menu.LOAD, new ActionLoad());
		utils = Utils.getInstance();
	}
	
	public Action getAction(Menu key) {
		return mapList.get(key);
	}
	
	public void run() {
		while(true) {
			System.out.println("==========Menu==========");
			System.out.println("[1] 추가");	// id 중복 제거
			System.out.println("[2] 삭제");	// id 입력 받아 삭제
			System.out.println("[3] 수정");	// id pw 확인 후 이름 수정
			System.out.println("[4] 출력");	// 이름순으로 출력
			System.out.println("[5] 저장");	// member.txt => id순으로 저장
			System.out.println("[6] 로드");	// member.txt 
			System.out.println("[0] 종료");
			int sel = utils.getValue("메뉴 입력: ", 0, 7);
			if(sel == 1) {
				getAction(Menu.INSERT).execute();
			}else if(sel == 2) {
				getAction(Menu.DELETE).execute();
			}else if(sel == 3) {
				getAction(Menu.UPDATE).execute();
			}else if(sel == 4) {
				getAction(Menu.PRINT).execute();
			}else if(sel == 5) {
				getAction(Menu.SAVE).execute();
			}else if(sel == 6) {
				getAction(Menu.LOAD).execute();
			}else if(sel == 0) {
				System.out.println("==========[종료]==========");
				break;
			}
		}
	}
}
