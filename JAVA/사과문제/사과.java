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