package today;

public class Today240220 {

	/* 오늘의 수업내용
	 * 여태까지 사용했던 배열은 그 크기가 정해져있어서 배열에 정해진 
	 * 값보다 적게 넣어도 크기를 유지하며 정해진 크기만큼 넣었을때는
	 * 더이상 추가가 안되는 불편함이 있었다. 또 중간에 값을 삭제하는
	 * 과정도 너무나 번거롭고 힘들고 배열에 저장된 데이터의 개수를
	 * 확인하기 어렵다.
	 * 
	 * Collection<E> : 자료(데이터)를 저장하기 위한 Generic 클래스. 최상위 클래스(부모)
	 * |_ List<E>, Set<E> 리스트는 입력되는 값을 순서대로 번호를 매긴다. 중복저장가능, 셋은 순서없이 입력값을 저장하는데 중복값은 자동삭제가 된다.
	 * 
	 *  
	 *  Map<K, V> : 자료를 Key-Value로 저장하기 위한 Generic 클래스
	 * 
	 *  ArrayList 는 데이터 추가 삭제를 할때 빈공간을 만들어서 생성 - 추가 삭제가 느림
	 * 	LinkedList는 데이터를 추가 삭제 할 때 연결 고리를 변경 - 추가 삭제가 빠름
	 * 
	 * List<E>
	 * 1. 자료들이 저장되는 순서가 중요 -> 인덱스 사용
	 * 2. 중복된 값들의 저장을 허용
	 * 
	 * List<E>
	 * ㄴ ArrayList<E>, LinkedList<E>
	 * 
	 * ArrayList<E>
	 * 1. 내부적으로 배열 자료구조를 사용
	 * 2. 저장 용량을 늘리는데 많은 시간이 소요됨 - 단점
	 * 3. 저장된 데이터를 삭제하는데 많은 시간이 소요됨 - 단점
	 * 4. 데이터 참조(검색)할 때 매우 빠름 - 장점
	 * 
	 * LinkedList<E>
	 * 1. 내부적으로 Linked List 자료구조를 사용
	 * 2. 저장 용량을 늘리는 과정이 매우 간단 - 장점
	 * 3. 저장된 데이터를 삭제하는 과적이 매우 간단 - 장점
	 * 4. 데이터를 참조(검색)하는 시간이 매우 느림 - 단점
	 * 
	 * ArrayList<E>, LinkedList<E>에서 사용되는 메소드들 :
	 *  - add(element), get(index), set(index, element), remove(index)
	 *  
	 */
	/* 오늘 배운 List<>는 배열과 비슷하지만 배열과 다르게 값을
	 * 넣는 만큼 늘어나고 값을 빼면 빼는만큼
	 * 줄어드는 편리한 Generic 클래스이다.
	 * 
	 * * List<> 클래스
	 * - 배열과 같은 역할을 Generic 클래스로 생성한 형태
	 * - 배열은 저장되는 크기를 지정해야만하지만, List는 저장의 한계가 없음
	 * - 추가하는 만큼 저장 공간을 늘려줌
	 * - 주요 메소드 :
	 *   add() : 원소 추가
	 *   get() : 원소 읽기
	 *   set() : 원소 변경
	 *   remove() : 원소 삭제
	 *   
	 *	 add안에 선언한 타입의 값을 넣는데 이 때 이미 만들어진 값을 넣거나 인스턴스를 생성해서 넣을수있다.
	 *	 Student stu1 = new Student(2, "park");
	 *	 list3.add(stu1);
	 *
	 *   list3.add(new Student(1, "kim")); // 이쪽이 조금 더 효율적
	 */
	/* Collection<E>
	 * ㄴ Set<E>
	 * 		HashSet<E>, TreeSet<E>
	 * 
	 * Set<E>
	 * 1. 데이터의 저장 순서가 중요하지 않음 -> 인덱스가 없음
	 * 2. 중복된 데이터의 저장을 허용하지 않음
	 * 예) {1, 2, 2, 3, 3, 3} = {1, 2, 3}
	 * 
	 * HashSet<E> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Set
	 * TreeSet<E> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Set
	 *
	 * Set<E>은 인덱스로 데이터를 읽어올 수 있는 get() 메소드를 제공하지 않음
	 * 따라서 Set<E>로 만들어진 배열의 모든 정보를 읽기 위해 for-each문을 사용 
	 * 		for(Integer x : set) { 
	 * 		for-each문은 인덱스가 없어도 배열의 모든 데이터에 접근하기위해 사용
	 *			System.out.println(x);
	 *		}
	 *
	 * 	 Iterator(반복자)를 사용한 데이터 검색
	 * 
	 * - Iterator 인터페이스
	 *	 iterator() : Iterator 객체를 리턴
	 *	 hasNext() : Iterator 객체가 가리키는 위치에
	 *	 원소가 있는지(true), 없는지(false)를 리턴하는 메소드
	 *	 next() : Iterator 객체가 가리키는 위치를 다음 위치로 이동하고,
	 *			  원래 가리키고 있던 값을 리턴하는 메소드
	 *	 사용 이유 : 모든 컬렉션에서 공통으로 사용 가능
	 *
	 *	 Set<E>의 원소를 삭제 : remove(element)
	 *	 인덱스가 아니라 값으로 삭제한다.
	 *
	 *	 데이터 변경을 위한 set(index, element) 메소드를 제공하지 않음
	 *	 왜냐하면 인덱스를 사용하지 않기때문에 그렇다.
	 *	 데이터 변경 => 데이터 삭제(remove) + 데이터 추가(add)
	 *
	 */
	/* List<E>, Set<E> : 한가지 타입의 데이터를 저장할 수 있는 collection
	 * 
	 * Map<K, V> : Key-Value 쌍으로 데이터를 저장하는 구조
	 * 			  1. Key는 중복되지 않은 값만 저장
	 * 			  2. Value는 중복된 값도 저장 가능
	 * 			  3. 검색, 수정, 삭제할 때 Key값을 사용함
	 *
	 * HasMap<K, V> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Map
	 * TreeMap<K, V> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Map
	 * 
	 *  Map<K, V>의 데이터 하나 검색 : get(key)
	 *  ㄴ  단점 : key를 모르면 사용 불가
	 *  Map<K, V>에서 데이터를 수정 : put(key, value)
	 *  Map<K, V>에서 데이터를 삭제 : remove(key)
	 *  Map<K, V>에서 key들로만 이루어진 Set을 생성 : keySet()
	 *  
	 */
			
} // end Today240220
