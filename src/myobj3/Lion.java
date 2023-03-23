package myobj3;

import myobj2.Animal;

//자식클래스
public class Lion extends Animal {

	@Override
	public void bite() {
		System.out.println("사자가 물면 아프다.");		
	}
}