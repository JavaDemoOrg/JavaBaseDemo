
## synchronized 修饰符     

### 修饰一个代码块     
1、[DoSyncThread]      
一个线程访问一个对象中的synchronized(this)同步代码块时，      
其他试图访问该对象的线程将被阻塞。        

2、[DoUnSyncThread]       
当一个线程访问对象的一个synchronized(this)同步代码块时，        
另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。        

3、[DoLockObject]     
指定要给某个对象加锁   
零长度的byte数组对象创建起来将比任何对象都经济，   
查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，   
而Object lock = new Object()则需要7行操作码。   

### 修饰一个方法
1、在定义接口方法时不能使用synchronized关键字；   
2、构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步；

### 修饰一个静态的方法
1、静态方法是属于类的而不属于对象的；    
2、synchronized修饰的静态方法锁定的是这个类的所有对象；     
3、该类的所有对象访问该同步静态方法都是同步的；      

### 修饰一个类
1、synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的都是同一把锁；

### 总结  
1、无论synchronized关键字加在方法上还是对象上，        
如果它作用的对象是非静态的，则它取得的锁是对象；       
如果synchronized作用的对象是一个静态方法或一个类，      
则它取得的锁是类，该类所有的对象同一把锁。       

2、每个对象只有一个锁（lock）与之相关联，     
谁拿到这个锁谁就可以运行它所控制的那段代码。    

3、实现同步是需要很大的系统开销作为代价的，甚至可能造成死锁，    
所以尽量避免无谓的同步控制。     

### 参考资料      
[Java中Synchronized的用法](https://blog.csdn.net/luoweifu/article/details/46613015)      


