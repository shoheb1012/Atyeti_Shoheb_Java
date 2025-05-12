package com.variable.variablescope;

public class VariableScope {


    private int instanceVar;

    static int staticVar = 100;


    public VariableScope(int instanceVariable) {
        // Parameter Scope
        // using 'this' to refer to instance variable
        this.instanceVar = instanceVariable;
    }


    public void scopeOfVariable(int paramVariable) {

        //Local Variable accessible within Method
        int localVar = 20;

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
        System.out.println("Method Parameter: " + paramVariable);
        System.out.println("Local Variable: " + localVar);


        if (localVar == 20) {
            int blockVar = 5; // accessible within block only
            System.out.println("Block Variable: " + blockVar);
        }


         //System.out.println(blockVar); not in scope it gives a error :"Cannot resolve symbol 'blockVar'"
    }

    public static void main(String[] args) {
        VariableScope obj = new VariableScope(50);
        obj.scopeOfVariable(30);
    }
}