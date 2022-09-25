import java.util.Arrays;
public class myVector {

    private int size = 0;
    private int max_size;
    public double[] arr = new double[1];
    public myVector(int max_size){
        this.max_size = max_size;
        arr = Arrays.copyOf(arr, max_size);
    }
    public myVector(){
        try {
            max_size = 2 * size + 10;
            arr = Arrays.copyOf(arr, max_size);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error");
        }
    }
    public void adding_to_end(double element) {
        try {
            if (size < max_size && size != 0) {
                arr[size] = element;
                size++;
            } else if (size == 0) {
                arr[size] = element;
                size++;
            } else if (size == max_size) {
                max_size++;
                arr = Arrays.copyOf(arr, max_size);
                arr[size] = element;
                size++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error in the array");
        }catch (ArrayStoreException e){
            System.out.print("Invalid value sent");
        }
    }
    public  void copy_arr(myVector original){
        try {
            max_size = original.max_size;
            arr = Arrays.copyOf(arr, max_size);
            arr = original.arr;
            size = original.size;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error in the array");
        }catch (ArrayStoreException e){
            System.out.print("Invalid value sent");
        }
    }
    public void del_to_end(){
        try {
            arr[size] = 0;
            size--;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error in the array");
        }
    }
    public void del_to_index(int index){
        try {
            if(index == 0){
                arr = Arrays.copyOfRange(arr,1,max_size);
            }else if(index <= size && index != (max_size - 1)) {
                double[] arr_2 = Arrays.copyOfRange(arr, 0, index);
                double[] arr_3 = Arrays.copyOfRange(arr,index + 1 , max_size );
                arr = Arrays.copyOf(arr_2,max_size);
                for (int i = index,  j = 0; i < max_size -1 ; i++, j++){
                    arr[i] = arr_3[j];
                }
            }else if(index == max_size - 1){
                arr[index] = 0;
                size--;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error in the array" + e.getMessage());
        }catch (ArrayStoreException  e){
            System.out.print("Invalid value sent" + e.getMessage());
        }

    }
    public void insert_index(int index, double element){
        try {
            if(index < max_size && index > -1){
                arr[index] = element;
                size++;
            }else if(index >= max_size){
                max_size = index + 1;
                arr = Arrays.copyOf(arr, max_size);
                arr[index] = element;
                size = index;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("index error in the array \n" + e.getMessage());
        }catch (ArrayStoreException e){
            System.out.println("Invalid value sent \n" + e.getMessage());
        }
    }
    public void change_arr(int max_size){
        try {
            arr = Arrays.copyOf(arr, max_size);
            this.max_size = max_size;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("index error in the array");
        }catch (ArrayStoreException e) {
            System.out.print("Invalid value sent");
        }
    }
    public void clear_arr(){
        Arrays.fill(arr, 0);
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public int getMax_size(){
        return max_size;
    }
    public String toString(){
        return Arrays.toString(arr);

    }




}

