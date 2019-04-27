消息摘要算法  
====
**消息摘要算法分为三类：**  
1.MD(Message Digest)：消息摘要  
2.SHA(Secure Hash Algorithm)：安全散列  
3.MAC(Message Authentication Code)：消息认证码  
这三类算法的主要作用：验证数据的完整性,消息摘要算法是有关于数字签名的核心算法  

MD
===
MD5(Message Digest algorithm 5，信息摘要算法)   
通常我们不直接使用MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串  
**MD算法家族：**  
生成的消息摘要都是128位的。  
包括：MD2，MD4，MD5  
从安全性上说：MD5 > MD4 > MD2  
**应用举例：**  
电驴（点对点的下载工具）使用的是经过改良的MD4的算法，这种改良后的MD4算法主要是  
用于通过P2P下载的文件截成块，分块之后进行摘要，通过摘要来验证所文件的最终的完整  
性，如果不完整是解压不开的。  
