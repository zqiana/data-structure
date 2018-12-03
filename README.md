# data-structure
数据结构相关
记录数据结构的学习过程

数组，链表

1. HashMap的使用
HashMap以键值对存储元素，如果遇到键值相同的则会新的Value覆盖旧的Value值；
2. HashMap的冲突问题是指会出现key值不一样hashcode值却一样，出现此种情况则是出现了hash冲突问题，这是HashMap的底层存储则会以链表形式存储元素，当取值时候则会遍历链表并调用key的equals方法定位元素，这是HashMap解决Hash冲突的方式； 
