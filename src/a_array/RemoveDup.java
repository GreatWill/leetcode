package a_array;


public class RemoveDup {

    /**
     * @Description:  去除已排序数组中重复元素,[1,1,2,3,4,4,5]->[1,2,3,4,5]
     *                不能有额外的空间
     *               返回新数组的长度
     * @Auther: chenjw
     * @Date: 2018/9/5 16:39
     */
    public int remove(int[] arr, int n){
        if(n == 0)
            return 0;
        int endIndex = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[endIndex] != arr[i]){
                arr[++endIndex] = arr[i];
            }

        }
        return endIndex+1;
    }

    /**
     * Description: 去除已排序数组中重复多余两个的元素,
     *              [1,1,1,2,2,3]->[1,1,2,2,3]
     *              不能有额外的空间
     *              返回新数组的长度
     * @auther: chenjw
     * @date: 2018/9/5 16:49
     */
    public int remove2(int[] arr, int n){
        if(n == 0)
            return 0;
        int endIndex = 0;
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[endIndex] != arr[i]){
                arr[++endIndex] = arr[i];
                count = 1;
            }else{
                if(count < 2){
                    count++;
                    endIndex++;
                }
            }

        }
        return endIndex+1;
    }


    public int remove2better(int[] arr, int n){
        if(n == 0)
            return 0;
        int index = 2;
        for(int i = 2; i < arr.length; i++){
            if(arr[index - 2] != arr[i]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index + 1;
    }



    /**
     * Description: 找到旋转对称数组中的旋转枢纽,否则返回-1
     *              [7,6,5,1,2,3,4]
     * @auther: chenjw
     * @date: 2018/9/5 17:16
     */
    public int findIndex(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right){
            if(a[mid] == target)
                return mid;
            if(a[left] < a[mid]){  //表示左边有序
                if(target > a[left] && target < a[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{                 //右边有序
                if(target > a[mid] && target < a[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return 0;
    }


    public void print(int[] arr){
        if(arr.length <= 0)
            return;
        for(int n : arr){
            System.out.print(n+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        //int res = new RemoveDup().remove(arr,5);
        int res = new RemoveDup().remove2(arr,5);
        new RemoveDup().print(arr);
        System.out.println(res);

    }

}
