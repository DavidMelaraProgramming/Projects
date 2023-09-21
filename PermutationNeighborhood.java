
/**
 * Iterator class, allows traversal of the set of neighbors
 * of given permutation. There will be n(n-1)/2 neighbors,
 * obtained by swapping all pairs of elements in the permutation.
 * There are n(n-1)/2 neighbors because half of the tours are repeated 
 * but in the opposite order
 */
public class PermutationNeighborhood
{

    private final int[] p; //permutation
    private final int SIZE; //size of permutation
    private int loc1; //loc1 and loc2 are the locations of
    private int loc2; //p that will be swapped next

    /**
     * Initializes permutation of this object and locations
     * whose values will be swapped.
     *
     * @param a permutation whose neighborhood is to be generated
     */
    public PermutationNeighborhood(int[] a)
    {
        //TO IMPLEMENT
                SIZE  = a.length;

                p = new int[SIZE];

                System.arraycopy(a,0,p,0,SIZE);

                loc1 = 0;

                loc2 = 1;


    }

    /**
     * Returns true if at least a neighbor remains to be generated; false
     * otherwise.
     */
    public boolean hasNext()
    {
        //TO IMPLEMENT

        return loc1 != SIZE - 1;

    }

    /**
     * Returns next permutation neighbor.
     *
     * @return next permutation neighbor, if one exists; null otherwise
     */
    public int[] next()
    {
        //TO IMPLEMENT

        if(hasNext()) {

            int [] a = new int[SIZE];

            System.arraycopy(p,0,a,0,SIZE);

            a[loc1] = p[loc2];

            a[loc2] = p[loc1];

            if(loc2 == SIZE - 1) {

                loc1++;

                loc2 = loc1 + 1;

            } else {
                loc2++;
            }
                return a;


        } else

            return null;

    }

}