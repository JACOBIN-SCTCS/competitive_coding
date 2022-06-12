class Bank {
    
    long[] balance;
    public Bank(long[] balance) 
    {
        this.balance = balance;
    }
    
    public boolean checkValidAccount(int accNum) { 
        return (accNum>=1)&&(accNum<=this.balance.length);
    }
    public boolean transfer(int account1, int account2, long money) {
        
        if(!checkValidAccount(account1) || !checkValidAccount(account2))
            return false;
        if(this.balance[account1-1]<money){
            return false;
        }
        this.balance[account1-1]-= money;
        this.balance[account2-1]+= money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!checkValidAccount(account)){
            return false;
        }
        this.balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!checkValidAccount(account)){
            return false;
        }
         if(this.balance[account-1]<money){
            return false;
        }
        this.balance[account-1]-= money;
        return true;
        
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
