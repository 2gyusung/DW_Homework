package 연습;

import java.util.ArrayList;

public class ArrayList_Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>(); //ctrl + Shift + o 불러오기
		list.add("시금치 파스타");
		list.add("곱창 파스타");
		list.add("스테이크 파스타");
		list.add("곱창 파스타");
		list.add("로제 파스타");
		list.add("곱창 파스타");
		
		
		int len = list.size(); // list 길이 호출
		System.out.println("list 길이는 ===>  " + len);
		
		String val = list.get(3);
		System.out.println("메뉴는 " + val); //데이터 호출
		
//		문제 : list에 저장된 곱창 파스차는 몇개?
		int cnt = 0;
		for(int i = 0; i<list.size(); i++) {
			String valued = list.get(i);
			System.out.println(valued);
			if(valued.equals("곱창 파스타")){
			++cnt;
		}
	}
		System.out.println(cnt); //곱창 파스타 3개 출력
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(25);
		list2.add(30);
		list2.add(320);
		
		int count = 0;
		for(int i = 0; i<list2.size(); i++ ) {
			int val2 =  list2.get(i);
			System.out.println(val2);
			if(list2.get(i) != 320) {
				cnt += list2.get(i);         
			}
		}
		System.out.println("총 합은 : " + count);

}
}
