/*
	reference : http://silveiraneto.net/2008/03/15/simple-java-chronometer/
*/
public class Chronometer {
	 private long begin, end;
	 
	    public void start(){
	        begin = System.currentTimeMillis();
	    }
	 
	    public void stop(){
	        end = System.currentTimeMillis();
	    }
	 
	    public long getMilliseconds() {
	        return end-begin;
	    }
	 
	    public double getSeconds() {
	        return (end - begin) / 1000.0;
	    }
	 
}
