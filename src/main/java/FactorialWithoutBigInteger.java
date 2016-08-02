/**
 * Данный класс реализует вычисление суммы знаков в числе равном факториалу до 999!
 * Исходя из условий задачи класс не делался универсальным.
 * Данная реализация не предполагает экономию машинных ресурсов и экономию процессорного времени
 *
 **/
public class FactorialWithoutBigInteger {

    private final int STOP_POINT = 10000; // максимальное количество знаков в массиве
    private int value; // входные данные для расчета факториала
    private int multiplier [] = new int[3]; // массив для преобразования переменной value в массив цифр
    private int fact []  = new int[STOP_POINT]; // факториал представленный в виде массива цифр
    private int summary_array [] = new int[STOP_POINT]; //промежуточный массив для сложения массивов
    private int temporary_array [] = new int[STOP_POINT]; //промежуточный массив для умножения чисел

    FactorialWithoutBigInteger(int value){
        this.value = value;
        fact[fact.length-1] = 1;

        if (value == 1) System.out.println("Sum digits 1! = 1");
        else getFactorial();
    }

   private void getFactorial(){
        for (int i = 2; i <= value; i++){// перебор всех множителей
            multiplierToArray(i);
            int offset = 0;

            for (int k = multiplier.length - 1; k >= 0; k--){ //работа с множителями представленными в виде массива
                productOfArray(multiplier[k]);

                addArray(temporary_array, offset);
                offset++;
            }

            for (int k = 0; k < fact.length; k++) {//формирование факториала в виде массива чисел
                fact[k] = summary_array[k];
                summary_array[k] = 0;
            }
        }
    }

    private void productOfArray(int multiplier){ //реализация "умножения в столбик"
        int tmp_var = 0;
        for (int i = fact.length -1; i >= 0; i--){
            if (fact[i] * multiplier + tmp_var > 9) {
                tmp_var += fact[i] * multiplier;
                temporary_array[i] = tmp_var % 10;
                tmp_var /= 10;

            } else {
                temporary_array[i] = fact[i] * multiplier + tmp_var;
                tmp_var = 0;
            }
        }
    }

    private void addArray(int array[], int offset){ //реализация "сложения в столбик"

        int tmp_var = 0;

        for (int i = array.length-1; !(i < offset); i--){

            if (summary_array[i-offset] + array[i] + tmp_var <= 9) {
                summary_array[i-offset] += array[i]+tmp_var;
                tmp_var = 0;
            }
            else
            {
                tmp_var = summary_array[i-offset] + array[i]+tmp_var;
                summary_array[i-offset]  = tmp_var % 10;
                tmp_var /= 10;
            }
        }

    }

    public void getDigitSum(){
        int sum = 0;

        for (int i : fact) sum += i;
        System.out.print("Sum digits of " + value + "! = " + sum);
    }

    private void multiplierToArray(int value){
        for (int i = 2; i >= 0 ; i--){
            multiplier[i] =  value % 10;
            value /= 10;
        }
    }
}
