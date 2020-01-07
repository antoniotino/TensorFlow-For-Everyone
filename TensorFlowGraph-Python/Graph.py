"""
    ->  TensorFlow Graph example in Python  <-
    	
    	Consider the follow expression:  a = (b+c) * (c+2)
    	We can break this function down into the following components:
    		d = b + c
    		e = c + 2
    		a = d * e
"""
#Import TensorFlow libraries
import tensorflow as tf

"""
first, create a TensorFlow constant
1° parameter: value of the constant
2° parameter: name string (optional)
"""
const = tf.constant(2.0, name="const")

"""
create TensorFlow variables
1° parameter: value of the variables
2° parameter: name string (optional)
"""
b = tf.Variable(2.0, name='b')
c = tf.Variable(1.0, name='c')

#create operations
d = tf.add(b, c, name='d')
e = tf.add(c, const, name='e')
a = tf.multiply(d, e, name='a')

#setup the variable initialisation
init_op = tf.global_variables_initializer()

# start the session
with tf.Session() as sess:
    #initialise the variables
    sess.run(init_op)
    
    """
    compute the output of the graph

    Note: a is an operation, not a variable and it can be run
    """
    a_out = sess.run(a)
    
    #output
    print("Variable a is {}".format(a_out))