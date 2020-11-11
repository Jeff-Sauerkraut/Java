import java.util.Random;

public class myHeap {
	public static void main(String[] args) {
		for (int action =1; action <=30; action ++){
				Random random = new Random();
				Heap211 a = new Heap211();
				int whatAction = random.nextInt(2); 

				if (whatAction ==0) { // add 
			     // Generate a Random number for the node value (0~99);
					int element =  random.nextInt(100);
					a.add(element);
					System.out.println("Add: " + element);
					System.out.println(a);
			    	}

				if (whatAction ==1) {  // remove
					if (a.size== 0) {
						continue;
					}
					else { 
						int element = a.remove();
		                System.out.println("Removed: " + element);
		                System.out.println(a);

					}
				}
		
	}
	}
}
