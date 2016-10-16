mkdir out
javac -d out scans/Inputs.java scans/import_class.java
cd out
java scans.import_class
cd ..
