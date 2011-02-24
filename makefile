# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

mathclock.jar: Matheuhr.class
	jar -cfm mathclock.jar manifest.txt *.class

Matheuhr.class: *.java
	javac Matheuhr.java
