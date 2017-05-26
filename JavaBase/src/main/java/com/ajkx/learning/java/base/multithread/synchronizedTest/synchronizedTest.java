package com.ajkx.learning.java.base.multithread.synchronizedTest;

/**
 * Created by ajkx
 * Date: 2017/5/26.
 * Time:14:48
 */
public class synchronizedTest extends Thread{

    private Account account;

    private double amount;

    public synchronizedTest(String name,Account account, double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.draw(5000);
//        synchronized (account){
//            if (account.getBalance() > amount) {
//                System.out.println(getName() + "取钱成功！吐出钞票：" + amount);
//
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                account.setBalance(account.getBalance() - amount);
//                System.out.println("\t余额为："+account.getBalance());
//            }else{
//                System.out.println(getName() + "取钱失败！余额不足");
//            }
//        }
    }

    public static void main(String[] args) {
        Account account = new Account("aa", 10000);
        new synchronizedTest("Thread1", account, 5000).start();
        new synchronizedTest("Thread2", account, 6000).start();

//        account.draw(5000);
//        account.draw(6000);
    }
}
