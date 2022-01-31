package netumbackend.summer2022.domain;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long person_id;

	private String first_name, last_name;

	private int age;

	public Person() {
	}

	public Person(String first_name, String last_name, int age) {

		this.first_name = first_name;

		this.last_name = last_name;

		this.age = age;
	}

	public Long getPerson_id() {

		return this.person_id;
	}

	public void setPerson_id(Long person_id) {

		this.person_id = person_id;
	}

	public String getFirst_name() {

		return this.first_name;
	}

	public void setFirst_name(String first_name) {

		this.first_name = first_name;
	}

	public String getLast_name() {

		return this.last_name;
	}

	public void setLast_name(String last_name) {

		this.last_name = last_name;
	}

	public int getAge() {

		return this.age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	@Override
	public String toString() {

		return "first_name=" + this.first_name + ", last_name=" + this.last_name + ", age=" + this.age;
	}
}
