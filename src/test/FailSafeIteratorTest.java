package test;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIteratorTest {

	public static void main(String[] args) throws InterruptedException {

		ConcurrentHashMap<Person, String> map = new ConcurrentHashMap<>();
		Thread populatorThread = new Thread(new PopulatorRunnable(map), "populator");
		Thread iteratorThread = new Thread(new IteratorRunnable(map), "iterator");
		populatorThread.start();
		iteratorThread.start();
		Thread.sleep(15000);
		System.out.println("\n\n\n" + new TreeMap<Person, String>(map) + " " + map.size());
	}
}

class PopulatorRunnable implements Runnable {

	ConcurrentHashMap<Person, String> map;

	PopulatorRunnable(ConcurrentHashMap<Person, String> map) {
		this.map = map;
	}

	@Override
	public void run() {

		int count = 1000;
		while (count > 0) {
			System.out.println("Inserting " + count);
			map.put(new Person(count), "");
			count--;
			if (count == 500)
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

	}
}

class Person implements Comparable<Person> {

	int id;

	Person(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		return 1;
	}

	@Override
	public boolean equals(Object o) {
		Person p1 = (Person) o;
		return this.id == p1.id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + "]";
	}
	
	@Override
	public int compareTo(Person p) {
		return this.id - p.id; 
	}

}

class IteratorRunnable implements Runnable {

	ConcurrentHashMap<Person, String> map;

	IteratorRunnable(ConcurrentHashMap<Person, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IteratorRunnable");
		Iterator<Person> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Person person = (Person) iter.next();
			if (person.id % 5 == 0) {
				System.out.println(person.id + " found. removing it!");
				iter.remove();
			}
		}
	}
}
