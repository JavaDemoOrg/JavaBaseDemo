
## 多线程并发     

### 1、CountDownLatch     
1、CountDownLatch latch = new CountDownLatch(N); // 构造对象时候需要传入参数N；           
2、latch.await()能够阻塞线程直到调用N次latch.countDown()方法才释放线程；              
3、latch.countDown()可以在多个线程中调用，计算调用次数是所有线程调用次数的总和；      





## 参考文献
1、[CountDownLatch 使用说明](https://www.cnblogs.com/cuglkb/p/8572239.html)    
2、[AtomicInteger类的理解与使用](https://blog.csdn.net/u012734441/article/details/51619751)     



