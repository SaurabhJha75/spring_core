# What is Spring Framework
Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications.

> Spring is a dependancy injection framwork to make java application loosely coupled and It makes the easy development of JavaEE application.

The first version of this framewok was developed by Rod Johnson in 2003.

# Dependency Injection
It is a design pattern that removes the dependancy of the program so that it can be easy to manage and test the application. 
Dependacy injection makes our programming code lossely coupled.

### Let's understand Dependancy Injection 
```java
class Ram{
    Geeta ob;
    pulic void doWork() {  

        //body
    }
}
```
```java
class Geeta {
    public void doWork(){

        //body
    }
}
```
>Here, **Ram** is dependent on **Geeta**. So, here Spring will create the object of *Geeta* and inject into class *Ram*. This is called the **Inversion of Control (IoC)**

## Inversion of Control Container (Dependency Injection)

IoC container is a design pattern that are used to remove the dependency from the program code.

It is responsible for managing object lifecycles of specific objects: creating these objects, calling their initialization methods and configuring these objects by wiring them together.

> The main tasks performed by IoC container are: 

*  to instantiate the application class
*  to configure the object
*  to assemble the dependencies between the objects

There are two types of IoC container: 
*   **ApplicationContext**
*   **BeanFactory**

> The interfaces BeanFactory and ApplicationContext represent the Spring IoC container. Here, BeanFactory is the root interface for accessing the Spring container. It provides basic functionalities for managing beans.

 On the other hand, the ApplicationContext is a sub-interface of the BeanFactory. Therefore, it offers all the functionalities of BeanFactory.

> Furthermore, it provides more enterprise-specific functionalities. The important features of ApplicationContext are resolving messages, supporting internationalization, publishing events, and application-layer specific contexts. This is why we use it as the default Spring container.

### There are three types of ApplicationContext
* **ClassPathXMLApplicationContext**

        It searches the xml configuration from java files.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/book-bean-config.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
* **AnnotationConfigApplicationContext**

        It searches the bean annotation where we  have use annotation for bean. It can take classes annotated with @Configuration, @Component.

        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);

        BookService bookService = context.getBean(BookService.class);

* **FileSystemXMLApplicationContext**
        
        It seraches the configuration file from the file system. We use the FileSystemXMLApplicationContext class to load an XML-based Spring configuration file from the file system or from URLs. This class is useful when we need to load the ApplicationContext programmatically.

        String path = "C:/myProject/src/main/resources/applicationcontext/book-bean-config.xml";

        ApplicationContext context = new FileSystemXmlApplicationContext(path);

        BookService bookService = context.getBean("bookService", BookService.class); 

## What is Spring Bean
 In Spring, a bean is an object that the Spring container instantiates, assembles, and manages.

As per Spring documentation in general, we should define beans for service layer objects, data access objects (DAOs), presentation objects, infrastructure objects such as Hibernate SessionFactories, JMS Queues, and so forth.

Also, typically, we shouldn't configure fine-grained domain objects in the container. It's usually the responsibility of DAOs and business logic to create and load domain objects.

Now let's define a simple Java class that we'll use as a Spring bean in this example:
```java
public class BookService {

  @Autowired
  private BookRepository bookRepo;

  // getters and setters
}
```
### Configuring beans in the container
As we know, the primary job of the **ApplicationContext** is to manage beans.

As such, an application must provide the bean configuration to the ApplicationContext container. A Spring bean configuration consists of one or more bean definitions. In addition, Spring supports different ways of configuring beans.

**Java-based Configuration**

First, we'll start with Java-based configuration as it's the newest and most preferred way of bean configuration. It's available from Spring 3.0 onward.

Java configuration typically uses @Bean-annotated methods within a @Configuration class. 

The @Bean annotation on a method indicates that the method creates a Spring bean. Moreover, a class annotated with @Configuration indicates that it contains Spring bean configurations.

Now let's create a configuration class to define our BookService class as a Spring bean:

```java
@Configuration
public class BookConfig {

  @Bean
  public BookService bookService() {
    return new BookService(bookRepo());
  }

  @Bean
  public BookService bookRepo() {
    return new BookRepository();
  }
}
```
**XML-based Configuration**

Finally, let's take a look at XML-based configuration. This is the traditional way of configuring beans in Spring.

Obviously, in this approach, we do all bean mappings in an XML configuration file.

So let's create an XML configuration file, book-bean-config.xml, and define beans for our BookService.class:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="
    http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd">
	  
  <bean id="bookService" class="com.saurabh.applicationcontext.BookService">
    <constructor-arg name="bookRepository" ref="bookRepository" />
  </bean>
	
  <bean id="bookRepository" class="com.saurabh.applicationcontext.BookRepository" />
</beans>
```
## Ways of Injecting Dependencies

*Dependency Injection Practical Explanation*: 
You can understand the whole explanation of dependecy injection from given image (pic_1.jpg) in project directory.

### Dependency injection can be done in two ways.
1. Using Setter Injection
2. Using Constructor Injection

## Dependency Injection by Setter method
We can inject the dependency by setter method also. The **Property** tag subelement of **Bean** tag is used for setter injection. 

Here we can inject the value three types of data type

- Primitive and String-based values
- Dependent object (contained object)
- Collection values etc.

>In Setter Injection method when IoC container creates the object of the **Student** class then it will call the setter method of the **Student** class.

### Let's see the emaxple

**Student.java**
```java
package com.spring.springcore;

public class Student {
	
	private int studentId;
	private String StudentName;
	private String studentAddress;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public Student(int studentId, String studentName, String studentAddress) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.studentAddress = studentAddress;
	}
	
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", StudentName=" + StudentName + ", studentAddress=" + studentAddress
				+ "]";
	}
}

```
**config.xml**
```xml
<?xml version="1.0" encoding="UTF-8"?>

-<beans xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd" xmlns:context="http://www.springframework.org/schema/context" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.springframework.org/schema/beans">

<!-- This is our bean -->

-<bean name="student1" class="com.spring.springcore.Student">

<property name="studentId" value="154239"/>

<property name="StudentName">
    <value>Saurabh Kumar Jha</value>
</property>

<property name="studentAddress">
    <value>Kolkata</value>
</property>

</bean>

<bean name="student2" class="com.spring.springcore.Student">

<property name="studentId" value="204385"/>

<property name="StudentName" value="John Wick"/>

<property name="studentAddress" value="Banglore"/>

</bean>

</beans>

```
**App.java**
```java
package com.spring.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student student1 = (Student) context.getBean("student1");

        Student student2 = (Student) context.getBean("student2");
        
        System.out.println(student2);
        System.out.println(student1);
    }
}

```
