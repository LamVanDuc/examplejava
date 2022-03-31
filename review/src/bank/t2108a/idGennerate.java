package bank.t2108a;

import java.util.concurrent.locks.ReentrantLock;

public class idGennerate {

    private static long id= 0L;
    private static ReentrantLock lock = new ReentrantLock();

    public static Long getNewID(){
        Long result;
        lock.lock(); // khai bien id lai chi cho duy nhat mot thread duoc truy xuat
        // tranh tinh trang DATA RACING;

        try {
            result = ++id; //  tang roi gan vao result
        }finally {
            lock.unlock();// tang roi thi mo lock cho thread khac cung truy cap

        }
        return  result;
    }
    private idGennerate(){}
}
