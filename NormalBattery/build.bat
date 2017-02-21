"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IBattery.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\Battery.java

cd build
"%JAVA%\bin\jar" -cvf Battery.jar IBattery.class
"%JAVA%\bin\jar" -uvf Battery.jar Battery.class
"%JAVA%\bin\jar" -uvf Battery.jar Battery$Port.class

move Battery.jar ..\Battery.jar

pause