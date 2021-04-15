import java.util.concurrent.*;

class FooBar
{
    private int n;
    Semaphore foosem = new Semaphore(1);
    Semaphore barsem = new Semaphore(1,false);
    
    public FooBar(int n) {
        this.n = n;
       
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            foosem.acquire();
        	printFoo.run();
            barsem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            barsem.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foosem.release();
        }
    }
}
