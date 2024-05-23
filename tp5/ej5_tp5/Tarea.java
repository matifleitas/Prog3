package ej5_tp5;

public class Tarea implements Comparable<Tarea>{
	private int time;

	public Tarea(int time) {
		super();
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	@Override
	public int compareTo(Tarea o) {
		return o.getTime()-this.getTime();
	}
}
