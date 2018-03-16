package loadFile;

/**
 * Created by huangbaoxian on 2018/3/16.
 */
public class LearningSpringBootExperience {

    /**
     *
     * 一   创建项目
     *
     * 2 选择spring initlalizer
     *
     * 3 选择web web
     *
     * 4 mvn clean install 下载依赖包
     *
     * 5 第一个helloworld控制器
     *
     * 5 mvn spring-boot:run 启动
     *
     *
     *
     *
     *
     * 二 ： jar包
     *
     * 查看是否存在依赖：
     *
     *
     *
     * <build>
         <plugins>
             <plugin>
                 <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
     </build>

     编译命令：mvn package

     查看jar包内容： jar tvf   target/myproject-0.0.1-SNAPSHOT.jar

     运行jar包： java -jar target/myproject-0.0.1-SNAPSHOT.jar






     三： 非继承方式实现

     <dependencyManagement>
         <dependencies>
            <!-- Override Spring Data release train provided by Spring Boot -->
            <dependency>
                <groupId>org.springframework.data</groupId>
                 <artifactId>spring-data-releasetrain</artifactId>
                 <version>Fowler-SR2</version>
                 <type>pom</type>
                 <scope>import</scope>
        </dependency>
        <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-dependencies</artifactId>
                 <version>2.0.0.RELEASE</version>
                 <type>pom</type>
                 <scope>import</scope>
         </dependency>
      </dependencies>
     </dependencyManagement>



     maven插件：用来打包jar文件

          <build>
                 <plugins>
                     <plugin>
                         <groupId>org.springframework.boot</groupId>
                         <artifactId>spring-boot-maven-plugin</artifactId>
                     </plugin>
                 </plugins>
          </build>





     *
     *
     * */


}
