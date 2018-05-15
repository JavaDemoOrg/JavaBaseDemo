

## 线程（Thread）

1、sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，   
即使调用sleep方法，其他线程也无法访问这个对象。   

2、yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。     
它跟sleep方法类似，同样不会释放锁。但是yield不能控制具体的交出CPU的时间，    
另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。    
注意，调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，    
它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。   

3、在Thread-1线程中，调用Thread-2的join方法，   
则Thread-1方法会等待Thread-2线程执行完毕或者等待一定的时间。   
join方法会让线程释放一个对象持有的锁。   



## 参考文献
[Java Thread 的使用](https://www.cnblogs.com/renhui/p/6066852.html)    

