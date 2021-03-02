package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 
 *      Student클래스를 만든다.
 *      이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로
 *      받아서 초기화 처리를 한다.
 *     
 *     - 이 Student객체는 List에 저장하여 관리한다.
 *     
 *     - List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 *     총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
 *     외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 *     
 * 	   (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 * 
 */

public class ListSortTest3 {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(6, "유승종", 78, 45, 78));
		studentList.add(new Student(5, "홍길동", 65, 65, 65));
		studentList.add(new Student(4, "전영헌", 65, 65, 65));
		studentList.add(new Student(7, "김도영", 65, 65, 65));
		studentList.add(new Student(2, "이수정", 76, 78, 78));
		studentList.add(new Student(1, "김경분", 95, 90, 90));
		studentList.add(new Student(3, "유민종", 98, 67, 64));
		
		
		Collections.sort(studentList);
		System.out.println("학번의 오름차순 정렬후...");   // 내부 정렬 기준으로 정렬한다.
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------");
		
		Collections.sort(studentList, new SortTotAsc());	// 외부 정렬 기준으로 정렬한다.
		System.out.println("총점의 내림차순 정렬후...");
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------");
		
		for(int i = 0; i < studentList.size(); i++) {
			int rank = 1;
			for(int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getTot() < studentList.get(j).getTot()) {
					rank++;
				}
			}
			studentList.get(i).setRank(rank);
		}
		System.out.println("등수 오름차순 정렬후...");
		for(Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------");
		
		
	}
}

class Student implements Comparable<Student>{
	private int stdno;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int rank;
	
	
	public Student(int stdno, String name, int kor, int eng, int math) {
		super();
		this.stdno = stdno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor + eng + math;
	}


	public int getStdno() {
		return stdno;
	}


	public void setStdno(int stdno) {
		this.stdno = stdno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		return tot;
	}


	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

	
	@Override
	public String toString() {
		return "Student [stdno=" + stdno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", tot=" + tot + ", rank=" + rank + "]";
	}

	
	//학번의 오름차순 정렬기준
	@Override
	public int compareTo(Student stdno) {
		return Integer.compare(this.stdno, stdno.getStdno());
	}
	
}

class SortTotAsc implements Comparator<Student>{
	@Override
	public int compare(Student tot1, Student tot2) {
		if(tot1.getTot() == tot2.getTot()) {	// 총점이 같은 때
			return tot1.getName().compareTo(tot2.getName());
		} else {
		return Integer.compare(tot1.getTot(), tot2.getTot()) * -1;
		}
	}
}
