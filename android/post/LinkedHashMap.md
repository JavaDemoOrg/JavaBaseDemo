
### LinkedHashMap       
1、HashMap 是一个无序的 Map，       
因为每次根据 key 的 hashcode 映射到 Entry 数组上，        
所以遍历出来的顺序并不是写入的顺序        
2、LinkedHashMap 是基于 HashMap 的，    
 但具有顺序，解决了有排序需求的场景          
3、它的底层是继承于 HashMap，由一个双向链表所构成。      
4、LinkedHashMap 的排序方式有两种：        
根据写入顺序排序。   
根据访问顺序排序。   
5、其中根据访问顺序排序时，每次 get 都会将访问的值移动到链表末尾，    
这样重复操作就能的到一个按照访问顺序排序的链表。     

### 总结
总的来说 LinkedHashMap 其实就是对 HashMap 进行了拓展，使用了双向链表来保证了顺序性。   
因为是继承与 HashMap 的，所以一些 HashMap 存在的问题 LinkedHashMap 也会存在，比如不支持并发等。   

### 参考文献         
1、[LinkedHashMap底层分析](https://github.com/crossoverJie/Java-Interview/blob/master/MD/collection/LinkedHashMap.md)     
2、       
