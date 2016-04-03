# quickdeps

quickdeps simply scans jar files for META-INF/maven**/pom.properties and/or its sha1 on [search.maven.org](https://search.maven.org/)
 
If it finds, it returns the suitable ```<dependency/>``` tag, thus making it easy for one to quickly import a project.

## how to use it?

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
