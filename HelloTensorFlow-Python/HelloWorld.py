"""
    TensorFlow Hello World example in Python

    Author: Antonio Tino
    Date: 01/05/2020

"""

#Import TensorFlow libraries
import tensorflow as tf

#Create a constant  called "msg"
msg = tf.constant("Hello World to TensorFlow")

#Create a session to run
sess = tf.Session()

#Print msg
print(sess.run(msg))