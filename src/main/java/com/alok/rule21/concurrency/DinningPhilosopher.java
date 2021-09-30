package com.alok.rule21.concurrency;

public class DinningPhilosopher implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] locks = new Object[5];
		DinningPhilosopher[] philosophers = new DinningPhilosopher[5];
		for (int i = 0; i < 5; i++) {
			locks[i] = new Object();
		}

		for (int i = 0; i < 5; i++) {
			Object leftFork = locks[i];
			Object rightFork = locks[(i + 1) % 5];
			// any 1 philosopher picks right fork first to prevent deadlock 
			if (i == 4)
				philosophers[i] = new DinningPhilosopher(rightFork, leftFork);
			else
				philosophers[i] = new DinningPhilosopher(leftFork, rightFork);

			Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();
		}

	}

	private Object leftFork;
	private Object rightFork;

	public DinningPhilosopher(Object leftFork, Object rightFork) {
		super();
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	public void run() {

		try {
			while (true) {

				doAction(System.nanoTime() + ": Thinking");
				synchronized (leftFork) {
					doAction(System.nanoTime() + ": Holding left fork");
					synchronized (rightFork) {
						doAction(System.nanoTime() + ": Holding left & right fork- Eating");
						doAction(System.nanoTime() + ": Released right fork");
					}
					doAction(System.nanoTime() + ": Released left fork & thinking");
				}

			}
		} catch (InterruptedException exception) {
			Thread.currentThread().interrupt();
			return;
		}

	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(((int) (Math.random() * 100)));
	}

}
