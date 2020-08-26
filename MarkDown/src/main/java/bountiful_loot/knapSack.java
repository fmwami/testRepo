package bountiful_loot;

class knapSack {


    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }


    static int knapSack(
            int W, int wi[],
            int vi[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;


        if (wi[n - 1] > W)
            return knapSack(W, wi, vi, n - 1);


        else
            return max(
                    vi[n - 1] + knapSack(W - wi[n - 1],
                            wi, vi, n - 1),
                    knapSack(W, wi, vi, n - 1));
    }


    public static void main(String args[])
    {
        int vi[] = new int[] { 60, 100, 120 };
        int wi[] = new int[] { 10, 20, 30 };
        int W = 10;
        int n = vi.length;
        System.out.println(knapSack(W, wi, vi, n));
    }
}
