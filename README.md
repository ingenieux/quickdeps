# quickdeps

quickdeps simply scans jar files for META-INF/maven**/pom.properties and/or its sha1 on [search.maven.org](https://search.maven.org/)
 
If it finds, it returns the suitable ```<dependency/>``` tag, thus making it easy for one to quickly import a project.

## how to use it?

simply download ```bin/quickdeps``` on this repo, or:

```
$ mvn -Pexec-jar package
```

Hope it helps!
