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

SHA：  
===
**介绍:**  
安全散列算法  
固定长度摘要信息  
包括：SHA-1，SHA-2(SHA-224，SHA-256，SHA-384，SHA-512)  
bouncy castle提供了所有的SHA消息摘要算法，其中SHA-224消息摘要算法是JDK中没有提供的。  
common codes只是对JDK提供的SHA消息摘要算法进行了简化。  

**SHA-1与MD5的比较**  
因为二者均由MD4导出，SHA-1和MD5彼此很相似。相应的，他们的强度和其他特性也是相似，  
但还有以下几点不同：  
1. 对强行攻击的安全性：最显著和最重要的区别是SHA-1摘要比MD5摘要长32 位。使用强行技术，    
产生任何一个报文使其摘要等于给定报摘要的难度对MD5是2^128数量级的操作，而对SHA-1则是    
2^160数量级的操作。这样，SHA-1对强行攻击有更大的强度。    
2. 对密码分析的安全性：由于MD5的设计，易受密码分析的攻击，SHA-1显得不易受这样的攻击。  
3. 度：在相同的硬件上，SHA-1的运行速度比MD5慢。  

HMAC  
===
介绍：  
HMAC(keyed-Hash Message Authentication Code)：含有密钥的散列函数算法  
包含了MD和SHA两个系列的消息摘要算法  
HMAC只是在原有的MD和SHA算法的基础上添加了密钥。  
融合了MD,SHA：  
MD系列：HmacMD2，HmacMD4，HmacMD5  
SHA系列：HmacSHA1，HmacSHA224，HmacSHA256，HmacSHA38，HmacSHA512  

HMAC(Hash Message Authentication Code)，散列消息鉴别码，基于密钥的Hash算  
法的认证协议。消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度  
的值作为认证标识，用这个标识鉴别消息的完整性。使用一个密钥生成一个固定大小  
的小数据块，即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的  
密钥进行鉴别认证等。  




