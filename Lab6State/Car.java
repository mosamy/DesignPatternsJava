public class Car{
    public int changeSpeed(int speed){
	    if (speed == 0) {
	        return 0;
	    } else {
	        if (speed > 0 && speed < 10) {
	            return 1;
	        } else {
	            if (speed > 10 && speed < 20) {
	                return 2;
	            } else {
	                if (speed > 20 && speed < 40) {
	                    return 3;
	                } else {
	                    if (speed > 40 && speed < 60) {
	                        return 4;
	                    } else {
	                        if (speed > 55 ) {
	                            return 5;
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return 0;
    }
}
    
