## Sample Blog App
* Java Version  : "1.8.0_231"
* MySQL Version : "10.4.11-MariaDB" 

* Kullanılan Teknolojiler :
    * Spring Boot
    * MySQL
    * JavaMail
    * Spring Security
    * Hibernate
    
* Yürütme Komutu
    * application.properties 
        * dosyasındaki datasource ve smtp ayarları güncellenebilir.
        * mvn spring-boot:run
         
    * ya da aşağıdaki şekilde mvn'a parametre geçilerek yürütülebilir.
        * mvn spring-boot:run
        -Dspring.datasource.url="jdbc:mysql://localhost:3306/tutorial_blog"
        -Dspring.datasource.username="root" 
        -Dspring.datasource.password="welcome2"     

### Screenshots
