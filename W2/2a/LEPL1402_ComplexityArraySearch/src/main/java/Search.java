
public class Search {

    /**
     *
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem){
        int low = 0;
        int top = tab.length;
        while (low <= top){
            int mid = (low + top)/2;
            if(tab[mid] > elem){
                top = mid - 1;
            }
            else if (tab[mid] < elem){
                low = mid + 1;
            }
            else return mid;
        }
        return -1;
    }
}
