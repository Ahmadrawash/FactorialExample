import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args)
    {
        int[] arr = {2, 30, 1, 5, 6};
        System.out.println("length is: " + lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i ++)
            sequence.add(nums[i]);
        List<Integer> longest = new ArrayList<>();
        return longestsubsequent(sequence,  new ArrayList<Integer>(), new ArrayList<Integer>(), 0);
    }

    public static int longestsubsequent(List<Integer> current, List<Integer> included, List<Integer> left, List<Integer> longest)
    {
        if (left.size() == 0)
            return  0;

        System.out.println("array: " + longest.toString());

        if (current.get(included.size()+1) > included.get(included.size()))
        {
            included.add(current.get(included.size()+1));
        }
            int includeSize =  longestsubsequent(current, included, left, longest);
             int ExcludedSize =  longestsubsequent(current, included, left, longest);

            if (includeSize > excludeSize)
                return includeSize;
            else
                return excludeSize;
        }

    }
}