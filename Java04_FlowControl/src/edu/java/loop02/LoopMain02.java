package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {

		// 두 개의 주사위를 던져서 나온 값을 (x,y)와 같은 형식으로 출력해라
		// 두 개의 주사위가 같은 숫자가 나오면 종료

		while (true) {
			// random() : 0 <= x < 1 사이의 난수 발생
			double rX = Math.random();
			double rY = Math.random();

			// 0 + 1 * 6 <= x * 6 < 7(6.999999...)
			int x = (int) (6 * rX + 1);
			int y = (int) (6 * rY + 1);
			
			System.out.println("x : " + x + ", " + "y : " + y);
			if (x == y) {
				System.out.println("같은 수가 나왔습니다.");
				break;
			}
		}

	} // end main()

} // end Loopmain02
