 package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		Animal animal = new Animal("동물");
		animal.speak();
		
		System.out.println();
		Dog dog = new Dog("토토", "시고르자브종");
		dog.speak();
		
		System.out.println();
		Cat cat = new Cat();
		cat.speak();
		
		Animal[] a = new Animal[3]; 
		// 서로 다른 객체인 즉 타입이 다른경우인 객체들을 같은속성으로 묶는다. (부모 자식 관계면 가능.
		a[0] = animal;
		a[1] = dog;
		a[2] = cat;
		for(int i = 0; i < a.length; i++) {
			a[i].speak(); 
			// 부모에 정의된 메소드를 재정의한 자식들을 부모와 자식 모두 한 배열로 묶어서
			// 메소드를 실행하면 배열에 속한 다른 객체들이 같은 메소드를 실행한다.
		}
		
	} // end main()

} // end InheritMain04








