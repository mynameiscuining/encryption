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
无政策限制权限文件是指：因为某些国家的进口管制限制，Java发布的运行环境包中的加解密有一定的限制。  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-aes.jpg)

PBE
===
PBE算法结合了消息摘要算法和对称加密算法的优点。  
PBE算法并不是新的算法，而是对已有的对称加密算法和消息摘要算法的整合。  
PBE(Password Based Encryption)：基于口令的加密  
口令是用户自己输入的，但通常口令不会很复杂。同时为了防止穷举的方式破解口令，还要对口令进行加盐（也就是在口令中加入随机数）。  
PBE算法实际上就是，采用口令替代了之前对称加密算法中生成的KEY  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-pbe1.jpg)  
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-pbe2.jpg)
![Image text](https://raw.githubusercontent.com/mynameiscuining/encryption/master/encryption-symmetry/symmetry-pbe3.jpg)





