import java.util.ArrayList;

public class Algorithm {

    int linearSearch(int[] numbs, int target) {

        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] == target) {
                return i;
            }
        }
        return -1;
    }

    int binarySearch(int[] numbs, int target) {

        ArrayList<Integer> list = new ArrayList<>();

        int low = 0;
        int high = numbs.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;
            int value = numbs[mid];

            list.add(value);

            if(value < target){
                low = mid + 1;
            }else if(value > target){
                high = mid - 1;
            }else{
                IO.println("The # of steps taken: "+list.size());
                return mid;
            }
        }
        return -1;

    }

}
