package 연습;


import java.util.ArrayList;

public class EmpMain {
	
	//문제 1번을 메소드로 만들어서 풀어봐요 (실무)
//	1. 모든 사원 번호, 이름 출력
	public static ArrayList<EmpVO> getEmpList(ArrayList<EmpVO> list) {//EmpVo를 담고있는 ArrayList를 담고 있다.
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).empno);
			System.out.println(list.get(i).ename);
		}
		return list;
	}

	// 1번 문데
	public static String getValue(String name) {
		System.out.println("너의 이름은" + name);
		return name;
	}

			//함수,static
	public static void main(String[] args) {
		String name	= "홍길동";
		String result = getValue(name);
		
		// TODO Auto-generated method stub
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		list.add(new EmpVO(7369,"SMITH","CLERK","1980-12-17",800,20));
		list.add(new EmpVO(7499,"ALLEN","SALESMAN","1981-02-20",1600,30));
		list.add(new EmpVO(7521,"WARD","SALESMAN","1981-02-22",1250,30));
		list.add(new EmpVO(7566,"JONES","MANAGER","1981-04-02",2975,20));
		list.add(new EmpVO(7654,"MARTIN","SALESMAN","1981-09-28",1250,30));
		
		getEmpList(list);	//문제 1번을 메소드로 만들어서 풀어봐요
		
		//일반 for
		int count = 0;
		for(int i=0; i<list.size();i++) {
//			1.사원번호, 이름 출력
			System.out.println("사원번호 = "+list.get(i).empno);
			System.out.println("사원이름 = "+list.get(i).ename);
			
		}
			
//			//2. 급여가 1300달러 이상을 받는 사원의 이름,직업 조회
		for(int i=0; i<list.size(); i++){
			if(list.get(i).sal >= 1300){
				System.out.println("============2번============");
				System.out.println("이름 ==> "+list.get(i).ename);
				System.out.println("직업 ==> "+list.get(i).job);
			}	
		}
		//3. 직업이 SALESMAN인 사원 중 급여가 1400달러 이상 받는 사원의 번호,이름 조회
		for(int i=0; i<list.size(); i++){
			// 자바는 문자를 비교할 때 equals(), 자바에서는 문자를 비교할 때 == 사용하면 문자를 비교하는게 아님.
			if(list.get(i).job.equals("SALESMAN") && list.get(i).sal >= 1400){
				System.out.println("============3번============");
				System.out.println("이름 ==> "+list.get(i).ename);
				System.out.println("직업 ==> "+list.get(i).job);
			}	
		}
		//4. 입사년도가 1981년도인 사원의 번호,이름 조회
		for(int i=0; i<list.size(); i++){
			String hireYear = list.get(i).hiredate.split("-")[0];
			if(hireYear.equals("1981")){
				System.out.println("============4번============");
				System.out.println("번호 ==> "+list.get(i).empno);
				System.out.println("이름 ==> "+list.get(i).ename);
			}		
		}
		//5. 직업이 MANAGER인 사원 수 조회
		int managerCnt =0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).job.equals("MANAGER")){
				++managerCnt;
			}
		}
		System.out.println("============5번============");
		System.out.println("사원 수 ==> "+managerCnt);
		//6. 사원 중 급여를 가장 많이 받는 사원의 번호,이름,입사년도 조회
		int maxSal = 0;
		int index = 0;
		for(int i=0; i<list.size(); i++){
			int sal = list.get(i).sal;
			if(maxSal < sal){
				maxSal = sal;
				index = i;
			}
		}
		System.out.println("============6번============");
		System.out.println("번호 ==> "+list.get(index).empno);
		System.out.println("이름 ==> "+list.get(index).ename);
		System.out.println("입사날짜 ==> "+list.get(index).hiredate);
		//7. 부서번호별 수 조회 ex) 20 : 2명, 30: 3명
		int deptno20 = 0;
		int deptno30 = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).deptno == 20){
				++deptno20;
			}
			if(list.get(i).deptno == 30){
				++deptno30;
			}	
		}	
		System.out.println("============7번============");
		System.out.println("20부서 수 ==> "+deptno20);
		System.out.println("30부서 수==> "+deptno30);
		//8. 입사월이 02월인 사원 수 조회
		int month = 0;
		for(int i=0; i<list.size(); i++){
			String hireMonth = list.get(i).hiredate.split("-")[1];
			if(hireMonth.equals("02")){
				++month;
			}
		}	
		System.out.println("============8번============");
		System.out.println("사원 수 ==> "+month);
	}
	}