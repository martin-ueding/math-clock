# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

mathclock.jar: Matheuhr.class
	jar -cfm $@ manifest.txt *.class

Matheuhr.class: *.java
	javac Matheuhr.java

clean:
	rm -rf *.class *.jar
