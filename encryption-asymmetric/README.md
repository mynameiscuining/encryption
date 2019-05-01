非对称加密
====
公钥和私钥一般是成对出现的，使用公钥加密的数据只有与它对应的私钥才能解开。   
在非对称加密算法中有一些算法是可以公钥加密私钥解密，私钥加密公钥解密都支  
持的，有一些算法只支持一种方式的。  

**非对称加密算法种类：**   
DH(Diffie-Hellman)：密钥交换算法   
RSA：基于因子分解，既能用于数字加密也能用于数字签名   
Elgamal：基于离散对数   
ECC（Elliptical Curve Cryptography）：椭圆曲线加密  

**工作原理:**   
1.A要向B发送信息，A和B都要产生一对用于加密和解密的公钥和私钥。  
2.A的私钥保密，A的公钥告诉B；B的私钥保密，B的公钥告诉A。  
3.A要给B发送信息时，A用B的公钥加密信息，因为A知道B的公钥。  
4.A将这个消息发给B（已经用B的公钥加密消息）。  
5.B收到这个消息后，B用自己的私钥解密A的消息。其他所有收到这个报文的人都无法解密，因为只有B才有B的私钥  

DH  
===
对称加密算法的弊端： 
对称加密算法中公布密钥这个步骤会有问题，发送密钥的时候可能会出现泄露密钥的情况。  
一旦密钥被泄露，那么所有的数据就很容易被破解掉。但是DH(密钥交换算法)是通过构建  
本地密钥来解决密钥容易在传递中泄露的问题的。   
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-asymmetric/asymmetric-dh.jpg)

**初始化发送方密钥涉及的三个类：**   
1. KeyPairGenerator（通过KeyPairGenerator来得到KeyPair类的对象）  
//创建KeyPairGenerator对象  
KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");//"DH"指定算法的名称  

2. KeyPair(得到密钥对，包括公钥和私钥)   
3. PublicKey：公钥  

**初始化接收方密钥涉及到的类：**   
1. KeyFactory：作用是生成密钥（包括公钥和私钥）   
generatePublic()方法用来生成公钥   
generatePrivate()方法用来生成私钥  

2. X509EncodedKeySpec：根据ASN.1标准进行密钥编码   
3. DHPublicKey：是PublicKey的某种具体的形式   
4. DHParameterSpec：随从着DH算法来使用的参数的集合   
5. KeyPairGenerator：通过KeyPairGenerator来得到KeyPair类的对象   
6. PrivateKey：私钥  

**密钥构建涉及的类**  
1. KeyAgreement：提供密钥一致性（或密钥交换）协议的功能    
//生成实现指定密钥一致算法的KeyAgreement对象    
static keyAgreement getInstance(String algorithm)    

//为来自指定提供程序的指定密钥一致算法生成一个KeyAgreement对象  
static keyAgreement getInstance(String algorithm,Provider provider)  
2. SecretKey：生成一个分组的秘密密钥，同时提供了相应的类型安全的操作   
3. KeyFactory   
4. X509EncodedKeySpec   
5. PublicKey  

**加解密涉及到的类：**   
Cipher  

