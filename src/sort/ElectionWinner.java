package sort;

import java.util.Arrays;

/**
 * @author adasari
 */

public class ElectionWinner{

    public int whoWinTheElection(int[] in){
        int currentCandidate = in[0], winningCandidate = in[0];
        int currentVotes = 1, winnerVotes = 1;
        Arrays.sort(in);
        for(int i = 1; i < in.length; i++){
            if(in[i] == currentCandidate)
                currentVotes++;
            else{
                currentVotes = 1;
                currentCandidate = in[i];
            }
            if(currentVotes > winnerVotes){
                winnerVotes = currentVotes;
                winningCandidate = currentCandidate;
            }
        }
        return winningCandidate;
    }

    public void printArray(int[] in){
        if(in == null)
            return;
        System.out.print("[ ");
        for(int x: in){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        ElectionWinner obj = new ElectionWinner();
        int[] in = {1,3,3,3,2,2,2,1,2,2,2,1,2,3,3,3};
        obj.printArray(in);
        System.out.println("The Winner is: " + obj.whoWinTheElection(in));
    }
}