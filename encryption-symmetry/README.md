对称加密算法  
====
**基本介绍**  
对称加密算法是现在应用范围最广，使用频率最高的加密算法。  
对称的原理：   
加密密钥 = 解密密钥，加密运算是解密运算的逆运算。   
对称加密算法是初等的加密算法，从安全性上说，不是很高。  
常用的对称加密算法:DES(3DES)，AES，PBE，IDEA等。 

DES  
===
DES（Data Encryption Standard）：数据加密标准（已经被破解)  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-des.jpg)    

3DES
===
**3重DES的好处：**   
1. 密钥长度增强   
2. 迭代次数提高  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-3des.jpg)

AES
===
**产生的原因：**   
1. DES的算法有些漏洞   
2. 3DES的算法相对来说效率比较低  

AES是目前使用最多的对称加密算法。   
AES的优势之一是至今尚未被破解。   
AES通常用于移动通信系统加密以及基于SSH协议的软件（SSH Client，secureCRT）。  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-aes.jpg)

