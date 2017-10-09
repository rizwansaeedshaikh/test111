import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().maxMemory());
		
		TestShutdownHook shutdownHook = new TestShutdownHook();
		
		Runtime.getRuntime().addShutdownHook(shutdownHook);
		Runtime.getRuntime().removeShutdownHook(shutdownHook);
		Process mvn = Runtime.getRuntime().exec("C:\\Softwares\\salaattimesetup.exe");
		BufferedReader outputReader = new BufferedReader(new InputStreamReader(mvn.getInputStream(), "UTF-8"));
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(mvn.getErrorStream(), "UTF-8"));
		
		String str;
		while((str = outputReader.readLine()) != null)
			System.out.println(str);
		
		while((str = errorReader.readLine()) != null)
			System.out.println(str);
		
	}
}
class TestShutdownHook extends Thread {
	
	@Override public void run() {
		System.out.println(this.getClass());
	}
}
