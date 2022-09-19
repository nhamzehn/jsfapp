package javacourse;

public class MainThread {

	private static int odd = 1;
	private static int even = 2;

	public static void main(String[] args) throws InterruptedException {

		Counter1 c1 = new Counter1();
		Counter2 c2 = new Counter2();

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);

		t1.start();
		t2.start();
		
		Thread.sleep(5000);
		System.out.println("--> Main Thread");
		
		Thread.sleep(5000);
		System.out.println("-----> Main Thread");
		
		t1.interrupt();
		t2.interrupt();
		
	}

	public static class Counter1 implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("Counter1 ---> " + odd);
				odd += 2;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class Counter2 implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("Counter2 ----------------> " +even);
				even += 2;
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
