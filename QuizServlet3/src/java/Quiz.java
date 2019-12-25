/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Quiz {
    private static String[] questions
            = {"3,1,4,1,5",//pi
                "1,1,2,3,5",//fibonacci
                "1,4,9,16,25",//squares
                "2,3,5,7,11",//primes
                "1,2,4,8,16"//powers of 2
            };
    private static int[] answers = {9, 8, 36, 13, 32};
    private int res;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String[] getQuestions() {
        return questions;
    }

    public static int[] getAnswers() {
        return answers;
        }
    
}
