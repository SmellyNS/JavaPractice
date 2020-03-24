package com.mycompany.practice;

class ArrOper {
    
    private double[] array;
    private int count;
    
    
    public static ArrOper construct(int n, boolean prime){
        
        ArrOper arr = new ArrOper();
        double[] array = new double[n];
        
        arr.array = array;
        arr.count = n;
        
        if (prime) arr.construct_prime();
        else arr.construct_nonprime();
        
        return arr;
    }
    
    private void construct_prime(){
        int saved = 2;
        this.array[0] = 1;
        if (this.count > 1) this.array[1] = 2;
        for (int i = 1; saved < this.count; i++){
            for (int j = 2; j < i; j++){
                if(i%j == 0) break;
                if(j == i - 1){
                    this.array[saved] = i;
                    saved++;
                }
            }
        }
        
    }
    
    private void construct_nonprime() {
        for (int i = 0; i < this.count; i++){
            this.array[i] = Math.random();
        }
    }
    
    
    
    
    public void print(){
        for(double elem : this.array){
            System.out.print(String.format("%2f   ", elem));
        }
        System.out.println();
    }
    
    public double max(){
        double r = this.array[0];
        for (double elem : this.array){
            r = elem > r ? elem : r;
        }
        return r;
    }
    
    public double min(){
        double r = this.array[0];
        for (double elem : this.array){
            r = elem < r ? elem : r;
        }
        return r;
    }
    
    public double avg(){
        double sum = 0;
        for (double elem : this.array){
            sum += elem;
        }
        return sum/this.count;
    }
    
    public void sort() {
        for (int i = 0; i < this.count; i++) {
            for (int j = 0; j < this.count - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    double temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                }
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {
        ArrOper arr = ArrOper.construct(15, true);
        arr.print();
        
        ArrOper arr2 = ArrOper.construct(10, false);
        arr2.print();
        /*
        System.out.println(arr.max());
        System.out.println(arr.min());
        System.out.println(arr.avg());
        arr.sort();
        arr.print();
        */
    }
    
    
}
