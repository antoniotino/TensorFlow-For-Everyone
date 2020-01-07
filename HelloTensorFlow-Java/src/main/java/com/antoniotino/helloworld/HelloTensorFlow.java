package com.antoniotino.helloworld;

import org.tensorflow.Graph;
import org.tensorflow.TensorFlow;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

/**
 * TensorFlow Hello World example in Java
 * 
 * Author: Antonio Tino
 * Date: 01/06/2020
 */
public class HelloTensorFlow {

    public static void main(String[] args) throws Exception {

        try (Graph graph = new Graph()) {

            // Create a msg
            final String msg = "Hello World to TensorFlow version " + TensorFlow.version();

            /**
             * Construct the computation graph with a single operation a constant named
             * "MyConst" with a value "msg"
             */
            try (Tensor tensor = Tensor.create(msg.getBytes("UTF-8"))) {
                graph.opBuilder("Const", "MyConst").setAttr("dtype", tensor.dataType())
                .setAttr("value", tensor).build();
            }

            // Execute the "MyConst" operation in a Session
            try (Session s = new Session(graph);
                /**
                * There may be multiple output tensors, all of them must be closed  to prevent resource leaks.
                */
                Tensor output = s.runner().fetch("MyConst").run().get(0)
                ) {
                    System.out.println(new String(output.bytesValue(), "UTF-8"));
                }
        }
    }
}