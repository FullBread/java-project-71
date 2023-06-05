run-dist:
	./app/build/install/app/bin/app

run-dist-valid:
	./app/build/install/app/bin/app ./app/src/main/resources/file1.json ./app/src/main/resources/file2.json

report:
	./app/gradlew jacocoTestReport

test:
	./app/gradlew test

build:
	./app/gradlew build



.PHONY: build