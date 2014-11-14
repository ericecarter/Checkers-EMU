/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

/**
 *
 * @author Eric Eugene Carter
 */
public class Node {
    char [] np; // new position char array

    public char[] getNp() {
        return np;
    }

    public void setNp(char[] np) {
        this.np = np;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
    int start;  // starting position for the checker
    int finish; // final position for the checker
    
    public Node (char[] np, int start, int finish){
        this.np = np;
        this.start = start;
        this.finish = finish;
    }
    
    @Override
    public String toString(){
        String array = "";
        for (int i = 0; i<32; i++){
            array+=np[i];
        }
        return array + " " + this.start + " " + this.finish;
    }
}
