# TensorFlow For Everyone
In this repository there are many TensorFlow examples in Python and Java.

### Install TensorFlow 
```
# Requires the latest pip
pip install --upgrade pip

#Enable env
python3 -m venv env
source ./env/bin/activate

# Install TensorFlow (CPU-only)
python -m pip install tensorflow

#Or with GPU support
python -m pip install tf-nightly
```

### Install TensorFlow for Java

* Add the dependency to the project's pom.xml file
```
<dependency>
  <groupId>org.tensorflow</groupId>
  <artifactId>tensorflow</artifactId>
  <version>1.15.0</version>
</dependency>
```
* For GPU support
```
<dependency>
  <groupId>org.tensorflow</groupId>
  <artifactId>libtensorflow</artifactId>
  <version>1.14.0</version>
</dependency>
<dependency>
  <groupId>org.tensorflow</groupId>
  <artifactId>libtensorflow_jni_gpu</artifactId>
  <version>1.14.0</version>
</dependency>
```

### Run Python code 
```
#Active env
source ./env/bin/activate

#Now, in env mode:
#Open project directory and run
python3 <file-name>.py
```
### Examples
1. Hello World in Python [(code)](https://github.com/antoniotino/TensorFlow-For-Everyone/blob/master/HelloTensorFlow-Python/HelloWorld.py)

1. Hello World in Java [(code)](https://github.com/antoniotino/TensorFlow-For-Everyone/blob/master/HelloTensorFlow/src/main/java/com/antoniotino/helloworld/HelloTensorFlow.java)

2. Graph operation in Python [(code)](https://github.com/antoniotino/TensorFlow-For-Everyone/blob/master/TensorFlowGraph-Python/Graph.py)
