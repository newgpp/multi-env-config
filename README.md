# mvnMultiEnvConfig
maven区分环境打包

intellij idea -> Execute Maven Goal (mvn clean package -P prod)

说明：

-P
P代表（Profiles配置文件） 在<profiles>指定的<id>中，可以通过-P进行传递或者赋值。 
打包时执行mvn clean package -P prod将触发prod环境的profile配置 打包时执行mvn clean package -P test将触发test环境的profile配置
假如pom.xml如下：
````
<profiles>
    <profile>
        <id>prod</id>
        ...
    </profile>
    <profile>
        <id>test</id>
        ...
    </profile>
</profiles>
````

-D代表（Properties属性）

假如pom.xml如下：
````
<properties>
    <attr>defaultattr</attr>
</properties>
````
执行mvn -Dattr=newattr clean package，则pom.xml内attr的实际值将被替换成newattr

命令行： mvn -DpropertyName=propertyValue clean package如果propertyName不存在pom.xml，它将被设置。 如果propertyName已经存在pom.xml，其值将被作为参数传递的值覆盖-D。 如果要发送多个变量，请使用多个空格分隔符加-D：
mvn -DpropA=valueA -DpropB=valueB -DpropC=valueC clean package