package my;

public class Philosopher implements Runnable{
	int id;
	Fork leftFork, rightFork;
	Thread thread;
	boolean haveEaten;
	boolean haveEaten() {
		return haveEaten;
	}
	Philosopher(int _id, Fork left, Fork right){
		leftFork = left;
		rightFork = right;
		thread = new Thread(this);
		id = _id;
		thread.start();
	}
	@Override
	public void run()
	{
		while(true) {
		if(forksIsFree()) {
			takeFork(true);
			eat();
			try {
				thread.sleep(2000);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
			System.out.println("������� "+(id+1)+" ��������");
			haveEaten = true;
			takeFork(false);
			break;
		}else {
			continue;
		}
		}
	}
	
	void eat() {
		System.out.println("������� "+(id+1)+" �������");
	}
	
	synchronized void takeFork(boolean state) {
		leftFork.setState(state);
		rightFork.setState(state);
	}
	
	synchronized boolean forksIsFree() {
		if(leftFork.isTaken()==false && rightFork.isTaken()==false)
			return true;
		return false;
	}
}