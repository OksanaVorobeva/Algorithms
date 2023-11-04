package Lesson2;

public class Task {

    public static void main(String[] args) {
        int[] array = new int[]{
                4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        };
        //bubbleSort(array);
        //directSort(array);
        //insertSort(array);
        //System.out.println(find(array,5));
        //System.out.println(binaruSearch(array,9));
        //sort(array,0, array.length-1);
        sort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void bubbleSort(int[] array) { //O(n^2)
        boolean finish;
        do {
            finish = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = true;
                }
            }
        } while (finish);
    }

    public static void directSort(int[] array) { //O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {//O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            for (int a = i + 1; a < array.length; a++) {
                if (array[i] > array[a]) {
                    int temp = array[i];
                    array[i] = array[a];
                    array[a] = temp;
                }
            }
        }
    }

    public static int find(int[] array, int value) { //O(n)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static  int binaruSearch(int [] array,int value){
        return  binarySearch(array,value,0,array.length-1);
    }
    public static int binarySearch(int[] array, int value, int min,int max){ //O(log n)
        int minpoint;
        if(max<min){
            return -1;
        }else {
            minpoint = (max - min) / 2 + min;
        }
        if (array[minpoint]<value){
            return binarySearch(array,value,minpoint+1,max);
        }else {
            if (array[minpoint]>value){
                return binarySearch(array,value,min,minpoint-1);
            }else {
                return minpoint;
            }
        }
    }

    public static void sort(int [] array,int startPosition,int endPosition ){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition+endPosition)/2];
        do{
            while (array[leftPosition]<pivot){
                leftPosition++;
            }
            while (array[rightPosition]>pivot){
                rightPosition--;
            }
            if (leftPosition<=rightPosition){
                if (leftPosition<rightPosition){
                    int temp = array[leftPosition];
                    array[leftPosition]=array[rightPosition];
                    array[rightPosition]=temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }while (leftPosition<=rightPosition);
        if (leftPosition<endPosition){
            sort(array,leftPosition,endPosition);
        }
        if (startPosition<rightPosition){
            sort(array,startPosition,rightPosition);
        }
    }

    public  static void sort2(int[] array){
        // посмотрим кучи (перегрупируем массив)
        for (int i = array.length/2-1; i >=0; i--) {
            heapify(array,array.length,i);
        }
        //один за другим извлекаем элементы из кучи
        for (int i = array.length-1; i >=0 ; i--) {
            //перемещаем текущий корень в конец
            int temp = array[0];
            array[0]=array[i];
            array[i]=temp;
            // вызываем процедуру heapify на уменьшенной кучи
            heapify(array,i,0);
        }
    }
    private static void heapify(int[] array,int heapsize,int rootIndex){
        int largest = rootIndex; //инициализирует наибольший элемент корень
        int leftChild = 2*rootIndex+1; // левый =  2*rootIndex+1
        int rightChild = 2*rootIndex+2; // правый =  2*rootIndex+2
        // если левый дочерний элемент больше корня
        if (leftChild < heapsize && array[leftChild] > array[largest]) {
            largest=leftChild;
        }
        //если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild<heapsize && array[rightChild]>array[largest]){
            largest=rightChild;
        }
        //если самый большой элемент не корень
        if (largest!=rootIndex){
            int temp =array[rootIndex];
            array[rootIndex]=array[largest];
            array[largest]=temp;

            // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array,heapsize,largest);
        }
    }

}



