数字签名算法
====
签名：就有安全性，抗否认性   
数字签名：带有密钥（公钥，私钥）的消息摘要算法   
作用：   
1. 验证数据的完整性   
2. 认证数据来源   
3. 抗否认  

数字签名遵循：私钥签名，公钥验证   
常用的数字签名算法：RSA，DSA，ECDSA  

RSA
===
介绍：   
是经典算法，是目前为止使用最广泛的数字签名算法。  
RSA数字签名算法的密钥实现与RSA的加密算法是一样的，算法的名称都叫RSA。密钥的产生和转换都是一样的。  
RSA数字签名算法主要包括MD和SHA两类。  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-digital-signature/rsa.jpg)  

DSA
===
**介绍：**   
DSS(Digital Signature Standard)：数字签名标准   
在DSS的基础上逐渐形成了DSA算法。   
DSA(Digital Signature Algorithm)：数字签名算法  

**DSA与RSA的区别：**   
DSA仅包含数字签名，使用DSA这种算法的证书是没法进行加密通信的。   
但是RSA既包含数字签名算法，也包含加解密。  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-digital-signature/dsa.jpg)  

ECDSA
=== 
**介绍：**    
微软产品的序列号验证算法使用的就是ECDSA。  
ECDSA(Elliptic Curve Digital Signature Algorithm)：椭圆曲线数字签名算法  
优点：   
与传统的数字签名算法相比，速度快，强度高，签名短。 
用java的jdk里面相关方法实现ECDSA的签名及签名验证,要jdk7.x以上，ECDSA：椭圆曲线数字签名算法   
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-digital-signature/ecddsa.jpg)  



