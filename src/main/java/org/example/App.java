package org.example;

import service.ReceiveInput;

/**
 * Hello world!
 *
 */
public class App 
{
    private final ReceiveInput receiveInputObj;
    public App() {
        this.receiveInputObj = new ReceiveInput();
    }

    public void start() {
        receiveInputObj.start();
    }
    public static void main( String[] args )
    {
        App obj = new App();
        obj.start();
    }

}
