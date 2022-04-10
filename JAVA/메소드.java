```
생성자와 함수 차이(목적이 다름)
    1. 생성자는 초기화
    2. 함수는 로직을 처리 or 리턴
    3. 생성자는 리턴이 없음
    4. 생성자 이름이 클래스 이름과 동일해야 함 (클래스 이름과 다르면 함수로 인식함)
```
```java
package 상속;
// 1. 햄버거에서 햄버거공장을 불러온다
// 2. 새우 3000, 불고기 2500, 치킨 4000, 치즈 3000
// 3. 방법 총 3가지
class 햄버거공장{
	String pattyName;
	int money;
	// 방법 1-1. 생성자 파라미터 이용
//	public 햄버거공장(String pattyName, int money) {
//		this.pattyName = pattyName;
//		this.money = money;
//	}
	
	// 방법 1-2. 빈 생성자 이용(디폴트로 존재하기 때문에 빈 생성자를 따로 안 적어도 됨)
//	public 햄버거공장() {
//		
//	}
	// 방법 2. getter, setter 사용
//	public String getPattyName() {
//		return pattyName;
//	}
//	public void setPattyName(String pattyName) {
//		this.pattyName = pattyName;
//	}
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
public class 햄버거 {
	public static void main(String[] args) {
		// 방법 1-1. 생성자 이용
//		햄버거공장 새우 = new 햄버거공장("새우",3000);
//		System.out.println(새우.pattyName+"햄버거 "+새우.money+"원");
//		햄버거공장 불고기 = new 햄버거공장("불고기",2500);
//		System.out.println(불고기.pattyName+"햄버거 "+불고기.money+"원");
		
		// 방법 1-2. 빈생성자 이용
		햄버거공장 불고기 = new 햄버거공장();
		불고기.pattyName = "불고기";
		불고기.money = 2500;
		System.out.println(불고기.pattyName+"버거 "+불고기.money+"원");
		햄버거공장 치킨 = new 햄버거공장();
		치킨.pattyName = "치킨";
		치킨.money = 4000;
		System.out.println(치킨.pattyName+"버거 "+치킨.money+"원");
		
		// 방법 2. getter, setter 사용
//		햄버거공장 치킨 = new 햄버거공장();
//		치킨.setPattyName("치킨");
//		치킨.setMoney(4000);
//		String 치킨이름 = 치킨.getPattyName();
//		int 치킨가격 = 치킨.getMoney();
//		System.out.println(치킨이름+"햄버거 "+치킨가격+"원");
//		
//		햄버거공장 치즈 = new 햄버거공장();
//		치즈.setPattyName("치즈");
//		치즈.setMoney(3000);
//		String 치즈이름 = 치즈.getPattyName();
//		int 치즈가격 = 치즈.getMoney();
//		System.out.println(치즈이름+"햄버거 "+치즈가격+"원");
				
		// 많이 쓰는 순서 : 2 > 1-1 > 1-2
		// 이유 : 필드변수를 private 선언을 하면 getter, setter로 접근할 수밖에 없음
	}
}
```

```java
필드변수를 메소드로 접근하는 이유와 방법
package 상속;
class StoreSub{
	int money;
	public int sumMoney(int money) {
		int sum = this.money += money;
		// sum = this.money = this.money + money 
		// this = StoreSub
		// 왼쪽 money는 StoreSub에 있는 money, 오른쪽에 있는 money는 파라미터 money
		return sum;
		// = return this.money
	}
}
public class Store {
	public static void main(String[] args) {
//		StoreSub s = new StoreSub();
//		s.money = 100;
//		s.money += 100;
//		System.out.println(s.money);
		// but 실무에서는 보안상 이유 때문에 필드변수가 private이라서 직접 접근하지 못함
		// 필드변수가 private이면 s.money 같은 표현이 불가능해짐
		// 따라서 필드변수는 메소드를 활용해서 접근해야 한다.
		StoreSub s = new StoreSub(); // 객체(필드변수 money) 생성. money = 0
		// 원래는 클래스를 불러왔으면, 끝을 표현해 줘야 함. 
		// C++은 소멸하는 문법(~StoreSub();)을 직접 타이핑한다. 
		// 하지만 자바는 객체를 생성하고나서 자동으로 소멸시켜 줌.
		int result = s.sumMoney(100); // 100
		result = s.sumMoney(100); // 200
		System.out.println(result);
	}
}
```

```
문제
    1. Apple, Person(m) 클래스 생성
    2. Apple 클래스에 수량(int)을 나타내는 필드변수
    3. 사과를 구입하는 메소드와 사과를 먹는 메소드 생성
    4. Person에서 사과를 10개 구매해서 4개 먹으면 수량(필드변수) 6개 조회되어야 함
    조건) 사과를 구매하지 않으면 먹을 수 없음
```
```java
package 상속;
public class Apple {
	int count; // 수량
	
	// 방법 1. getter, setter 사용
	public Apple() {
		
	}
    // 방법 2에서 파라미터가 있는 생성자를 정의했기 때문에 빈 생성자를 만들어줘야 함
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	// 방법 2. 생성자 파라미터 사용
	public Apple(int count) {
		this.count = count;
	}
}
```
```java
package 상속;
public class Person {
	public static void main(String[] args) {
		// 방법 1. getter, setter 사용
		Apple buy = new Apple();
		buy.setCount(10); // 10개 구매
		int buyCount = buy.getCount();
		
		Apple eat = new Apple();
		eat.setCount(4); // 4개 먹음
		int eatCount = eat.getCount();
		
		if(buyCount > eatCount) {
			int restCount = buyCount - eatCount; // 남은 수량
			System.out.println("1. 구매한 사과 : "+buyCount+"개");
			System.out.println("   먹은 사과 : "+eatCount+"개");	
			System.out.println("   남은 사과 : "+restCount+"개");			
		}
		
		// 방법 2. 생성자 파라미터 사용
		Apple buy02 = new Apple(100);
		int buyCount02 = buy02.count;
	
		Apple eat02 = new Apple(5);
		int eatCount02 = eat02.count;
		
		if(buyCount02 > eatCount02) {
			int restCount02 = buyCount02 - eatCount02;
			System.out.println("2. 구매한 사과 : "+buyCount02+"개");
			System.out.println("   먹은 사과 : "+eatCount02+"개");
			System.out.println("   남은 사과 : "+restCount02+"개");
		}
		
		// 방법 3. 빈 생성자 사용
		Apple buy03 = new Apple();
		buy03.count = 3;
		Apple eat03 = new Apple();
		eat03.count = 5;
		if(buy03.count > eat03.count) {
			int restCount03 = buy03.count - eat03.count;
			System.out.println("3. 구매한 사과 : "+buy03.count+"개");
			System.out.println("   먹은 사과 : "+eat03.count+"개");
			System.out.println("   남은 사과 : "+restCount03+"개");
		}else {
			System.out.println("3. 지금 먹을 수 있는 사과는 "+buy03.count+"개 입니다.");
		}
	}
}
```

```
길동이는 원소주페이지 관리자이다.
길동이의 오늘하루 업무는 아래와 같다
1. 오전 11시에 원소주 판매버튼을 활성화 해야한다
2. 고객게시판 게시글을 삭제, 수정, 등록해야한다
3. 탈퇴한 회원은 별도로 sms를 보내야 한다
4. 원소주를 구매한 회원을 포인트 점수를 줘야 한다
필요한 메소드 개수는?
    판매버튼 활성화 1개
    게시글 삭제, 수정, 등록 3개
    sms 보내기 1개
    포인트 주기 1개
    최소 6개
    + 원소주 구매한 회원을 조회
    + 탈퇴한 회원을 조회
    8개까지 필요
```

```
사과 문제
조건
    1. apple, person(m)클래스 생성.
    2. apple 클래스에 (int)수량을 나타내는 필드변수!
    3. 사과를 구입하는 메소드, 사과를 먹는 메소드 표현
    4. person사과를 10개구매, 사과를 4개 먹음, 수량(필드변수) 6개
    단, 사과를 구매하지 않으면 먹지못함
```
```java
package 상속;
public class Apple {
	int count; // 수량
	
	public int getAppleCount() { // 사과수량
		return this.count;
	}
	public void buyApple(int count) {
		System.out.println("사과를 "+count+"개 구매했어요~");
		this.count += count;
	}
	public void eatApple(int count) {
		if(this.count >= count) {
			System.out.println("사과를 "+count+"개 먹었어요~");
			this.count -= count;
		}else {
			System.out.println("사과가 부족해요~ "+count+"개 만큼 먹을 수 없어요");
		}
	}
}
```
```java
package 상속;
public class Person {
	public static void main(String[] args) {
	Apple apple = new Apple();
		System.out.println("현재 사과는 : "+apple.getAppleCount()+"개 있습니다.");
		apple.buyApple(20);
		if(apple.getAppleCount() > 0) {
			System.out.println("현재 사과는 : "+apple.getAppleCount()+"개 있습니다");
			apple.eatApple(30);
			System.out.println("현재 사과는 : "+apple.getAppleCount()+"개 있습니다");
			apple.buyApple(20);
			System.out.println("현재 사과는 : "+apple.getAppleCount()+"개 있습니다");
			apple.eatApple(30);
			System.out.println("현재 사과는 : "+apple.getAppleCount()+"개 있습니다");
		}
	}
}        
```

```
은행 프로그램 개발
지유는 총 입금금액, 출금금액, 잔고금액을 보고싶다.
(주)상원IT에 프로그램 개발을 의뢰했다.
총 입금금액, 출금금액 그리고 현재 잔고금액을 확인할 수 있게 해야한다.
조건
    1. 출금은 현재 잔고보다 많을 수 없다.
    2. 한번 입금할 때 50만원 이하로만 할 수 있다.
    3. 최종 잔고가 100만원이 넘으면 이자 10%를 지급한다.
생각) 입금 메소드, 출금 메소드, 잔고 메소드가 필요할 것
```
```java
package 상속;
public class Bank {
	double count;
	int eventCount; // 10% 이자를 한번만 지급하기 위해서
	
	public double totalMoneyCount() {
		return this.count;
	}
	public void depositMoney(double count, int eventCount) {
//	public void depositMoney(double count) {
		if(count <= 500000) {
			System.out.println("입금 : "+Math.round(count));
			this.count += count;			
		}else {
			System.out.println("*입금 오류 : 한번에 입금 가능한 최대 금액은 50만원 입니다.*");
		}
		if(this.count >= 1000000 && this.eventCount == 0) {
//		if(this.count >= 1000000) {
			this.count *= 1.1;
			this.eventCount++;
			System.out.println("100만원 달성! 이자 10% 지급");
		}
	}
	public void withdrawMoney(int count) {
		if(this.count >= count) {
			System.out.println("출금 : "+count);
			this.count -= count;
		}else {
			System.out.println("*출금 오류 : 잔고가 부족합니다.*");
		}
	}
}
```
```java
package 상속;
public class Money {
	public static void main(String[] args) {
		Bank bank = new Bank();
		System.out.println("-------------------------------------------");
		System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
		System.out.println("-------------------------------------------");
		bank.depositMoney(100000,0);
		System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
		if(bank.totalMoneyCount() > 0) {
			System.out.println("-------------------------------------------");
			bank.withdrawMoney(300000);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.depositMoney(600000,0);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.depositMoney(500000,0);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.withdrawMoney(100000);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.depositMoney(450000,0);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.depositMoney(100000,0);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
			bank.depositMoney(300000,0);
			System.out.println("현재 잔액 : "+Math.round(bank.totalMoneyCount()));
			System.out.println("-------------------------------------------");
		}
	}
}
```

```java
    static main(){
        // 스태틱 메인 함수에서 사용 가능한 함수 (2가지만 가능!)
        // 1. 스태틱 함수
        // 2. new로 불러온 함수 (heap에 있는 동적타입)
    }
```

```java
선생님 풀이
package 상속;
class Account{ // 계좌
	int deposit; // 입금
	int withdraw; // 출금
	int totalMoney; // 잔고
	
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) { // 입금
		// 총 입금액과 잔고액을 동시에 보여줘야 한다.
		// 입금 50만원 이하로만 가능하게 로직 추가
		if(deposit <= 500000) {
			System.out.println("입금한 금액 ==> "+deposit+"원");
			this.deposit += deposit; // 총 입금금액
			// 입금액을 더해주기 위해서 =을 +=으로 수정
			this.totalMoney += deposit; // 잔액 			
		}else {
			System.out.println("입금은 50만원 이하만 가능합니다.");
		}
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) { // 출금
		if(this.totalMoney<withdraw) {
			System.out.println("이체할 수 없습니다.");
		}else {
			System.out.println("출금한 금액 ==> "+withdraw+"원");
			this.withdraw += withdraw;
			this.totalMoney -= withdraw;						
		}
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int interest) { // 잔액에 이자 더함
		this.totalMoney += interest;
	}
}
public class Bank_2 {
	public static double paidInterestOnAccount(int money) { // 이자를 주는 함수
		final double INTEREST_RATE = 0.1;
		return money * INTEREST_RATE;
	}
	// 모든 기능을 함수로 나눠야 나중에 수정하기 편하다
	public static void main(String[] args) {
		Account account = new Account();
		account.setDeposit(1000);
		if(account.getTotalMoney() > 0) {
			System.out.println("현재잔고 ==> "+account.getTotalMoney()+"원");
			account.setWithdraw(500);
			System.out.println("현재잔고 ==> "+account.getTotalMoney()+"원");
			account.setDeposit(500000); // 월급 50만원
			account.setDeposit(500000); // 보너스 50
			account.setDeposit(500000); // 야근 50
			System.out.println("현재잔고 ==> "+account.getTotalMoney()+"원");
			int myMoney = account.getTotalMoney();
			if(myMoney > 1000000) { // 입금 후 잔액이 100만원 이상이면
				int interestMoney = (int)paidInterestOnAccount(myMoney);
				// 만약 paidInterestOnAccount에 static을 없애면 오류가 난다. 대신 Bank_2를 new로 호출하고 Bank_2.paidInterestOnAccount로 static 없이 사용할 수 있다. 
				// (int) : int형으로 변환
				System.out.println("이자는 ==> "+interestMoney);
				account.setTotalMoney(interestMoney);
				System.out.println("현재 잔고 ==> "+account.getTotalMoney()+"원");
			}
			account.setDeposit(100000);
			System.out.println("현재잔고 ==> "+account.getTotalMoney()+"원");
		}
	}
}
```

```
알로하녹카페는 회원제로 운영한다.
커피 10잔을 마시면 브론즈 회원
커피 20잔을 마시면 실버 회원
커피 30잔을 마시면 골드 회원
생각) 마신 커피 수 메소드, 등급 메소드가 필요
```
```java
package 상속;
public class Member {
	int count; // 마신 커피 수
	String memberGrade; // 등급
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		System.out.println("커피를 "+count+"잔 주문하셨습니다.");
		this.count += count;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(int count) {
		if(count < 10) {
			memberGrade = "없음";
		}
		if(count >= 10 && count < 20) {
			memberGrade = "Bronze";
		}
		if(count >= 20 && count <30) {
			memberGrade = "Silver";
		}
		if(count >= 30) {
			memberGrade = "Gold";
		}
		System.out.println("회원 등급 : "+memberGrade);
	}
}
```
```java
package 상속;
public class Cafe {
	public static void main(String[] args) {
		Member member = new Member();
		member.setCount(5);
		System.out.println("현재까지 마신 커피는 "+member.getCount()+"잔 입니다.");
		member.setMemberGrade(member.getCount());
		
		member.setCount(7);
		System.out.println("현재 마신 커피는 "+member.getCount()+"잔 입니다.");
		member.setMemberGrade(member.getCount());
		
		member.setCount(10);
		System.out.println("현재 마신 커피는 "+member.getCount()+"잔 입니다.");
		member.setMemberGrade(member.getCount());
		
		member.setCount(50);
		System.out.println("현재 마신 커피는 "+member.getCount()+"잔 입니다.");
		member.setMemberGrade(member.getCount());
//		System.out.println("회원 등급 : "+member.getMemberGrade());
	}
}
```