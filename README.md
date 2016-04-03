# quickdeps

quickdeps simply scans jar files for META-INF/maven**/pom.properties and/or its sha1 on [search.maven.org](https://search.maven.org/)
 
If it finds, it returns the suitable ```<dependency/>``` tag, thus making it easy for one to quickly import a project.

## Usage

Practical example (repo: [benmfaul/XRTB](https://github.com/benmfaul/XRTB), [rtb4free](http://www.rtb4free.com)):

```
$ quickdeps libs/*.jar
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-annotations</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty.cdi</groupId><artifactId>cdi-core</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-databind</artifactId><version>2.4.4</version><type>bundle</type></dependency>
<dependency><groupId>org.slf4j</groupId><artifactId>slf4j-simple</artifactId><version>1.7.10</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-plus</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.antlr</groupId><artifactId>stringtemplate</artifactId><version>3.2.1</version></dependency>
<dependency><groupId>org.eclipse.jetty.cdi</groupId><artifactId>cdi-servlet</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-client</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-jaas</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.ow2.asm</groupId><artifactId>asm</artifactId><version>4.2</version></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-databind</artifactId><version>2.4.4</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-http</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.slf4j</groupId><artifactId>slf4j-api</artifactId><version>1.7.10</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-util</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>reflectasm</artifactId><version>1.10.0</version></dependency>
<dependency><groupId>redis.clients</groupId><artifactId>jedis</artifactId><version>2.8.0</version></dependency>
<dependency><groupId>org.hamcrest</groupId><artifactId>hamcrest-library</artifactId><version>1.3</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-rewrite</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-jndi</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.thoughtworks.qdox</groupId><artifactId>qdox</artifactId><version>1.12</version></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-core</artifactId><version>2.4.4</version><type>bundle</type></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-jaspi</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-security</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.hamcrest</groupId><artifactId>hamcrest-core</artifactId><version>1.3</version></dependency>
<dependency><groupId>org.objenesis</groupId><artifactId>objenesis</artifactId><version>2.1</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-servlet</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-annotations</artifactId><version>2.4.0</version></dependency>
<dependency><groupId>org.apache.httpcomponents</groupId><artifactId>httpcore</artifactId><version>4.4.4</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-jmx</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty.toolchain</groupId><artifactId>jetty-schemas</artifactId><version>3.1.M0</version></dependency>
<dependency><groupId>javax.servlet</groupId><artifactId>javax.servlet-api</artifactId><version>3.1.0</version></dependency>
<dependency><groupId>io.netty</groupId><artifactId>netty-all</artifactId><version>4.0.34.Final</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-quickstart</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-webapp</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty.cdi</groupId><artifactId>cdi-websocket</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>kryo</artifactId><version>3.0.0</version><type>bundle</type></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>minlog</artifactId><version>1.3.0</version><type>bundle</type></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-core</artifactId><version>2.4.4</version></dependency>
<dependency><groupId>org.redisson</groupId><artifactId>redisson</artifactId><version>2.2.9-SNAPSHOT</version></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>reflectasm</artifactId><version>1.10.0</version><type>bundle</type></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-nosql</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-servlets</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-proxy</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>kryo</artifactId><version>3.0.0</version></dependency>
<dependency><groupId>com.esotericsoftware</groupId><artifactId>minlog</artifactId><version>1.3.0</version></dependency>
<dependency><groupId>jline</groupId><artifactId>jline</artifactId><version>2.12</version></dependency>
<dependency><groupId>commons-logging</groupId><artifactId>commons-logging</artifactId><version>1.2</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-continuation</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.apache.devicemap</groupId><artifactId>devicemap-data</artifactId><version>1.0.3</version></dependency>
<dependency><groupId>junit</groupId><artifactId>junit</artifactId><version>4.11</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-server</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.apache.devicemap</groupId><artifactId>devicemap-client</artifactId><version>1.1.0</version></dependency>
<dependency><groupId>org.hamcrest</groupId><artifactId>hamcrest-all</artifactId><version>1.3</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-deploy</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-infinispan</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>com.google.code.gson</groupId><artifactId>gson</artifactId><version>2.4</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-io</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>commons-codec</groupId><artifactId>commons-codec</artifactId><version>1.5</version></dependency>
<dependency><groupId>org.jmockit</groupId><artifactId>jmockit</artifactId><version>1.12</version></dependency>
<dependency><groupId>org.apache.commons</groupId><artifactId>commons-pool2</artifactId><version>2.4.2</version></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-alpn-server</artifactId><version>9.3.1.v20150714</version></dependency>
<dependency><groupId>org.apache.httpcomponents</groupId><artifactId>httpclient</artifactId><version>4.5.2</version></dependency>
<dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-annotations</artifactId><version>2.4.0</version><type>bundle</type></dependency>
<dependency><groupId>org.eclipse.jetty</groupId><artifactId>jetty-xml</artifactId><version>9.3.1.v20150714</version></dependency>
```

## Why?

Because I'm lazy. Converting mass codebases to Maven really is made easy by using quickdeps. :)

## how to install it?

simply download ```bin/quickdeps``` on this repo:

```
$ curl -sSL https://raw.githubusercontent.com/ingenieux/quickdeps/bin/quickdeps > ~/bin/quickdeps
```

or:

```
$ git clone https://github.com/ingenieux/quickdeps.git && cd quickdeps
$ mvn -Pexec-jar package
```

Hope it helps!
