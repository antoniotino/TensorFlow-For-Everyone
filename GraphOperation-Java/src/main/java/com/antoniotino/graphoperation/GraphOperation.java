package com.antoniotino.graphoperation;

/**
 *      ->  TensorFlow Graph example in Java  <-
 *      
 *      Consider the follow expression:  a = (b+c) * (c+2)
 *      We can break this function down into the following components:
 *          x = b + c
 *          y = c + 2
 *   		a = x * y
 * 
 *      Author: Antonio Tino
 *      Date: 01/07/2020
*/

import org.tensorflow.*;

public class GraphOperation{
    public static void main( String[] args ) throws Exception{

        //Start: declare and initialize the graph
        try(Graph graph = new Graph()){

            //First step: defining the constant
            Operation two = graph.opBuilder("Const", "two")
            .setAttr("dtype", DataType.fromClass(Double.class))
            .setAttr("value", Tensor.<Double>create(2.0, Double.class))
            .build();

            //Second step: defining variables (b and c)
            Operation b = graph.opBuilder("Placeholder", "b")
            .setAttr("dtype", DataType.fromClass(Double.class))
            .build(); 

            Operation c = graph.opBuilder("Placeholder", "c")
            .setAttr("dtype", DataType.fromClass(Double.class))
            .build();
            
            /*Now, defining the functions/mathematical operations:
            *   x = b + c
            *   y = c + 2
            *   a = x * y
            */
            Operation x = graph.opBuilder("Add", "x")
            .addInput(b.output(0))
            .addInput(c.output(0))
            .build();

            Operation y = graph.opBuilder("Add", "y")
            .addInput(c.output(0))
            .addInput(two.output(0))
            .build();

            Operation a = graph.opBuilder("Mul", "a")
            .addInput(x.output(0))
            .addInput(y.output(0))
            .build();
        
            //Now, defining a Session to run the Graph
            try (Session session = new Session(graph);
                //Run
                Tensor<Double> tensor = session.runner()
                .fetch("a")
                .feed("b", Tensor.<Double>create(3.0, Double.class))
                .feed("c", Tensor.<Double>create(6.0, Double.class))
                .run().get(0).expect(Double.class);
            ){  
            
            //Output
            System.out.println(tensor.doubleValue());
            }
        }
    }
}
