import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class DeclarativeScheduler {

	int threadNum;

	@Schedule(second = "*/3", minute = "*", hour = "*", persistent = false)
	// @AccessTimeout(unit = TimeUnit.SECONDS, value = 10)
	public void atSchedule() throws InterruptedException {
		threadNum++;
		System.out.println("INICIO Thread: " + threadNum);

		for (int i = 0; i < 100; i++) {

			System.out.println("Thread: " + threadNum + " Count: " + i);

			Thread.sleep(100);
		}

		System.out.println("FIM Thread: " + threadNum);
		threadNum--;
	}

}
