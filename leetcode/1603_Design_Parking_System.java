class ParkingSystem {

    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) 
    {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType)
        {
            case 1:
                if(big - 1 >=0)
                {
                    big-=1;
                    return true;
                }
                else
                {
                    return false;
                }
            case 2:
                if(medium - 1 >=0)
                {
                    medium-=1;
                    return true;
                }
                else
                {
                    return false;
                }
            case 3 :
                if(small - 1 >=0)
                {
                    small-=1;
                    return true;
                }
                else
                {
                    return false;
                } 
            default:
                return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
