import java.util.Scanner;
import java.util.Random;

public class ArraySort{

    public static void main(String[] argv){
        menu(dicharazione());
    }

    public static int[] dicharazione(){
        System.out.println("\n----Dichiarazione----");
        System.out.println("");
        System.out.print("Inserisci la dimensione dell'array: ");

        Scanner input = new Scanner(System.in); // Scanner input

        int[] arr = new int[input.nextInt()];

        return arr;
    }

    public static int menu(int[] arr){
        int errori = 0; // ritona errori

        // menu
        System.out.println("\n----Menu----");
        System.out.println("");
        System.out.println("1) Stampa dell'array");
        System.out.println("2) Riempimento random");
        System.out.println("3) Riempimento random-ordinato");
        System.out.println("4) Riempimento Il peggiore");
        System.out.println("5) Merge Sort");
        System.out.println("6) Insertion Sort");
        System.out.println("7) Selection Sort");
        System.out.println("8) Classifica");
        System.out.println("9) Exit");
        System.out.print("Scelta> ");

        Scanner input = new Scanner(System.in); // Scanner input

        // Scelte
        switch(input.nextLine()){
            case "1":
                stampa(arr);
                menu(arr);
                break;
            case "2":
                riempi(arr);
                menu(arr);
                break;
            case "3":
                riempi_ordinato(arr);
                menu(arr);
                break;
            case "4":
                IlPeggiorCaso(arr);
                menu(arr);
                break;
            case "5":
                mergeSort(arr);
                menu(arr);
                break;
            case "6":
                insertSort(arr);
                menu(arr);
                break;
            case "7":
                selectionSort(arr);
                menu(arr);
                break;
            case "8":
                classifica(arr);
                menu(arr);
                break;
            case "9":
                //System.exit(0);
                break;
            default:
                menu(arr);
                break;
        }
        return errori;
    }

    // stampa
    public static void stampa(int[] arr){

        System.out.print("arr = [");

        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);

        System.out.println("]");
    }

    // Riempi random
    public static void riempi(int[] arr){

        Random rand = new Random();

        // inizializza fino alla fine dell'array
        for (int i=0; i < arr.length; i++)
            arr[i] = rand.nextInt(1000);
    }

    // riempi ordinato
    public static void riempi_ordinato(int[] arr){
        riempi(arr);
        mergeSort(arr);
    }

    // il peggior caso
    public static void IlPeggiorCaso(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr.length-i;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr){
        int[] arr_B = new int[arr.length];

        FullMergeSort(arr, arr_B);
    }

    // Il vero sorting
    public static void FullMergeSort(int[] arr_A, int[] arr_B){

        for (int width = 1; width < arr_A.length; width = 2 * width){
            // Array A is full of runs of length width.

            for (int i = 0; i < arr_A.length; i = i + 2 * width){
                // Merge two runs: A[i:i+width-1] and A[i+width:i+2*width-1] to B[]
                // or copy A[i:n-1] to B[] ( if(i+width >= n) )
                controlloMerge(arr_A, i, min(i+width, arr_A.length), min(i+2*width, arr_A.length), arr_B);
            }
            // Now work array B is full of runs of length 2*width.
            // Copy array B to array A for next iteration.
            copiaArray(arr_B, arr_A);
        }
    }


    public static void controlloMerge( int[] arr_A, int iLeft, int iRight, int iEnd, int[] arr_B)
    {
        int i = iLeft, j = iRight;
        // fino alla fine del limite di i designato da min tra la lunghezza * 2 e la lunghezza delll'array alla fine
        for (int k = iLeft; k < iEnd; k++) {
            // If left run head exists and is <= existing right run head.
            if (i < iRight && (j >= iEnd || arr_A[i] <= arr_A[j])) {
                arr_B[k] = arr_A[i];
                i = i + 1;
            } else {
                arr_B[k] = arr_A[j];
                j = j + 1;
            }
        }
    }

    // minimo tra due
    public static int min(int a, int b){

        if (a < b) return a;

        return b;
    }

    // procedura richiesta dal merge sort
    public static void copiaArray(int[] arr_b,int[] arr_A)
    {
        for(int i = 0; i < arr_b.length; i++)
            arr_A[i] = arr_b[i];
    }

    public static void insertSort(int[] arr){
        int value, j; // variabili

        for (int i=0; i < arr.length; i++){
            value = arr[i]; // salva il numero
            j = i-1;        // duplica l'indice

            while (j >= 0 && arr[j] > value){ // controllo
                arr[j+1] = arr[j];
                j = j-1;      // sposta l'indice
            }

            arr[j+1] = value; // scrivi il valore nel posto giusto
        }
    }

    public static void selectionSort(int[] arr){
        int pos;

        for (int i=0; i < arr.length-1; i++){
            pos = i;
            for (int j = (i+1); j < arr.length; j++){
                if (arr[j] < arr[pos])
                    pos = j;
            }
            int tmp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = tmp;
        }
    }
    public static void percent(float a, float tot){
        int i;
        
        System.out.print("\r[");
        for ( i=0; i < (int)((a/tot)*10); i++){
            System.out.print("*");
        }
        for ( int j=i; j<10; j++){
            System.out.print(" ");
        }

        System.out.printf("] %d%%", i*10);

    }

    // Classifica secondi
    public static void classifica(int[] arr){
        int[] copia = new int[arr.length];
        long time;

        System.out.println("\n----CLASSIFICA----\n\n");

        percent(0,3);
        copiaArray(arr, copia);
        /* ---- Merge Sort ---- */
        time = System.currentTimeMillis();
        mergeSort(copia);
        // tempo trascorso
        // System.out.print("Merge sort: " + (System.currentTimeMillis() - time) + "ms");
        long merge_time = System.currentTimeMillis() - time;

        percent(1,3);
        copiaArray(arr, copia); // ricopia l'array per non perderlo

        time = 0;
        /* ---- Insertion Sort ---- */
        time = System.currentTimeMillis();
        insertSort(copia);
        // tempo trascorso
        //System.out.println("Insertion sort: " + (System.currentTimeMillis() - time) + "ms");
        long insertion_time = System.currentTimeMillis() - time;

        percent(2,3);
        copiaArray(arr, copia); // ricopia l'array per non perderlo

        time = 0;
        /* ---- Insertion Sort ---- */
        time = System.currentTimeMillis();
        selectionSort(copia);
        // tempo trascorso
        // System.out.println("Selection sort: " + (System.currentTimeMillis() - time) + "ms");
        long selection_time = System.currentTimeMillis() - time;

        percent(3,3);

        System.out.println("\n\nMerge sort: " + merge_time + "ms");
        System.out.println("Insert sort: " + insertion_time + "ms");
        System.out.println("Selection sort: " + selection_time + "ms");
    }
}
