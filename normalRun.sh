pushd thisIsAnImportantApp
./gradlew shadowJar
popd
pushd shadowStuff
./gradlew shadowJar
popd

echo Run with java jar
java -jar thisIsAnImportantApp/app/build/libs/myApp.jar
echo run with classpath
java -cp thisIsAnImportantApp/app/build/libs/myApp.jar org.example.App
echo run classpath with app coming first
java -cp thisIsAnImportantApp/app/build/libs/myApp.jar:shadowStuff/lib/build/libs/shadow.jar org.example.App
echo run classpath with shadow first
java -cp shadowStuff/lib/build/libs/shadow.jar:thisIsAnImportantApp/app/build/libs/myApp.jar org.example.App
